package com.springsecurity.security_app.config;

import com.springsecurity.security_app.model.entity.Livro;
import com.springsecurity.security_app.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {


    @Autowired
    private LivroRepository livroRepository;

    @Override
    public void run(String... args) throws Exception {

        Livro l1 = new Livro(null, "Senhor dos Aneis", 20.5);
        Livro l2 = new Livro(null, "Hobbit", 25.5);

        livroRepository.saveAll(Arrays.asList(l1, l2));
    }
}
