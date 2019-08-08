package co.grandcircus.MovieAPI.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.grandcircus.MovieAPI.entity.Movie;



public interface MovieAPIRepository extends JpaRepository<Movie, Long> {

	List<Movie> findByCategory(String category);
	
	List<Movie> findByTitleContainsIgnoreCase(String title);
	
	@Query("SELECT DISTINCT category FROM Movie")
	List<String> getCategories();
	
	
//	@Query("SELECT * FROM movie ORDER BY rand() LIMIT 3")
//	List<String> getRandomList();
	
}



