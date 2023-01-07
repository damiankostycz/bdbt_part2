package bdbt_project.example.SpringAplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class ZawodyDAO {
    @Autowired
    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public ZawodyDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zawody> list(){
        String sql = "select z.nr_zawodow, z.data, z.liczba_biletow, z.zlote_medale, z.srebrne_medale, z.brazowe_medale, z.nr_klubu, a.miasto,a.ulica, a.numer_budynku FROM Zawody z JOIN Adresy a ON z.id_adresu = a.nr_adresu";
        List<Zawody> zawodyList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zawody.class));
        return zawodyList;
    }


    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Zawody sale) {
    }


    /* Read – odczytywanie danych z bazy */
    public Zawody get(int id) {
        return null;
    }


    /* Update – aktualizacja danych */
    public void update(Zawody sale) {
    }


    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
