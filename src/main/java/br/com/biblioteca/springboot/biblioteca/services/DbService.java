package br.com.biblioteca.springboot.biblioteca.services;

import br.com.biblioteca.springboot.biblioteca.enuns.Tamanho;
import br.com.biblioteca.springboot.biblioteca.models.Categoria;
import br.com.biblioteca.springboot.biblioteca.models.Livro;
import br.com.biblioteca.springboot.biblioteca.repositories.CategoriaRepository;
import br.com.biblioteca.springboot.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbService {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    LivroRepository livroRepository;

    public void intanciaDB(){
        Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");
        Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
        Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");


        Livro l1 = new Livro(null, "Clean code", "Robertin Martin", "Lorem ipsum", Tamanho.Grande, cat1);
        Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", Tamanho.Grande, cat1);
        Livro l3 = new Livro(null, "The time machine", "H. G. Wells", "Lorem ipsum", Tamanho.Medio, cat2);
        Livro l4 = new Livro(null, "The war of the worlds", "H. G. Wells", "Lorem ipsum", Tamanho.Pequeno, cat2);
        Livro l5 = new Livro(null, "I, robot", "Isaac Asimov", "Lorem ipsum", Tamanho.Grande, cat2);

        cat1.getLivro().addAll(Arrays.asList(l1, l2));
        cat2.getLivro().addAll(Arrays.asList(l3, l4, l5));
        cat3.getLivro().addAll(Arrays.asList());


        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

        //testando

    }
}
