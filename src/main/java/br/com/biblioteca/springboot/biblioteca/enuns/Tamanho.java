package br.com.biblioteca.springboot.biblioteca.enuns;

public enum Tamanho {
    Pequeno(0),
    Medio(1),
    Grande(2);
    private int cod;

    Tamanho(int cod) {
        this.cod = cod;
    }
}
