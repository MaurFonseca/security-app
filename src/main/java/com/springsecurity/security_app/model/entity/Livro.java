package com.springsecurity.security_app.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_livro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;
}
