package ru.isaev.lesson06;

class Inhabitant {
    private House placeOfResidence;

    Inhabitant(House placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }

    String getPlace() {
        return placeOfResidence.address;
    }
}
