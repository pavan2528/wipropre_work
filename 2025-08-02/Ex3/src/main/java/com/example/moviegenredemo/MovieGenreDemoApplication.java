package com.example.moviegenredemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieGenreDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieGenreDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(MovieRepository movieRepo, GenreRepository genreRepo) {
        return args -> {
            Genre action = new Genre("Action");
            Genre thriller = new Genre("Thriller");
            Genre adventure = new Genre("Adventure");
            genreRepo.save(action);
            genreRepo.save(thriller);
            genreRepo.save(adventure);

            Movie m1 = new Movie("Inception");
            m1.getGenres().add(action);
            m1.getGenres().add(thriller);

            Movie m2 = new Movie("Interstellar");
            m2.getGenres().add(adventure);
            m2.getGenres().add(action);

            movieRepo.save(m1);
            movieRepo.save(m2);

            System.out.println("Movies and Genres saved successfully!");
        };
    }
}
