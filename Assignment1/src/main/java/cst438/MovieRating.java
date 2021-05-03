package cst438;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieRating {

	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping("/movie/new")
	public String createMovie(Model model) {
		Movie movie = new Movie();	
		model.addAttribute("movie", movie);
		return "movie_form";
	}
	
	@PostMapping("/movie")
	public String processMovieForm(@Valid Movie movie,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "movie_form";
		}
		movieRepository.save(movie);
		return "movie_show";
	}
	@GetMapping("/movie")
	public String getAllMovies(Model model) {
		List<Movie> movie_list = movieRepository.findAllMoviesOrderByTitleDateDesc();
		model.addAttribute("movie", movie_list);
		return "movie_list";
	}
	
}
