package com.senai.devinadoption.enums;

public enum Categoria {
    FILHOTE("FILHOTE"),
    ADULTO("ADULTO");

    private final String value;
    Categoria(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public static boolean isValidEnumValue(String value) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.getValue().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public static Categoria fromValue(String value) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.getValue().equalsIgnoreCase(value)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Categoria inválida: " + value);
    }
}