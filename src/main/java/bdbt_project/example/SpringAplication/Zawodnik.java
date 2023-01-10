package bdbt_project.example.SpringAplication;

import java.time.LocalDate;
import java.util.Date;

public class Zawodnicy {
    private int nr_zawodnika;
    private String imie;
    private String nazwisko;
    private char plec;
    private String pesel;
    private String email;
    private LocalDate dataDolaczenia;
    private String krajPochodzenia;
    private String dyscyplina;
    private String rekordZyciowy;
    private String waga;
    private int nrKlubu;
    private int idAdresu;

    public Zawodnicy(){}

    public Zawodnicy(int nr_zawodnika, String imie, String nazwisko, char plec, String pesel, String email, LocalDate dataDolaczenia, String krajPochodzenia, String dyscyplina, String rekordZyciowy, String waga, int nrKlubu, int idAdresu) {
        this.nr_zawodnika = nr_zawodnika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.pesel = pesel;
        this.email = email;
        this.dataDolaczenia = dataDolaczenia;
        this.krajPochodzenia = krajPochodzenia;
        this.dyscyplina = dyscyplina;
        this.rekordZyciowy = rekordZyciowy;
        this.waga = waga;
        this.nrKlubu = nrKlubu;
        this.idAdresu = idAdresu;
    }

    public int getNr_zawodnika() {
        return nr_zawodnika;
    }

    public void setNr_zawodnika(int nr_zawodnika) {
        this.nr_zawodnika = nr_zawodnika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public char getPlec() {
        return plec;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDolaczenia() {
        return dataDolaczenia;
    }

    public void setDataDolaczenia(LocalDate dataDolaczenia) {
        this.dataDolaczenia = dataDolaczenia;
    }

    public String getKrajPochodzenia() {
        return krajPochodzenia;
    }

    public void setKrajPochodzenia(String krajPochodzenia) {
        this.krajPochodzenia = krajPochodzenia;
    }

    public String getDyscyplina() {
        return dyscyplina;
    }

    public void setDyscyplina(String dyscyplina) {
        this.dyscyplina = dyscyplina;
    }

    public String getRekordZyciowy() {
        return rekordZyciowy;
    }

    public void setRekordZyciowy(String rekordZyciowy) {
        this.rekordZyciowy = rekordZyciowy;
    }

    public String getWaga() {
        return waga;
    }

    public void setWaga(String waga) {
        this.waga = waga;
    }

    public int getNrKlubu() {
        return nrKlubu;
    }

    public void setNrKlubu(int nrKlubu) {
        this.nrKlubu = nrKlubu;
    }

    public int getIdAdresu() {
        return idAdresu;
    }

    public void setIdAdresu(int idAdresu) {
        this.idAdresu = idAdresu;
    }

    @Override
    public String toString() {
        return "Zawodnicy{" +
                "nr_zawodnika=" + nr_zawodnika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec=" + plec +
                ", pesel='" + pesel + '\'' +
                ", email='" + email + '\'' +
                ", dataDolaczenia=" + dataDolaczenia +
                ", krajPochodzenia='" + krajPochodzenia + '\'' +
                ", dyscyplina='" + dyscyplina + '\'' +
                ", rekordZyciowy='" + rekordZyciowy + '\'' +
                ", waga='" + waga + '\'' +
                ", nrKlubu=" + nrKlubu +
                ", idAdresu=" + idAdresu +
                '}';
    }
}
