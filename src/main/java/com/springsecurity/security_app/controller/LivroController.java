package com.springsecurity.security_app.controller;

import com.springsecurity.security_app.model.entity.Livro;
import com.springsecurity.security_app.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> findAll(){
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public Livro findById(@PathVariable Long id){
        return livroService.findById(id);
    }

    @PostMapping
    public Livro create(@RequestBody Livro request){
        return livroService.create(request);
    }
}
