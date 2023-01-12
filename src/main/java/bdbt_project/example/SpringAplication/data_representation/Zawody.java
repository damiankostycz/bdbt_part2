package bdbt_project.example.SpringAplication.data_representation;

import java.time.LocalDate;

public class Zawody {
    private int nrZawodow;
    private LocalDate data;
    private int liczbaBiletow;
    private int zloteMedale;
    private int srebrneMedale;
    private int brazoweMedale;
    private int nrKlubu;


    public Zawody(){}

    public Zawody(int nrZawodow, LocalDate data, int liczbaBiletow, int zloteMedale, int srebrneMedale, int brazoweMedale, int nrKlubu) {
        this.nrZawodow = nrZawodow;
        this.data = data;
        this.liczbaBiletow = liczbaBiletow;
        this.zloteMedale = zloteMedale;
        this.srebrneMedale = srebrneMedale;
        this.brazoweMedale = brazoweMedale;
        this.nrKlubu = nrKlubu;
    }

    public int getNrZawodow() {
        return nrZawodow;
    }

    public void setNrZawodow(int nrZawodow) {
        this.nrZawodow = nrZawodow;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getLiczbaBiletow() {
        return liczbaBiletow;
    }

    public void setLiczbaBiletow(int liczbaBiletow) {
        this.liczbaBiletow = liczbaBiletow;
    }

    public int getZloteMedale() {
        return zloteMedale;
    }

    public void setZloteMedale(int zloteMedale) {
        this.zloteMedale = zloteMedale;
    }

    public int getSrebrneMedale() {
        return srebrneMedale;
    }

    public void setSrebrneMedale(int srebrneMedale) {
        this.srebrneMedale = srebrneMedale;
    }

    public int getBrazoweMedale() {
        return brazoweMedale;
    }

    public void setBrazoweMedale(int brazoweMedale) {
        this.brazoweMedale = brazoweMedale;
    }

    public int getNrKlubu() {
        return nrKlubu;
    }

    public void setNrKlubu(int nrKlubu) {
        this.nrKlubu = nrKlubu;
    }


    @Override
    public String toString() {
        return "Zawody{" +
                "nr_zawodow=" + nrZawodow +
                ", data=" + data +
                ", liczba_biletow=" + liczbaBiletow +
                ", zlote_medale=" + zloteMedale +
                ", srebrne_medale=" + srebrneMedale +
                ", brazowe_medale=" + brazoweMedale +
                ", nr_klubu=" + nrKlubu;
    }
}
