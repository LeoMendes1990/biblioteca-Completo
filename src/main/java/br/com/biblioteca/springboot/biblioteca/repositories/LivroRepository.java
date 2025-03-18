package br.com.biblioteca.springboot.biblioteca.repositories;

import br.com.biblioteca.springboot.biblioteca.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
