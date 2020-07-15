package io.naimi.movies.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {
    @Id
    private String id;
    private String movieId;
    private String title;
    private String genres;
}
