package com.senai.devinadoption.exeptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"suppressed", "localizedMessage", "cause", "stackTrace"})
public class NomeArmazemObrigatorioException extends RuntimeException {
    public NomeArmazemObrigatorioException() {
        super("O nome do armazém é obrigatório.");
    }
}

