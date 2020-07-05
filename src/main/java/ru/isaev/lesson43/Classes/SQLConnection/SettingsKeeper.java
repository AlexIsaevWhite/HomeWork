package ru.isaev.lesson43.Classes.SQLConnection;

import ru.isaev.lesson43.Interfaces.ILoggable;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public abstract class SettingsKeeper implements ILoggable {
    private final static Path DEFAULT_PATH = Paths.get("SQLSettings");

    public static SqlConnection readFile(String filename) {
        File file = new File(DEFAULT_PATH.toString(), filename + ".bin");
        try {
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                 ObjectInputStream ois = new ObjectInputStream(Base64.getDecoder().wrap(bis))) {
                Object readObject = ois.readObject();
                if (readObject instanceof SqlConnection) {
                    return (SqlConnection) readObject;
                } else {
                    throw new ClassNotFoundException();
                }
            } catch (FileNotFoundException e) {
                boolean isCreated = file.getParentFile().mkdirs() && file.createNewFile();
                LOGGER.warn("File not found. New file is created: " + isCreated);
            } catch (ClassNotFoundException e) {
                LOGGER.trace("File is broken. New file is created: " + file.createNewFile());
            }
        } catch (IOException e) {
            LOGGER.trace(e);
        }
        return null;
    }

    public static boolean writeFile(String filename, SqlConnection sqlConnection) {
        File file = new File(DEFAULT_PATH.toString(), filename + ".bin");
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
             ObjectOutputStream oos = new ObjectOutputStream(Base64.getEncoder().wrap(bos))) {
            oos.writeObject(sqlConnection.getCopy());
            return true;
        } catch (FileNotFoundException e) {
            LOGGER.trace("Path to file is not exist. Path is created: " + file.getParentFile().mkdirs());
        } catch (IOException e) {
            LOGGER.trace(e);
        }
        return false;
    }
}