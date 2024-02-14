package streamApi.optionale;

import java.math.BigDecimal;

public class Pracownik {

    private static int ID = 0;

    private int id;
    private String imie;
    private String nazwisko;
    private int wiek;
    private Dzial dzial;
    private BigDecimal pensja;

    public Pracownik(String imie, String nazwisko, int wiek, Dzial dzial, BigDecimal pensja) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.dzial = dzial;
        this.pensja = pensja;
        this.id = ++ ID;
    }

    public  int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public Dzial getDzial() {
        return dzial;
    }

    public void setDzial(Dzial dzial) {
        this.dzial = dzial;
    }

    public BigDecimal getPensja() {
        return pensja;
    }

    public void setPensja(BigDecimal pensja) {
        this.pensja = pensja;
    }
}
