package com.senai.devinadoption.exeptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"suppressed", "localizedMessage", "cause", "stackTrace"})
public class TipoAnimalInvalidoException extends RuntimeException {

        public TipoAnimalInvalidoException(String animal) {
            super("O tipo de animal '" + animal + "' do armazém é inválido. Deve ser 'Gato' ou 'Cachorro'.");
        }
    }


