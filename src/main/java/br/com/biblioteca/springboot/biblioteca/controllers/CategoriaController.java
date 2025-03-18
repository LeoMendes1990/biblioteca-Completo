package br.com.biblioteca.springboot.biblioteca.controllers;

import br.com.biblioteca.springboot.biblioteca.dtos.CategoriaDTO;
import br.com.biblioteca.springboot.biblioteca.models.Categoria;
import br.com.biblioteca.springboot.biblioteca.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = modelMapper.map(categoriaDTO, Categoria.class);
        categoria = categoriaService.create(categoria);
        CategoriaDTO categoriaDTORetorno = modelMapper.map(categoria, CategoriaDTO.class);
        return ResponseEntity.ok(categoriaDTORetorno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Integer id) {
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.ok(modelMapper.map(categoria, CategoriaDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = categoriaService.findAll();
        return ResponseEntity.ok().body(list.stream().map(obj -> modelMapper.map(obj, CategoriaDTO.class)).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaService.update(id, categoriaDTO);
        return ResponseEntity.ok().body(modelMapper.map(categoria, CategoriaDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        categoriaService.delete(id);
        return ResponseEntity.ok("Categoria Excluida!! ");
    }
}
