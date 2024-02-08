package typygeneryczne;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] tab = {"a","b","c","d","e"};
        swapArray(tab,2,3);
        System.out.println(Arrays.toString(tab));
        Double[] tab2 = {4.0,3.11,1d,11d,12.1111,0d};

        swapOnlyNumbers(tab2,0,1);
        System.out.println(Arrays.toString(tab2));

    }

    public static  <T> void swapArray(T[] array, int position1, int position2){
        if (position1 < 0 || position1 >= array.length || position2 < 0 || position2 >= array.length) {
            System.out.println("zla pozycja");
            return;
        }

        T temp = array[position1];
        array[position1] = array[position2];
        array[position2] = temp;
    }

    public static  <T extends Number> void swapOnlyNumbers(T[] array, int position1, int position2){
        swapArray(array,position1,position2);
    }
}
