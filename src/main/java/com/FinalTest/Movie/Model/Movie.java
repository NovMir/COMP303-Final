package com.FinalTest.Movie.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Movie")

public class Movie {
    @Id
    private String movieId = UUID.randomUUID().toString();
    private String movieTitle;
    private Integer releaseYear;
    private String language;
    private BigDecimal rentalPrice;
    private LocalDate rentalDate;
    private boolean isRented =false;

}
