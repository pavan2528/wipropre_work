package com.example.social.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;


}
