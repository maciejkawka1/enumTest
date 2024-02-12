package kolekcje;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
       /* //Napisz mechanizm, który skonwertuje listę typu String na listę typu Integer

        List<String> strList = new ArrayList<>();
        strList.add("123");
        strList.add("1");
        strList.add("85");
        strList.add("444444");
        strList.add("3");
        strList.add("2wrrr");
        strList.add("567");
        strList.add("2499");
        System.out.println("wielkosc sringow: "+strList.size());
        List<Integer> integers = convertListToIntegers(strList);
        System.out.println("wielkosc int: " + integers.size());
        for(Integer i : integers){
            System.out.println(i);
        }*/

        // Na podstawie poniższej listy napisz mechanizm, który zwróci tylko elementy unikalne

        List<Integer> values = new ArrayList<>();
        values.add(10);
        values.add(11);
        values.add(10);
        values.add(11);
        values.add(12);
        values.add(11);



        List<Integer> integers = getUniqueListIntegers(values);

        integers.forEach(System.out::println);

        List<String> strings = List.of("11fe","11fe","kot","pies","czajnik","kot");
        UniqueList<String> uniqueList = new UniqueList<>(strings);
        List<String> unique = uniqueList.getUniqueList();

        unique.forEach(System.out::println);

    }

    public static List<Integer> convertListToIntegers(List<String> listOfStrings){
        List<Integer> listOfIntegers = new ArrayList<>();

        for(String element : listOfStrings){
            try {
                listOfIntegers.add(Integer.parseInt(element));
            }catch (NumberFormatException e){

            }
        }

        return listOfIntegers;
    }

    public static  List<Integer> getUniqueListIntegers(List<Integer> list){
        Set<Integer> set = new HashSet<>(list);
        return set.stream().toList();
    }

}
