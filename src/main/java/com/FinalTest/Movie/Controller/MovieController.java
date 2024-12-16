package com.FinalTest.Movie.Controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// For List
import org.springframework.ui.Model;        
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.FinalTest.Movie.Model.Movie;
import com.FinalTest.Movie.Repository.MovieRepository;

@Controller

public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping("/")
    public String showMovies(Model model) {
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        model.addAttribute("movieCount", movies.size()); 
        model.addAttribute("movieRepository", movieRepository);
      return "index";
    }
	
    @GetMapping("/movie/new")
    public String showNewMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie-form";
    }

    // Show edit form
    @GetMapping("/movie/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
    	Movie movie = movieRepository.findByMovieId(id);
    	   model.addAttribute("movie", movie);
        return "movie-form";
    }
    @PostMapping("/movie/update")
    public String updateMovie(@ModelAttribute Movie movie) {
        movieRepository.save(movie);
        return "redirect:/"; // Redirects to home page after updating
    }
    @PostMapping("/movie/add")
    public String addMovie(@ModelAttribute Movie movie) {
        movieRepository.save(movie);
        return "redirect:/";  
    }
    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable String id) {
        movieRepository.deleteById(id);
        return "redirect:/";
    }
    // Show available movies
    @GetMapping("/movie/available")
    public String showAvailableMovies(Model model) {
        List<Movie> availableMovies = movieRepository.findAvailableMovies(); // Using your existing query method
        model.addAttribute("movies", availableMovies);  // Changed to "movies"
        model.addAttribute("movieCount", availableMovies.size());
        return "index";

}
}
