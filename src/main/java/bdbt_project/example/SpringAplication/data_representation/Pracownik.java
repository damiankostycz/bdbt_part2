package bdbt_project.example.SpringAplication.data_representation;

import java.time.LocalDate;

public class Pracownik {
    private int nrPracownika;
    private String imie;
    private String nazwisko;
    private String plec;
    private String pesel;
    private String telefon;
    private String email;

    private LocalDate dataZatrudnienia;
    int nrKlubu;

    public Pracownik(){};
    public Pracownik(int nrPracownika, String imie, String nazwisko, String plec, String pesel, String telefon, String email, LocalDate dataZatrudnienia, int nrKlubu) {
        this.nrPracownika = nrPracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.pesel = pesel;
        this.telefon = telefon;
        this.email = email;
        this.dataZatrudnienia = dataZatrudnienia;
        this.nrKlubu = nrKlubu;
    }

    public int getNrPracownika() {
        return nrPracownika;
    }

    public void setNrPracownika(int nrPracownika) {
        this.nrPracownika = nrPracownika;
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

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(LocalDate dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public int getNrKlubu() {
        return nrKlubu;
    }

    public void setNrKlubu(int nrKlubu) {
        this.nrKlubu = nrKlubu;
    }

    @Override
    public String toString() {
        return "Pracownicy{" +
                "nrPracownika=" + nrPracownika +
                ", imie='" + imie + '\'' +
                ", naziwsko='" + nazwisko + '\'' +
                ", plec=" + plec +
                ", pesel='" + pesel + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", dataZatrudnienia=" + dataZatrudnienia +
                ", nrKlubu='" + nrKlubu + '\'' +
                '}';
    }
}
