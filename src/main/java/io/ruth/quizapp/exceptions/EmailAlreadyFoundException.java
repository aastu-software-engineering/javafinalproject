package io.ruth.quizapp.exceptions;

public class EmailAlreadyFoundException extends Exception{
    public EmailAlreadyFoundException(String message) {
        super(message);
    }
}
