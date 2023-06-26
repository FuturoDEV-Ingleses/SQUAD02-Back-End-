package com.example.devinadotion.enums;

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




}
