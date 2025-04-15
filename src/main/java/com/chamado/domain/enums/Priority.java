package com.chamado.domain.enums;

import lombok.Getter;

@Getter
public enum Priority {

    LOW(1, "Baixa"),
    MEDIA(2, "Media"),
    HIGH(3, "Alta");

    private Integer type;
    private String name;

    Priority(Integer type, String name) {
        this.type = type;
        this.name = name;
    }
}
