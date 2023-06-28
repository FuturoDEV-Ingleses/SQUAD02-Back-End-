package com.senai.devinadoption.enums;

public enum Produto {
    RACAO("Ração"),
    ANTIPARASITARIO("Antiparasitário"),
    ANTIPULGAS("Antipulgas");

    private final String value;
    Produto(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public static boolean isValidEnumValue(String value) {
        for (Produto tipo : Produto.values()) {
            if (tipo.getValue().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
    public static Produto fromValue(String value) {
        for (Produto tipo : Produto.values()) {
            if (tipo.getValue().equalsIgnoreCase(value)) {
                return tipo;
            }
        }
        return null;
    }
}
