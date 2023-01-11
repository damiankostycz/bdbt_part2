package bdbt_project.example.SpringAplication;

import bdbt_project.example.SpringAplication.DAOs.ZawodnicyDAO;
import bdbt_project.example.SpringAplication.data_representation.Zawodnik;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringAplicationApplicationTests {
	private ZawodnicyDAO dao;

	@BeforeEach
	void setUp(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dataSource.setUsername("DKOSTYCZ");
		dataSource.setPassword("dkostycz");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

		dao = new ZawodnicyDAO(new JdbcTemplate(dataSource));
	}

	@Test
	void testList(){
		List<Zawodnik> zawodnikList = dao.list();
		System.out.println(zawodnikList);
		assertFalse(zawodnikList.isEmpty());
	}
	@Test
	void deleteTest(){
		int id =1;
		dao.delete(id);
	}

	@Test
	void contextLoads() {
	}

}
