package com.senai.devinadoption.enums;

public enum Animal {
    CACHORRO("CACHORRO"),
    GATO("GATO");

    private final String value;

    Animal(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public static boolean isValidEnumValue(String value) {
        for (Animal animal : Animal.values()) {
            if (animal.getValue().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
    public static Animal fromValue(String value) {
        for (Animal animal : Animal.values()) {
            if (animal.getValue().equalsIgnoreCase(value)) {
                return animal;
            }
        }
        throw new IllegalArgumentException("Animal inválido: " + value);
    }
    public static boolean contains(Animal animal) {
        for (Animal value : Animal.values()) {
            if (value == animal) {
                return true;
            }
        }
        return false;
    }
}

