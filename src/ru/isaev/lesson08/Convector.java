package ru.isaev.lesson08;

final class Convector {
    static Act convert(Contract in) {
        return new Act(in.number, in.products, in.date);
    }
}
