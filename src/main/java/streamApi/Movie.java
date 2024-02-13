package streamApi;

import java.time.LocalDate;

public class Movie {

    public Movie(String type, long duration, LocalDate releaseDate,String tytul) {
        this.type = type;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.title = tytul;
    }

    String title;
    String type;
    long duration;
    LocalDate releaseDate;
}