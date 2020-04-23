package ru.isaev.lesson15;

import java.io.Serializable;

class MyObjectForFile implements Serializable {
    final int A = 12345;
    final String B = "Мой объект";
    final char[] C = {'м', 'о', 'й'};
}
