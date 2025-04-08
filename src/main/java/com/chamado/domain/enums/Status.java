package com.chamado.domain.enums;

public enum Status {
    OPEN(1, "Aberto"),
    CLOSED(2, "Fechado");

    private Integer type;
    private String name;

    Status(Integer type, String name) {
        this.type = type;
        this.name = name;
    }
}
