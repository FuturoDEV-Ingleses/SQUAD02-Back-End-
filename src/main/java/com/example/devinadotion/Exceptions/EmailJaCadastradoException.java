package com.example.devinadotion.Exceptions;

public class EmailJaCadastradoException extends HttpException {
    public EmailJaCadastradoException() {
        super.message = "O email já está cadastrado.";
        super.status = 400;
    }
}