package library;

import library.enums.Status;

import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Book b1 = new Book(Status.AVAILABLE,"tytul1","autor1",2000);
        Book b2 = new Book(Status.BORROWED,"tytul2","autor2",2022);
        Book b3 = new Book(Status.AVAILABLE,"tytul3","autor3",2011);
        Book b4 = new Book(Status.AVAILABLE,"tytul4","autor4",20023);

        NewsPaper n1 = new NewsPaper(Status.RESERVED, LocalDate.parse("2021-09-11"),"wyd1");
        NewsPaper n2 = new NewsPaper(Status.RESERVED,LocalDate.parse("2023-09-22"),"wyd2");
        NewsPaper n3 = new NewsPaper(Status.RESERVED,LocalDate.parse("2022-08-11"),"wyd3");
        NewsPaper n4 = new NewsPaper(Status.RESERVED,LocalDate.parse("2018-11-11"),"wyd4");

        System.out.println(b1.isBorrowed());
        System.out.println(b2.isBorrowed());
        System.out.println(b3.isBorrowed());
        System.out.println(b4.isBorrowed());

        System.out.println("================");
        System.out.println(b1.borrowItem());
        System.out.println(b1.isBorrowed());
        System.out.println("================");
        System.out.println(b1.returnItem());
        System.out.println(b1.isBorrowed());
        System.out.println("================");
        System.out.println(b1.getAuthor());
        System.out.println(b2.getAuthor());
        System.out.println(b3.getAuthor());
        System.out.println(b4.getAuthor());
    }
}
