package com.example.devinadotion.enums;

public enum TipoProduto {
    RACAO("Ração"),
    ANTIPARASITARIO("Antiparasitário"),
    ANTIPULGAS("Antipulgas"),
    ANIMAL("Gato , Cachorro");

    private final String value;

    TipoProduto(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isValidEnumValue(String value) {
        for (TipoProduto tipo : TipoProduto.values()) {
            if (tipo.getValue().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public static TipoProduto fromValue(String value) {
        for (TipoProduto tipo : TipoProduto.values()) {
            if (tipo.getValue().equalsIgnoreCase(value)) {
                return tipo;
            }
        }
        return null;
    }
}