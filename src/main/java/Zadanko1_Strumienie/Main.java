package Zadanko1_Strumienie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main{

public static final Post POST_1 = new Post("Java 8 wprowadza strumienie",
        "java 8,strumienie", 519,
        new Komentarz("Super!"),
        new Komentarz("Leniwe przetwarzanie, mega :)"));

public static final Post POST_2 = new Post("Nowe API dla plików NIO",
        "java 8,file api,nio api", 7220);

public static final Post POST_3 = new Post("Przetwarzanie równoległe strumieni",
        "JAVA 8,STRUMIENIE", 3125,
        new Komentarz("WOW!"));

public static final Post POST_4 = new Post("NullPointerException? Poznaj Optional",
        "java 8,null pointer exception,optional", 3125,
        new Komentarz("No, teraz to będę miał problem z głowy"));

public static final List<Post> POSTY =
        Arrays.asList(POST_1, POST_2, POST_3, POST_4);

    public static void metoda1_wypiszTytuly() {
        POSTY.stream().peek(post -> System.out.println(post.getTemat())).collect(Collectors.toList());
    }
    public static List<Post> metoda2_sortuj(){
//        POSTY.stream().sorted((post1, post2) -> Integer.compare(post1.getLiczbaZnakow(), post2.getLiczbaZnakow()))
//        to samo, gorne i dolne :D
          return POSTY.stream().sorted(Comparator.comparingInt(Post::getLiczbaZnakow))
                .collect(Collectors.toList());
    }

    public static List<Post> metoda3_dwaPierwszePosty(){
        return POSTY.stream().limit(2).collect(Collectors.toList());
    }
    public static List<Post> metoda4_dwaPierwszePosrty(){
        return POSTY.stream().skip(POSTY.size()-2).collect(Collectors.toList());
    }

    public static List<Post> metoda5_postyMniejNiz500Znakow(){
        return POSTY.stream().filter(post -> post.getLiczbaZnakow() < 5000).collect(Collectors.toList());
    }
    public static List<Post> metoda6_postyZeSlowemJava(){
        return POSTY.stream().filter(post -> post.getTemat().contains("Java")).collect(Collectors.toList());
    }

    public static boolean metoda7_postyZLiteraA() {
        return POSTY.stream().allMatch(post -> post.getTemat().contains("a"));
    }

    public static boolean metoda8_postyWiecejNiz5000Znakow() {
        return POSTY.stream().anyMatch(post -> post.getLiczbaZnakow() > 5000);
    }

    public static boolean metoda9_WeryfikacjiWiecejNiz5Tagow(){
        return POSTY.stream().noneMatch(post -> post.getTagi().split(",").length>5);
    }

    public static Optional<Post> metoda10_PierwszyPostZawierajacyJava(){
        return POSTY.stream().filter(post -> post.getTemat().contains("Java")).findFirst();
    }

    public static Optional<Post> metoda11_JakikolwiekPostWElemencie(){
        return POSTY.stream().filter(post -> post.getTemat().contains("elemelek")).findAny();
    }

    public static List<String> metoda12_PrzeksztalcPostyNaIchTematy(){
//        return POSTY.stream().map(post -> post.getTemat()).collect(Collectors.toList());
        return POSTY.stream().map(Post::getTemat).collect(Collectors.toList());
    }

    public static Optional<Integer> metoda13_RedukcjaListyPostowDoLiczbyZnakow(){
        Stream<Integer> integerStream = POSTY.stream().map(post -> post.getLiczbaZnakow());
//        return integerStream.reduce((liczbaZn1, liczbaZn2) -> liczbaZn1 + liczbaZn2);
        return integerStream.reduce(Integer::sum);
    }

    public static List<Komentarz> metoda14_ZbiorWszystkichKomentarzyZWszystkichPostow(){
        Stream<Komentarz> komentarze = POSTY.stream().flatMap(post -> post.getKomentarze().stream());
        List<Komentarz> komentarzeLista= komentarze.collect(Collectors.toList());
        return komentarzeLista;
    }

    public static List<String> metoda15_WszystkieUnikalneTagiMalymiLiterami() {
        Stream<String> tagiZWszystkichPozstow = POSTY.stream().flatMap(post -> {
            String[] tagi = post.getTagi().toLowerCase().split(",");
            return Arrays.stream(tagi);
        }).distinct();
        return tagiZWszystkichPozstow.collect(Collectors.toList());
    }

    public static void main(String[] args) {
//        metoda1_wypiszTytuly();
//        metoda2_sortuj();
//        metoda3_dwaPierwszePosty();
//        metoda4_dwaPierwszePosrty().forEach(post -> System.out.println(post.getTemat()));
//        metoda5_postyMniejNiz500Znakow().forEach(post -> System.out.println(post.getTemat()));
//        metoda6_postyZeSlowemJava();
//        metoda7_postyZLiteraA();
//        metoda8_postyWiecejNiz5000Znakow();
//        System.out.println(metoda8_postyWiecejNiz5000Znakow());
//        System.out.println(metoda9_WeryfikacjiWiecejNiz5Tagow());
//        Optional<Post> opcjonalnyPost = metoda10_PierwszyPostZawierajacyJava();
//        opcjonalnyPost.ifPresent(post -> System.out.println(post));
//        System.out.println(metoda12_PrzeksztalcPostyNaIchTematy());
//        System.out.println(metoda13_RedukcjaListyPostowDoLiczbyZnakow());
//        metoda13_RedukcjaListyPostowDoLiczbyZnakow().ifPresent(liczba -> System.out.println(liczba));
//        System.out.println(metoda14_ZbiorWszystkichKomentarzyZWszystkichPostow());
        System.out.println(metoda15_WszystkieUnikalneTagiMalymiLiterami());

    }
}