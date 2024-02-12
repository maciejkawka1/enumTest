package kolekcje;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Napisz mechanizm, który skonwertuje listę typu String na listę typu Integer

        List<String> strList = new ArrayList<>();
        strList.add("123");
        strList.add("1");
        strList.add("85");
        strList.add("444444");
        strList.add("3");
        strList.add("2SBBBC");
        strList.add("567");
        strList.add("2499");
        System.out.println("wielkosc sringow: "+strList.size());
        List<Integer> integers = convertListToIntegers(strList);
        System.out.println("wielkosc int: " + integers.size());
        for(Integer i : integers){
            System.out.println(i);
        }
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


}
