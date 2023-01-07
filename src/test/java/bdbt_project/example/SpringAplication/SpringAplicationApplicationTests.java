package bdbt_project.example.SpringAplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
		List<Zawodnicy> meczeList = dao.list();
		System.out.println(meczeList);
		assertTrue(!meczeList.isEmpty());
	}
	@Test
	void contextLoads() {
	}

}
