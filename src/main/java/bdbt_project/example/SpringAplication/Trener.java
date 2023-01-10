package bdbt_project.example.SpringAplication;

public class Trener {
    private int nr_pracownika;
    private String imie;
    private String nazwisko;
    private String dyscyplina;
    private String email;
    private String telefon;
    private int nrKlubu;
    private String stopienZaawansowania;

    public Trener(){}

    public Trener(int id, String imie, String nazwisko, String dyscyplina, String email, String telefon, String stopien_zaawansowania, int nrKlubu, String stopienZaawansowania) {
        this.nr_pracownika = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dyscyplina = dyscyplina;
        this.stopienZaawansowania = stopienZaawansowania;
        this.email = email;
        this.telefon = telefon;
        this.nrKlubu = nrKlubu;

    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
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

    public String getDyscyplina() {
        return dyscyplina;
    }

    public void setDyscyplina(String dyscyplina) {
        this.dyscyplina = dyscyplina;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Trenerzy{" +
                "id=" + nr_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dyscyplina='" + dyscyplina + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", nrKlubu=" + nrKlubu +
                ", stopienZaawansowania='" + stopienZaawansowania + '\'' +
                '}';
    }
}

