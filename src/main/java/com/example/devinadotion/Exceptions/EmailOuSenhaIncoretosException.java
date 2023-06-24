package com.example.devinadotion.Exceptions;

public class EmailOuSenhaIncoretosException extends HttpException {
    public EmailOuSenhaIncoretosException() {
        super.message = "E-mail ou senha invalidos.";
        super.status = 400;
    }
}