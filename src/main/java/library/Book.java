package library;

import library.enums.Status;

import java.time.Year;


public class Book extends LibraryItem {

    private String title, author;
    private int yearPublished;

    public Book(Status status, String title, String author, int yearPublished) {
        super(status);
        this.title = title;
        this.yearPublished = yearPublished;
        if(isOlderThenFiveYeas(yearPublished))
            this.author = author.toUpperCase();
        else
            this.author = author;
    }

    private boolean isOlderThenFiveYeas(int year){
        int currentYear = Year.now().getValue();

        return (currentYear - year) > 5;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }


}
