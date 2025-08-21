import { Component } from '@angular/core';
import { Movie } from '../movie';
import { MovieService } from '../movie-service';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-movie',
  imports: [FormsModule],
  templateUrl: './movie.html',
  styleUrl: './movie.css'
})
export class MovieComponent {
  movies: Movie[] = [];
  newMovie: Movie = { movieId: 0, movieName: '', language: '', imdbRating: 0 };
  editingMovie: Movie | null = null;

  constructor(private movieService: MovieService) {
    this.movies = this.movieService.getMovies();
  }

  addMovie() {
    this.movieService.addMovie({ ...this.newMovie });
    this.newMovie = { movieId: 0, movieName: '', language: '', imdbRating: 0 };
  }

  editMovie(movie: Movie) {
    this.editingMovie = { ...movie };
  }

  updateMovie() {
    if (this.editingMovie) {
      this.movieService.updateMovie(this.editingMovie);
      this.editingMovie = null;
    }
  }

  deleteMovie(id: number) {
    this.movieService.deleteMovie(id);
    this.movies = this.movieService.getMovies();
  }
}
