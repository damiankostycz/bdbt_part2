package bdbt_project.example.SpringAplication.data_representation;

import java.time.LocalDate;

public class Trener {
    private int nrPracownika;

    private String imie;
    private String nazwisko;
    private String email;
    private String nrLicencji;
    private LocalDate dataWaznosciLicencji;
    private String dyscyplina;
    private String czySzkolenieRko;
    private String telefon;
    private int nrKlubu;
    private String stopienZaawansowania;

    public Trener(){}

    public Trener(int nrPracownika, String imie, String nazwisko, String email, String nrLicencji, LocalDate dataWaznosciLicencji, String dyscyplina, String czySzkolenieRko, String telefon, int nrKlubu, String stopienZaawansowania) {
        this.nrPracownika = nrPracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.nrLicencji = nrLicencji;
        this.dataWaznosciLicencji = dataWaznosciLicencji;
        this.dyscyplina = dyscyplina;
        this.czySzkolenieRko = czySzkolenieRko;
        this.telefon = telefon;
        this.nrKlubu = nrKlubu;
        this.stopienZaawansowania = stopienZaawansowania;
    }

    public int getNrPracownika() {
        return nrPracownika;
    }

    public void setNrPracownika(int nrPracownika) {
        this.nrPracownika = nrPracownika;
    }

    public String getNrLicencji() {
        return nrLicencji;
    }

    public void setNrLicencji(String nrLicencji) {
        this.nrLicencji = nrLicencji;
    }

    public LocalDate getDataWaznosciLicencji() {
        return dataWaznosciLicencji;
    }

    public void setDataWaznosciLicencji(LocalDate dataWaznosciLicencji) {
        this.dataWaznosciLicencji = dataWaznosciLicencji;
    }

    public String getDyscyplina() {
        return dyscyplina;
    }

    public void setDyscyplina(String dyscyplina) {
        this.dyscyplina = dyscyplina;
    }

    public String getCzySzkolenieRko() {
        return czySzkolenieRko;
    }

    public void setCzySzkolenieRko(String czySzkolenieRko) {
        this.czySzkolenieRko = czySzkolenieRko;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getNrKlubu() {
        return nrKlubu;
    }

    public void setNrKlubu(int nrKlubu) {
        this.nrKlubu = nrKlubu;
    }

    public String getStopienZaawansowania() {
        return stopienZaawansowania;
    }

    public void setStopienZaawansowania(String stopienZaawansowania) {
        this.stopienZaawansowania = stopienZaawansowania;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Trener{" +
                "nrPracownika=" + nrPracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                ", nrLicencji='" + nrLicencji + '\'' +
                ", dataWaznosciLicenjci='" + dataWaznosciLicencji + '\'' +
                ", dyscyplina='" + dyscyplina + '\'' +
                ", czySzkolenieRko='" + czySzkolenieRko + '\'' +
                ", telefon='" + telefon + '\'' +
                ", nrKlubu=" + nrKlubu +
                ", stopienZaawansowania='" + stopienZaawansowania + '\'' +
                '}';
    }
}

