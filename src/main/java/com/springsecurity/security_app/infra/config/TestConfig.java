package com.springsecurity.security_app.infra.config;

import com.springsecurity.security_app.model.entity.Livro;
import com.springsecurity.security_app.model.entity.User;
import com.springsecurity.security_app.model.enums.UserRole;
import com.springsecurity.security_app.repository.LivroRepository;
import com.springsecurity.security_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {


    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        Livro l1 = new Livro(null, "Senhor dos Aneis", 20.5);
        Livro l2 = new Livro(null, "Hobbit", 25.5);

        String password = new BCryptPasswordEncoder().encode("123456");
        User user = new User(null, "admin", password, UserRole.ADMIN);


        livroRepository.saveAll(Arrays.asList(l1, l2));
        userRepository.save(user);
    }
}
