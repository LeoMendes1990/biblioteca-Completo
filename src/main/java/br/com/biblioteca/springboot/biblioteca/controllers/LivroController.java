package br.com.biblioteca.springboot.biblioteca.controllers;

import br.com.biblioteca.springboot.biblioteca.dtos.LivroDTO;
import br.com.biblioteca.springboot.biblioteca.models.Livro;
import br.com.biblioteca.springboot.biblioteca.services.LivroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    LivroService livroService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<LivroDTO> create(@RequestBody LivroDTO livroDTO) {
        Livro livro = modelMapper.map(livroDTO, Livro.class);
        livro = livroService.create(livro);
        LivroDTO livroRetorno = modelMapper.map(livro, LivroDTO.class);
        return ResponseEntity.ok(livroRetorno);

    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO>findById(@PathVariable Integer id){
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok(modelMapper.map(livro,LivroDTO.class));
    }
    @GetMapping
    public ResponseEntity<List<LivroDTO>>findaAll(){
        List<Livro>listLivros = livroService.findAll();
        return ResponseEntity.ok().body(listLivros.stream().map(obj->modelMapper.map(obj,LivroDTO.class)).collect(Collectors.toList()));
    }
    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO>update(@PathVariable Integer id, @RequestBody LivroDTO livroDTO){
        Livro livro = livroService.update(id, livroDTO);
        return ResponseEntity.ok(modelMapper.map(livro, LivroDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>delete(@PathVariable Integer id){
        livroService.delete(id);
        return ResponseEntity.ok("Livro Excluido!!");
    }
}
