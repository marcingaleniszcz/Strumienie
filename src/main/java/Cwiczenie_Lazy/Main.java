package Cwiczenie_Lazy;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> strumienImion = Stream.of("Jeremiasz", "Monika", "Jarek");
        strumienImion.filter(imie -> imie.startsWith("J"))
                .collect(Collectors.toList());
        strumienImion.sorted();
    }
}
