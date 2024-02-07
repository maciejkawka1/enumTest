package library;

import library.enums.Status;

import java.time.LocalDate;
import java.util.Date;

public class NewsPaper extends LibraryItem{

    private LocalDate lastEdition;
    private String printingHouse;

    public NewsPaper(Status status, LocalDate lastEdition, String printingHouse) {
        super(status);
        this.lastEdition = lastEdition;
        this.printingHouse = printingHouse;
    }


}
