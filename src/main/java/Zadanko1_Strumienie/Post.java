package Zadanko1_Strumienie;

import java.util.Arrays;
import java.util.List;

public class Post {
    private String temat;
    private String tagi;
    private int liczbaZnakow;
    private List<Komentarz> komentarze;

    public String getTemat() {
        return temat;
    }

    public void setTemat(String temat) {
        this.temat = temat;
    }

    public String getTagi() {
        return tagi;
    }

    public void setTagi(String tagi) {
        this.tagi = tagi;
    }

    public int getLiczbaZnakow() {
        return liczbaZnakow;
    }

    public void setLiczbaZnakow(int liczbaZnakow) {
        this.liczbaZnakow = liczbaZnakow;
    }

    public List<Komentarz> getKomentarze() {
        return komentarze;
    }

    public void setKomentarze(List<Komentarz> komentarze) {
        this.komentarze = komentarze;
    }

    @Override
    public String toString() {
        return "Post{" +
                "temat='" + temat + '\'' +
                ", tagi='" + tagi + '\'' +
                ", liczbaZnakow=" + liczbaZnakow +
                ", komentarze=" + komentarze +
                '}';
    }

    public Post(String temat, String tagi, int liczbaZnakow, Komentarz ... komentarze) {
        this.temat = temat;
        this.tagi = tagi;
        this.liczbaZnakow = liczbaZnakow;
        if (komentarze !=null)
            this.komentarze = Arrays.asList(komentarze);

    }
}
