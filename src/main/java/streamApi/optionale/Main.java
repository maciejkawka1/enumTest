package streamApi.optionale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Pracownik> pracownicy = new ArrayList<>();
        pracownicy.add(new Pracownik("Karol", "Karolowski", 29, Dzial.Sales, new BigDecimal(5900)));
        pracownicy.add(new Pracownik("Wojtek", "Mos", 34, Dzial.IT, new BigDecimal(9900)));
        pracownicy.add(new Pracownik("Natalia", "Pol", 45, Dzial.HR, new BigDecimal(4900)));
        pracownicy.add(new Pracownik("Aleksander", "Nowak", 48, Dzial.IT, new BigDecimal(4900)));
        pracownicy.add(new Pracownik("Patrycja", "Czech", 29, Dzial.IT, new BigDecimal(12000)));
        pracownicy.add(new Pracownik("Ilona", "Woś", 43, Dzial.Sales, new BigDecimal(8000)));
        pracownicy.add(new Pracownik("Cezary", "Kozioł", 26, Dzial.HR, new BigDecimal(6900)));
        pracownicy.add(new Pracownik("Piotr", "Kowalski", 25, Dzial.IT, new BigDecimal(11000)));
        pracownicy.add(new Pracownik("Szymon", "Ciśnki", 61, Dzial.IT, new BigDecimal(8800)));
        pracownicy.add(new Pracownik("Natalia", "Rybak", 19, Dzial.HR, new BigDecimal(6200)));
        pracownicy.add(new Pracownik("Aleksandra", "Sztab", 22, Dzial.Sales, new BigDecimal(7100)));


        System.out.println("1 Policzenie pracowników z działu IT");
        long pracownicy_it = pracownicy.stream().filter(x -> x.getDzial() == Dzial.IT).count();
        System.out.println("ilość z it: " + pracownicy_it);

        System.out.println("2 Sprawdzenie, czy wszyscy pracownicy w dziale HR mają pensję powyżej 5000");
        Optional<Pracownik> powyzej7000wHR = pracownicy.stream()
                .filter(x -> x.getDzial() == Dzial.HR)
                .filter(x -> x.getPensja().intValue() < 5000)
                .findFirst();
        //.ifPresent(x -> System.out.println("nie wszyscy pracownicy mają pensję powyżej 5000 w dziale HR"));

        if(powyzej7000wHR.isPresent())
            System.out.println("nie wszyscy pracownicy w HR mają pensję powyżej 5000 w dziale HR");
        else
            System.out.println("Jest conajmiej jeden pracownik w HR, co ma pensje powyzej 5000");



        System.out.println("3 Znalezienie pierwszego pracownika z działu IT, który ma pensję powyżej 7000");
        pracownicy.stream()
                .filter(x -> x.getDzial() == Dzial.IT)
                .filter(x -> x.getPensja().intValue() > 7000)
                .findFirst()
                .ifPresent(pracownik -> System.out.println(
                        "Pracownik o imieniu: " + pracownik.getImie() + " i id: " + pracownik.getId() + " ma pensje większą niż 7000"
                ));

        System.out.println("4 Obliczenie średniej pensji pracowników w dziale Sales");
        double averageSales = pracownicy.stream()
                .filter(x -> x.getDzial() == Dzial.Sales)
                .mapToInt(x -> x.getPensja().intValue())
                .average().orElse(0);

        System.out.println("średnia pensja z Sales:  " + averageSales);

        System.out.println("5 Wyświetlenie unikalnych nazwisk pracowników z działu IT, którzy mają więcej niż 30 lat, posortowanych alfabetycznie");
        List<String> unikalni_it = pracownicy.stream()
                .filter(x -> x.getDzial() == Dzial.IT)
                .filter(x -> x.getWiek() > 30)
                .sorted(Comparator.comparing(Pracownik::getNazwisko))
                .map(Pracownik::getNazwisko)
                .distinct()
                .toList();

        System.out.println("unikalni pracownicy >30lat z IT to:");
        unikalni_it.forEach(System.out::println);

        System.out.println("6 Znalezienie liczby unikalnych imion pracowników w dziale HR");
        List<String> unikalni_HR = pracownicy.stream()
                .filter(x -> x.getDzial() == Dzial.HR)
                .map(Pracownik::getImie)
                .distinct()
                .toList();

        System.out.println("unikalni ilośc imion z HR:" + unikalni_HR.size());
        System.out.println("unikalni pracownicy z HR po imieniu to:");
        unikalni_HR.forEach(System.out::println);

        System.out.println("7 Sprawdzenie, czy jakikolwiek pracownik w dziale HR lub IT zarabia dokładnie 10,000");

        Optional<Pracownik> pracownik10k = pracownicy.stream()
                .filter(x -> x.getDzial() != Dzial.Sales)
                .filter(x -> x.getPensja().intValue() == 10000)
                .findFirst();

        if (pracownik10k.isPresent())
            System.out.println("istnieje taki pracownik");
        else
            System.out.println("nie ma takiego");


        System.out.println("8 Zwrócenie nazwy działu pracownika o imieniu X");
        pracownicy.stream()
                .filter(x -> x.getImie().equals("Ilona"))
                .findFirst()
                .ifPresent(x -> System.out.println(x.getDzial()));

        System.out.println("9 Obliczenie różnicy wieku między najstarszym a najmłodszym pracownikiem (2 streamy mogą być wymagane)");

        double najmlodszy = pracownicy.stream()
                .min(Comparator.comparing(Pracownik::getWiek))
                .get()
                .getWiek();

        double najstarszy = pracownicy.stream()
                .max(Comparator.comparing(Pracownik::getWiek))
                .get()
                .getWiek();

        System.out.println("roznica wieku: " + (najstarszy - najmlodszy));

        System.out.println("10 Wypisz imiona pracowników którzy mają parzyste id a następnie zwróć Listę takich pracowników (wszystko w jednym stream'ie)");
        List<Pracownik> parzysteID = pracownicy.stream()
                .filter(x -> x.getId() % 2 == 0)
                .peek(x -> System.out.println(x.getImie()))
                .toList();

        parzysteID.forEach(x -> System.out.println(x.getImie() + " id: " + x.getId()));

    }
}