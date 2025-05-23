package br.com.biblioteca.springboot.biblioteca.dtos;

import br.com.biblioteca.springboot.biblioteca.models.Livro;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO {
    private Integer id;
    private String nome;
    private String descricao;

    private List<Livro> livro = new ArrayList<>();

    public CategoriaDTO() {
    }

    public CategoriaDTO(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Livro> getLivro() {
        return livro;
    }

    public void setLivro(List<Livro> livro) {
        this.livro = livro;
    }
}
