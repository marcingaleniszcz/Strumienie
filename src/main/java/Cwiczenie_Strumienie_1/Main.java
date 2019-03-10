package Cwiczenie_Strumienie_1;

import java.util.Random;
import java.util.stream.Stream;

public class Main {
    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnouprstuwyxz";

    public static void main(String[] args) {

        Stream<Character> generated = Stream.generate(() -> {
            int position = new Random().nextInt(ALPHA_NUMERIC_STRING.length());
            return ALPHA_NUMERIC_STRING.charAt(position);
        });
        generated.limit(10).sorted().forEach(System.out::println);

        Stream.generate(() -> {
            int position = new Random().nextInt(ALPHA_NUMERIC_STRING.length());
            return ALPHA_NUMERIC_STRING.charAt(position);
        }).limit(10).sorted().forEach(System.out::println);

    }
}
