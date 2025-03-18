package br.com.biblioteca.springboot.biblioteca.services;

import br.com.biblioteca.springboot.biblioteca.dtos.CategoriaDTO;
import br.com.biblioteca.springboot.biblioteca.exceptions.ObjectNotFoundExceptions;
import br.com.biblioteca.springboot.biblioteca.models.Categoria;
import br.com.biblioteca.springboot.biblioteca.repositories.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria create(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria findById(Integer id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        if (cat.isPresent()) {
            return cat.get();
        }
        throw new ObjectNotFoundExceptions("objeto nao encontrado");
    }

    public List<Categoria> findAll() {
        List<Categoria> list = categoriaRepository.findAll();
        return list;
    }


    public Categoria update(Integer id, CategoriaDTO categoriaAtualizar) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if (optionalCategoria.isPresent()) {
            Categoria categoriaAtual = optionalCategoria.get();
            BeanUtils.copyProperties(categoriaAtualizar, categoriaAtual);
            return categoriaRepository.save(categoriaAtual);
        }
        throw new ObjectNotFoundExceptions("Categoria Não encontrada!! ");
    }
    public Boolean delete(Integer id){
        Categoria categoria = findById(id);
        if (categoria.getLivro().isEmpty()){
            categoriaRepository.deleteById(id);
            return true;
        }
        throw new DataIntegrityViolationException("Categoria não pode ser Excluido por que existe Livros!! ");
    }
}
