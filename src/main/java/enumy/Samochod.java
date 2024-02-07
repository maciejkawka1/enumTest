package enumy;

public enum Samochod {
    SPALINOWY(true,false),
    ELEKTRYCZNY(false,true);

    private boolean czyMoznaTankowac = false;
    private boolean czyMoznaLadowac = false;

    Samochod(boolean czyMoznaTankowac, boolean czyMoznaLadowac){
        this.czyMoznaLadowac = czyMoznaLadowac;
        this.czyMoznaTankowac = czyMoznaTankowac;
    }

    Samochod(){ }

    public boolean czyMoznaTankowac() {
        return this.czyMoznaTankowac;
    }

    public boolean czyMoznaLadowac() {
        return this.czyMoznaLadowac;
    }
}
