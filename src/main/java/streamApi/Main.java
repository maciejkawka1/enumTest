package streamApi;

/*
Korzystając z Stream API, napisz funkcję, która dla poniższego przykładu:
     List<Movie> movies = Arrays.asList(….)

    gdzie Movie to klasa
    class Movie {
    String title;
    String type;
    long duration;//min
    LocalDate releaseDate
    }

zwróci listę filmów, gdzie:
- długość filmu będzie większa niż 20 min
- rok wydania nie będzie starszy niż 2018
- typ to horror
 */

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {



    public static void main(String[] args) {

        Predicate<Movie> durationFilter = x -> x.duration > 20;
        Predicate<Movie> typeFilter = x -> x.type.equals("horror");
        Predicate<Movie> releaseDateFilter = x -> x.releaseDate.isAfter(LocalDate.of(2018, 1, 1));

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("horror",40,LocalDate.of(2018,3,12),"tytul1"));
        movies.add(new Movie("horror",90,LocalDate.of(2019,3,12),"tytul2"));
        movies.add(new Movie("komedia",50,LocalDate.of(2010,3,12),"tytul3"));
        movies.add(new Movie("horror",90,LocalDate.of(2011,3,12),"tytul4"));
        movies.add(new Movie("horror",100,LocalDate.of(2009,3,12),"tytul5"));

        List<Movie> filtered = filterMovies(movies,durationFilter,typeFilter,releaseDateFilter);
        filtered.forEach( movie -> System.out.println(movie.title));






    }


    public static List<Movie> filterMovies(List<Movie> movies, Predicate<Movie> filter1, Predicate<Movie> filter2, Predicate<Movie> filter3){
        return movies.stream()
                .filter(filter1)
                .filter(filter2)
                .filter(filter3)
                .toList();
    }

}
