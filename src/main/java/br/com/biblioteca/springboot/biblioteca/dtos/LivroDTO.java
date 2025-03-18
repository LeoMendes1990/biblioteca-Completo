package br.com.biblioteca.springboot.biblioteca.dtos;

import br.com.biblioteca.springboot.biblioteca.enuns.Tamanho;
import br.com.biblioteca.springboot.biblioteca.models.Categoria;
import jakarta.persistence.ManyToOne;

public class LivroDTO {
    private Integer id;
    private String titulo;
    private String nome_autor;
    private String texto;
    private Tamanho tamanho;

    private Categoria categoria;

    public LivroDTO() {
    }

    public LivroDTO(Integer id, String titulo, String nome_autor, String texto, Tamanho tamanho, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.tamanho = tamanho;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
