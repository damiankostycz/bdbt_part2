package bdbt_project.example.SpringAplication;

import bdbt_project.example.SpringAplication.DAOs.PracownicyDAO;
import bdbt_project.example.SpringAplication.DAOs.TrenerzyDAO;
import bdbt_project.example.SpringAplication.DAOs.ZawodnicyDAO;
import bdbt_project.example.SpringAplication.DAOs.ZawodyDAO;
import bdbt_project.example.SpringAplication.data_representation.Pracownik;
import bdbt_project.example.SpringAplication.data_representation.Trener;
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
	private PracownicyDAO daoPracownicy;

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
		daoPracownicy = new PracownicyDAO(new JdbcTemplate(dataSource));
	}

	@Test
	void testList(){
		List<Zawodnik> zawodnikList = daoZawodnicy.list();
		assertFalse(zawodnikList.isEmpty());
		List<Trener> trenerList = daoTrenerzy.listUser();
		System.out.println(trenerList);
		assertFalse(trenerList.isEmpty());
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
		Zawody zawody = new Zawody(6,LocalDate.now(), 568, 1,2,0,1);
		daoZawody.save(zawody);

	}
	@Test
	void addTestPracownik() {
		Pracownik pracownik = new Pracownik(3, "Wiktor", "Serek", "M", "02365145256", "125485475", "wikotrs@wp.pl", LocalDate.now(), 1);
		daoPracownicy.save(pracownik);
	}

	@Test
	void getTestZawody() {
		int id = 4;
		Zawody zawody = daoZawody.getZawody(id);
		assertNotNull(zawody);
	}
	@Test
	void updateTestZawody(){
		Zawody zawody = new Zawody();
		zawody.setNrZawodow(3);
		zawody.setData(LocalDate.now());
		zawody.setLiczbaBiletow(12);
		zawody.setZloteMedale(1);
		zawody.setSrebrneMedale(0);
		zawody.setBrazoweMedale(0);
		zawody.setNrKlubu(1);
		daoZawody.updateZawody(zawody);

	}


}
