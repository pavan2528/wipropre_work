package com.example.social.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data // <-- This generates getters like getPosts()
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Post> posts;  // ✅ Make sure this exists

    

}
