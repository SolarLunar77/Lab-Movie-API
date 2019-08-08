package co.grandcircus.MovieAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.MovieAPI.dao.MovieAPIRepository;
import co.grandcircus.MovieAPI.entity.Movie;


@RestController
public class MovieAPIController {
	
	@Autowired
	private MovieAPIRepository dao;
	
	@GetMapping("/movies")
	public List<Movie> listMovies(
			@RequestParam(value="category", required=false) String category, 
			@RequestParam(value="title",required=false)String title) {
		if ((category == null || category.isEmpty()) && 
				(title == null || title.isEmpty())) {
			return dao.findAll();
		} else if(title == null || title.isEmpty()){			
			return dao.findByCategory(category);
		}	else {
			return dao.findByTitleContainsIgnoreCase(title);
		}

	}
	
	@GetMapping("/movie/{id}")
	public Movie getMovie(@PathVariable("id") Long id) {
		if (id < 1 || id > 5) {
			return null;
		}
		return dao.findById(id).get();	
	}
		
	
	@GetMapping("/categories")
	public List<String> listOfCategories() {
		return dao.getCategories();
	}
	
	
//	@GetMapping("/movies/random-list?quantity")
//	public List<String> randomList() {
//		return dao.getRandomList();
//	}
	
	
//	@GetMapping("/movies/random-list?quantity")
//	public Movie getRandomList(@RequestParam("id") Long id) {
//		
//		System.out.println();
//		if (id < 1 || id > 5) {
//			return null;
//		}
//		return dao.findById(id).get();	
//	}
	
	
//	@GetMapping("movies/random-list")
//    public List<Movie> randomMovieList(@RequestParam("quantity")Integer quantity) {
//        List<Movie> movieList = dao.findAll();
//        List<Movie> randomMovieList = new ArrayList<Movie>();
//        Collections.shuffle(movieList);
//        for (int i = 0; i < quantity; ++i) {
//        	randomMovieList.add(movieList.get(i));
//        }
//		return randomMovieList;
//        
//	}
	
}
	
