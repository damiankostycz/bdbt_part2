package bdbt_project.example.SpringAplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class ZawodnicyDAO {
    @Autowired
    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public ZawodnicyDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zawodnik> list(){
        String sql = "select * from zawodnicy";
        List<Zawodnik> zawodnikList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zawodnik.class));
        return zawodnikList;
    }


    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Zawodnik sale) {
    }


    /* Read – odczytywanie danych z bazy */
    public Zawodnik get(int id) {
        return null;
    }


    /* Update – aktualizacja danych */
    public void update(Zawodnik sale) {
    }


    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
        String sql = "DELETE FROM Zawodnicy WHERE nr_zawodnika = ?";
        jdbcTemplate.update(sql, id);
    }

}
