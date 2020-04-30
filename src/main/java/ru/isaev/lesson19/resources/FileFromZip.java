package ru.isaev.lesson19.resources;

class FileFromZip {
    final String NAME;
    final byte[] BODY;

    FileFromZip(String name, byte[] body) {
        NAME = name;
        BODY = body;
    }
}
