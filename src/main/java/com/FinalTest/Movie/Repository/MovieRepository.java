package com.FinalTest.Movie.Repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.FinalTest.Movie.Model.Movie;
@Repository

public interface MovieRepository extends MongoRepository<Movie, String> {
	@Query

	
	// Find by movie title
    List<Movie> findByMovieTitle(String movieTitle);
    
    //Less than or equal to
    @Query("{ 'rentalPrice': { $lte: ?0 } }")
    List<Movie> findByPriceLessThanEqual(double price);
    
 // Find all available movies (not rented)
    @Query("{ 'isRented': false }")
    List<Movie> findAvailableMovies();
    
    //Find by ID
    @Query("{ 'movieId': ?0 }")
    Movie findByMovieId(String movieId);

}
