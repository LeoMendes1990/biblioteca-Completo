package br.com.biblioteca.springboot.biblioteca.repositories;

import br.com.biblioteca.springboot.biblioteca.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
