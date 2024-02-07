package library;

import library.enums.Status;
import library.interfaces.Borrowable;

public abstract class LibraryItem implements Borrowable {

    private Status status;

    public LibraryItem(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean borrowItem() {
        if(this.getStatus() == Status.AVAILABLE){
            this.setStatus(Status.BORROWED);
            return true;
        }
        return false;
    }

    @Override
    public boolean returnItem() {
        if(this.getStatus() != Status.AVAILABLE){
            this.setStatus(Status.AVAILABLE);
            return true;
        }
        return false;
    }

    public boolean isBorrowed(){
        return this.getStatus() == Status.BORROWED;
    }
}
