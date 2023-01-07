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

    public List<Zawodnicy> list(){
        String sql = "select * from zawodnicy";
        List<Zawodnicy> zawodnicyList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zawodnicy.class));
        return zawodnicyList;
    }


    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Zawodnicy sale) {
    }


    /* Read – odczytywanie danych z bazy */
    public Zawodnicy get(int id) {
        return null;
    }


    /* Update – aktualizacja danych */
    public void update(Zawodnicy sale) {
    }


    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
