package bdbt_project.example.SpringAplication.DAOs;

import bdbt_project.example.SpringAplication.data_representation.Zawody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
        String sql = "select z.nr_zawodow, z.data, z.liczba_biletow, z.zlote_medale, z.srebrne_medale, z.brazowe_medale, z.nr_klubu FROM Zawody z";
        List<Zawody> zawodyList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zawody.class));
        return zawodyList;
    }


    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Zawody zawody) {
        SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate);
        insertAction.withTableName("zawody").usingColumns("nr_zawodow", "data", "liczba_biletow", "zlote_medale", "srebrne_medale", "brazowe_medale", "nr_klubu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zawody);
        insertAction.execute(param);
    }


    /* Read – odczytywanie danych z bazy */
    public Zawody getZawody(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM Zawody WHERE nr_zawodow = " + args[0];
        Zawody zawody = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Zawody.class));

        return zawody;
    }


    /* Update – aktualizacja danych */
    public void updateZawody(Zawody zawody) {
        String sql = "UPDATE Zawody SET data=:data, liczba_biletow=:liczbaBiletow, zlote_medale=:zloteMedale, srebrne_medale=:srebrneMedale, brazowe_medale=:brazoweMedale, nr_klubu=:nrKlubu WHERE nr_zawodow=:nrZawodow";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zawody);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }


    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
        String sql = "DELETE FROM Zawody WHERE nr_zawodow = ?";
        jdbcTemplate.update(sql, id);
    }

}
