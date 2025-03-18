package br.com.biblioteca.springboot.biblioteca.services;

import br.com.biblioteca.springboot.biblioteca.dtos.LivroDTO;
import br.com.biblioteca.springboot.biblioteca.exceptions.ObjectNotFoundExceptions;
import br.com.biblioteca.springboot.biblioteca.models.Livro;
import br.com.biblioteca.springboot.biblioteca.repositories.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    public Livro create(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro findById(Integer id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()) {
            return livroOptional.get();
        }
        return null;
    }

    public List<Livro> findAll() {
        List<Livro> list = livroRepository.findAll();
        return list;
    }

    public Livro update(Integer id, LivroDTO livroDTOAtualizado) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()) {
            Livro livroAtualizar = livroOptional.get();
            BeanUtils.copyProperties(livroDTOAtualizado, livroAtualizar);
            return livroRepository.save(livroAtualizar);
        }
        throw new ObjectNotFoundExceptions("Livro não encontrado!! ");
    }

    public Boolean delete(Integer id) {
        Livro livro = findById(id);
        if (livro == null) {
            throw new ObjectNotFoundExceptions("Livro não encontrado!! ");
        }
        livroRepository.deleteById(id);
        return true;

    }

}
