package com.springsecurity.security_app.repository;

import com.springsecurity.security_app.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
