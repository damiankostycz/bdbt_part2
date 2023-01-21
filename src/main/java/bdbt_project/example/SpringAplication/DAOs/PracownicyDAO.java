package bdbt_project.example.SpringAplication.DAOs;

import bdbt_project.example.SpringAplication.data_representation.Pracownik;
import bdbt_project.example.SpringAplication.data_representation.Zawodnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class PracownicyDAO {
        @Autowired
        /* Import org.springframework.jd....Template */
        private JdbcTemplate jdbcTemplate;

        public PracownicyDAO(JdbcTemplate jdbcTemplate){
            super();
            this.jdbcTemplate = jdbcTemplate;
        }

        public List<Pracownik> list(){
            String sql = "select * from pracownicy";
            List<Pracownik> pracownikList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
            return pracownikList;
        }


        /* Insert – wstawianie nowego wiersza do bazy */
        public void save(Pracownik pracownik) {
            SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate);
            insertAction.withTableName("pracownicy").usingColumns("nr_pracownika", "imie", "nazwisko", "plec", "pesel","telefon", "email", "data_zatrudnienia", "nr_klubu");
            BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
            insertAction.execute(param);
        }


        /* Read – odczytywanie danych z bazy */
        public Zawodnik get(int id) {
            return null;
        }


        /* Update – aktualizacja danych */
        public void update(Pracownik pracownik) {
            String sql = "UPDATE Pracownicy SET imie=:imie, nazwisko=:nazwisko, plec=:plec, pesel=:pesel," +
                    "telefon=:telefon,email=:email, data_zatrudnienia=:dataZatrudnienia, nr_klubu=:nrKlubu WHERE nr_pracownika=:nrPracownika" ;
            BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
            NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
            template.update(sql, param);
        }


        /* Delete – wybrany rekord z danym id */
        public void delete(int id) {
            String sql = "DELETE FROM Pracownicy WHERE nr_pracownika = ?";
            jdbcTemplate.update(sql, id);
        }

}
