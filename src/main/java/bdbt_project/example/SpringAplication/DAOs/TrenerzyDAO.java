package bdbt_project.example.SpringAplication.DAOs;

import bdbt_project.example.SpringAplication.data_representation.Trener;
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

    public List<Trener> list(){
        String sql = "select p.nr_pracownika, p.Imie, p.Nazwisko, p.Telefon, p.Email,p.Nr_klubu, t.Dyscyplina, t.Stopien_zaawansowania from Pracownicy p join Trenerzy t on p.Nr_pracownika = t.Nr_pracownika";

        List<Trener> trenerzyList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Trener.class));

        return trenerzyList;
    }


    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Trener sale) {
    }


    /* Read – odczytywanie danych z bazy */
    public Trener get(int id) {
        return null;
    }


    /* Update – aktualizacja danych */
    public void update(Trener sale) {
    }


    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
        String sql = "DELETE FROM Trenerzy WHERE nr_pracownika = ?";
        String sql1 = "DELETE FROM Pracownicy WHERE nr_pracownika = ?";
        jdbcTemplate.update(sql,id);
        jdbcTemplate.update(sql1,id);
    }

}
