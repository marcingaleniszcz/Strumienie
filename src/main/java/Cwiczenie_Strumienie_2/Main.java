package Cwiczenie_Strumienie_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Arrays.stream(new Integer [] {1, 2, 3, 4, 3453, 1111, 5, 100, 231, 2104})
        .filter(liczba -> liczba % 2 == 0)
        .map(liczba -> liczba * 10)
        .peek(System.out::println)
        .sorted(Collections.reverseOrder())
        .skip(3)
        .forEach(System.out::println);
    }
}
