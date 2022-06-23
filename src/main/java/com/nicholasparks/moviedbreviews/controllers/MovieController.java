package com.nicholasparks.moviedbreviews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.nicholasparks.moviedbreviews.models.Movie;
import com.nicholasparks.moviedbreviews.services.MovieService;


@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	// Display list of movies
	@GetMapping("/movies")
	public String viewMovies(Model model) {
		model.addAttribute("listMovies", movieService.getAllMovies());
		return "movies";
	}
	
	@GetMapping("/addMovieForm")
	public String newMovieForm(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "new_movie";
	}
	
	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie movie) {
		// save the new movie to the database
		movieService.saveMovie(movie);
		return "redirect:/movies";
	}
	
	@GetMapping("/movieUpdateForm/{id}")
	public String movieUpdateForm(@PathVariable (value = "id") Long movieId, Model model) {
		// Get movie from service 
		Movie movie = movieService.getMovieById(movieId);
		// Set movie as model attribute to pre-populate the form
		model.addAttribute("movie", movie);
		return "update_movie";
	}
	
	@GetMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable (value = "id") Long movieId) {
		// call delete movie method
		this.movieService.deleteMovieById(movieId);
		return "redirect:/movies";
	}
	
}
