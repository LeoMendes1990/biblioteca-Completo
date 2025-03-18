package br.com.biblioteca.springboot.biblioteca.exceptions;

public class ObjectNotFoundExceptions extends RuntimeException{
    public ObjectNotFoundExceptions(String message) {
        super(message);
    }
}
