package bdbt_project.example.SpringAplication;

import bdbt_project.example.SpringAplication.DAOs.TrenerzyDAO;
import bdbt_project.example.SpringAplication.DAOs.ZawodnicyDAO;
import bdbt_project.example.SpringAplication.DAOs.ZawodyDAO;
import bdbt_project.example.SpringAplication.data_representation.Zawodnik;
import bdbt_project.example.SpringAplication.data_representation.Zawody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringAplicationApplicationTests {
	private ZawodnicyDAO daoZawodnicy;
	private ZawodyDAO daoZawody;
	private TrenerzyDAO daoTrenerzy;

	@BeforeEach
	void setUp(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dataSource.setUsername("DKOSTYCZ");
		dataSource.setPassword("dkostycz");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

		daoZawodnicy = new ZawodnicyDAO(new JdbcTemplate(dataSource));
		daoZawody = new ZawodyDAO(new JdbcTemplate(dataSource));
		daoTrenerzy = new TrenerzyDAO(new JdbcTemplate(dataSource));
	}

	@Test
	void testList(){
		List<Zawodnik> zawodnikList = daoZawodnicy.list();
		System.out.println(zawodnikList);
		assertFalse(zawodnikList.isEmpty());
	}
	@Test
	void deleteTest(){
		int id =1;
		daoTrenerzy.delete(id);
		daoZawodnicy.delete(id);
		daoZawody.delete(id);
	}
	@Test
	void addTest(){
		Zawody zawody = new Zawody(5,LocalDate.now(), 943, 0,2,2,1);
		daoZawody.save(zawody);
	}
	@Test
	void contextLoads() {
	}

}
