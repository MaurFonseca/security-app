package com.springsecurity.security_app.service;

import com.springsecurity.security_app.model.entity.Livro;
import com.springsecurity.security_app.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public Livro findById(Long id){
        return livroRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Livro não encontrado"));
    }

    public Livro create(Livro request){
        Livro livro = new Livro(null, request.getName(), request.getPrice());
        livroRepository.save(livro);
        return livro;
    }
}
