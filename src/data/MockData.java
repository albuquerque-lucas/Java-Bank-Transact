package data;

import model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MockData {
    public static List<Movie> getMovies() {
     List<Movie> movies = new ArrayList<>();
         movies.add(new Movie("Top Gun: Maverik", 2022));
         movies.add(new Movie("Spiderman: Homecome", 2017));
         movies.add(new Movie("Avatar: The Way Of Water", 2023));
         movies.add(new Movie("The Da Vinci Code", 2006));
         return movies;
    }
}
