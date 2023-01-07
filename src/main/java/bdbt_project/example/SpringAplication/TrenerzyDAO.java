package bdbt_project.example.SpringAplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class TrenerzyDAO {
    @Autowired
    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public TrenerzyDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Trenerzy> list(){
        String sql = "SELECT p.nr_pracownika, p.Imie, p.Nazwisko, p.Telefon, p.Email,p.nr_klubu, t.Dyscyplina, t.Stopien_zaawansowania FROM Pracownicy p JOIN Trenerzy t ON p.Nr_pracownika = t.Nr_pracownika";

        List<Trenerzy> trenerzyList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Trenerzy.class));

        return trenerzyList;
    }


    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Trenerzy sale) {
    }


    /* Read – odczytywanie danych z bazy */
    public Trenerzy get(int id) {
        return null;
    }


    /* Update – aktualizacja danych */
    public void update(Trenerzy sale) {
    }


    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
