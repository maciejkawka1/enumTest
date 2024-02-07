package library.enums;

public enum Status {

    AVAILABLE("dostępny"),
    BORROWED("wypożyczomy"),
    RESERVED("zarezerwowany");

    private String status;

    Status(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
