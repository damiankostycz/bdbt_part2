package bdbt_project.example.SpringAplication;

import java.time.LocalDate;
import java.util.Date;

public class Zawody {
    private int nr_zawodow;
    private LocalDate data;
    private int liczba_biletow;
    private int zlote_medale;
    private int srebrne_medale;
    private int brazowe_medale;
    private int nr_klubu;
    private String miasto;
    private String ulica;
    private String numer_budynku;

    public Zawody(){}

    public Zawody(int nr_zawodow, LocalDate data, int liczba_biletow, int zlote_medale, int srebrne_medale, int brazowe_medale, int nr_klubu, String miasto, String ulica, String numer_budynku) {
        this.nr_zawodow = nr_zawodow;
        this.data = data;
        this.liczba_biletow = liczba_biletow;
        this.zlote_medale = zlote_medale;
        this.srebrne_medale = srebrne_medale;
        this.brazowe_medale = brazowe_medale;
        this.nr_klubu = nr_klubu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer_budynku = numer_budynku;
    }

    public int getNr_zawodow() {
        return nr_zawodow;
    }

    public void setNr_zawodow(int nr_zawodow) {
        this.nr_zawodow = nr_zawodow;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getLiczba_biletow() {
        return liczba_biletow;
    }

    public void setLiczba_biletow(int liczba_biletow) {
        this.liczba_biletow = liczba_biletow;
    }

    public int getZlote_medale() {
        return zlote_medale;
    }

    public void setZlote_medale(int zlote_medale) {
        this.zlote_medale = zlote_medale;
    }

    public int getSrebrne_medale() {
        return srebrne_medale;
    }

    public void setSrebrne_medale(int srebrne_medale) {
        this.srebrne_medale = srebrne_medale;
    }

    public int getBrazowe_medale() {
        return brazowe_medale;
    }

    public void setBrazowe_medale(int brazowe_medale) {
        this.brazowe_medale = brazowe_medale;
    }

    public int getNr_klubu() {
        return nr_klubu;
    }

    public void setNr_klubu(int nr_klubu) {
        this.nr_klubu = nr_klubu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumer_budynku() {
        return numer_budynku;
    }

    public void setNumer_budynku(String numer_budynku) {
        this.numer_budynku = numer_budynku;
    }

    @Override
    public String toString() {
        return "Zawody{" +
                "nr_zawodow=" + nr_zawodow +
                ", data=" + data +
                ", liczba_biletow=" + liczba_biletow +
                ", zlote_medale=" + zlote_medale +
                ", srebrne_medale=" + srebrne_medale +
                ", brazowe_medale=" + brazowe_medale +
                ", nr_klubu=" + nr_klubu +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", numer_budynu='" + numer_budynku + '\'' +
                '}';
    }
}
