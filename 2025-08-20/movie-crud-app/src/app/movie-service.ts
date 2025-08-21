import { Injectable } from '@angular/core';
import { Movie } from './movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private movies: Movie[] = [
    { movieId: 1, movieName: 'Inception', language: 'English', imdbRating: 8.8 },
    { movieId: 2, movieName: '3 Idiots', language: 'Hindi', imdbRating: 8.4 }
  ];

  addMovie(movie: Movie): void {
    this.movies.push(movie);
  }

  getMovies(): Movie[] {
    return this.movies;
  }

  updateMovie(updated: Movie): void {
    const index = this.movies.findIndex(m => m.movieId === updated.movieId);
    if (index !== -1) {
      this.movies[index] = updated;
    }
  }

  deleteMovie(movieId: number): void {
    this.movies = this.movies.filter(m => m.movieId !== movieId);
  }
}
