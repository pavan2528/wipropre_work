package com.example.moviegenredemo;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies = new HashSet<>();

    public Genre() {}

    public Genre(String description) {
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Set<Movie> getMovies() { return movies; }
    public void setMovies(Set<Movie> movies) { this.movies = movies; }
}
