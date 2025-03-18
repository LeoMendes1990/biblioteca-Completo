package br.com.biblioteca.springboot.biblioteca.exceptions;

public class IllegalArgumentExceptions extends RuntimeException{
    public IllegalArgumentExceptions(String message) {
        super(message);
    }
}
