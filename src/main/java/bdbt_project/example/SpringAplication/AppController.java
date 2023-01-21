package bdbt_project.example.SpringAplication;

import bdbt_project.example.SpringAplication.DAOs.PracownicyDAO;
import bdbt_project.example.SpringAplication.DAOs.TrenerzyDAO;
import bdbt_project.example.SpringAplication.DAOs.ZawodnicyDAO;
import bdbt_project.example.SpringAplication.DAOs.ZawodyDAO;
import bdbt_project.example.SpringAplication.data_representation.Pracownik;
import bdbt_project.example.SpringAplication.data_representation.Trener;
import bdbt_project.example.SpringAplication.data_representation.Zawodnik;
import bdbt_project.example.SpringAplication.data_representation.Zawody;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Configuration
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/nasze_zawody_user").setViewName("user/nasze_zawody_user");
        registry.addViewController("/nasze_zawody_admin").setViewName("admin/nasze_zawody_admin");
        registry.addViewController("/trenerzy_user").setViewName("user/trenerzy_user");
        registry.addViewController("/trenerzy_admin").setViewName("admin/trenerzy_admin");
        registry.addViewController("/zawodnicy").setViewName("admin/zawodnicy");
        registry.addViewController("/pracownicy").setViewName("admin/pracownicy");
        registry.addViewController("/zawodnicy_user").setViewName("user/zawodnicy_user");
    }
}


@Controller
class DashboardController {
    @Autowired
    private ZawodnicyDAO zawodnicyDAO;
    @Autowired
    private TrenerzyDAO trenerzyDAO;
    @Autowired
    private ZawodyDAO zawodyDAO;
    @Autowired
    private PracownicyDAO pracownicyDAO;
    @RequestMapping("/main")
    public String defaultAfterLogin (HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/main_admin";
        }
        else if (request.isUserInRole("USER")) {
            return "redirect:/main_user";
        }
        else return "redirect:/index";

    }

    @RequestMapping("/errorh")
    public String defaultAfterError (HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/main_admin";
        }
        else if (request.isUserInRole("USER")) {
            return "redirect:/main_user";
        }
        else return "redirect:/index";

    }


    @RequestMapping(value = "/main_admin")
    public String showAdminPage(Model model){
        return "admin/main_admin";
    }

    @RequestMapping(value = "/main_user")
    public String showUserPage(Model model){
        return "user/main_user";
    }

    @RequestMapping("/zawodnicy")
    public String viewMatchesZawodnicy(Model model){
        List<Zawodnik> zawodnikList = zawodnicyDAO.list();
        model.addAttribute("zawodnicy", zawodnikList);
        Zawodnik zawodnik = new Zawodnik();
        model.addAttribute("zawodnikAdd", zawodnik);

        return "admin/zawodnicy";
    }
    @RequestMapping("/zawodnicy_user")
    public String viewMatchesZawodnicyUser(Model model){
        List<Zawodnik> zawodnikList = zawodnicyDAO.list();
        model.addAttribute("zawodnicy", zawodnikList);
        Zawodnik zawodnik = new Zawodnik();
        model.addAttribute("zawodnikAddUser", zawodnik);

        return "user/zawodnicy_user";
    }

    @RequestMapping("/pracownicy")
    public String viewMatchesPracownicy(Model model){
        List<Pracownik> pracownikList = pracownicyDAO.list();
        model.addAttribute("pracownicy", pracownikList);
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownikAdd", pracownik);

        return "admin/pracownicy";
    }

    @RequestMapping("/trenerzy_admin")
    public String viewMatchesTrenerzy(Model model){
        List<Trener> trenerList = trenerzyDAO.list();
        model.addAttribute("trenerzy", trenerList);
        Trener trener = new Trener();
        model.addAttribute("trenerAdd", trener);

        return "admin/trenerzy_admin";
    }

    @RequestMapping("/trenerzy_user")
    public String viewMatchesTrenerzyUser(Model model){
        List<Trener> trenerList = trenerzyDAO.listUser();
        model.addAttribute("trenerzyUser", trenerList);
        return "user/trenerzy_user";
    }

    @RequestMapping("/nasze_zawody_admin")
    public String viewMatchesZawody(Model model){
        List<Zawody> zawodyList = zawodyDAO.list();
        model.addAttribute("zawody", zawodyList);
        Zawody zawody = new Zawody();
        model.addAttribute("zawodyAdd",zawody);

        return "admin/nasze_zawody_admin";
    }
@RequestMapping("/nasze_zawody_user")
    public String viewMatchesZawodyUser(Model model){
        List<Zawody> zawodyList = zawodyDAO.list();
        model.addAttribute("zawody", zawodyList);

        return "user/nasze_zawody_user";
    }

    @RequestMapping(value = "/delete_trener",method = RequestMethod.POST)
    public String deleteTrenerzy(@ModelAttribute("trenerzyAdd") Trener trener){
        trenerzyDAO.delete(trener.getNrPracownika());
        return "redirect:/trenerzy_admin";

    }
    @RequestMapping(value = "/delete_zawodnik",method = RequestMethod.POST)
    public String deleteZawodnicy(@ModelAttribute("zawodnikAdd") Zawodnik zawodnik){
        zawodnicyDAO.delete(zawodnik.getNrZawodnika());
        return "redirect:/zawodnicy";

    }
    @RequestMapping(value = "/delete_zawody",method = RequestMethod.POST)
    public String deleteZawody(@ModelAttribute("zawodyAdd") Zawody zawody){
        zawodyDAO.delete(zawody.getNrZawodow());
        return "redirect:/nasze_zawody_admin";

    }
    @RequestMapping(value = "/delete_pracownik",method = RequestMethod.POST)
    public String deletePracownik(@ModelAttribute("pracownikAdd") Pracownik pracownik){
        pracownicyDAO.delete(pracownik.getNrPracownika());
        return "redirect:/pracownicy";

    }


    @RequestMapping(value = "/addZawody", method = RequestMethod.POST)
    public String addZawody(@ModelAttribute("zawody") Zawody zawody){
        zawodyDAO.save(zawody);
        return "redirect:/nasze_zawody_admin";
    }

    @RequestMapping(value = "/addTrener", method = RequestMethod.POST)
    public String addTrener(@ModelAttribute("trener") Trener trener){
        trenerzyDAO.save(trener);
        return "redirect:/trenerzy_admin";
    }
    @RequestMapping(value = "/addZawodnik", method = RequestMethod.POST)
    public String addZawodnik(@ModelAttribute("zawodnk") Zawodnik zawodnik){
        zawodnicyDAO.save(zawodnik);
        return "redirect:/zawodnicy";
    }

    @RequestMapping(value = "/addZawodnikUser", method = RequestMethod.POST)
    public String addZawodnikUser(@ModelAttribute("zawodnk") Zawodnik zawodnik){
        zawodnicyDAO.save(zawodnik);
        return "redirect:/zawodnicy_user";
    }
    @RequestMapping(value = "/addPracownik", method = RequestMethod.POST)
    public String addPracownik(@ModelAttribute("pracownik") Pracownik pracownik){
        pracownicyDAO.save(pracownik);
        return "redirect:/pracownicy";
    }


    @RequestMapping(value = "/updateZawody", method = RequestMethod.POST)
    public String updateZawody(@ModelAttribute("zawodyAdd") Zawody zawody){
        zawodyDAO.updateZawody(zawody);
        return "redirect:/nasze_zawody_admin";
    }

    @RequestMapping(value = "/updateTrenerzy", method = RequestMethod.POST)
    public String updateTrenerzy(@ModelAttribute("trenerzyAdd") Trener trener){
        trenerzyDAO.update(trener);
        return "redirect:/trenerzy_admin";
    }

    @RequestMapping(value = "/updatePracownicy", method = RequestMethod.POST)
    public String updatePracownicy(@ModelAttribute("pracownicyAdd") Pracownik pracownik){
        pracownicyDAO.update(pracownik);
        return "redirect:/pracownicy";
    }
    @RequestMapping(value = "/updateZawodnicy", method = RequestMethod.POST)
    public String updateZawodnik(@ModelAttribute("zawodyAdd") Zawodnik zawodnik){
        zawodnicyDAO.updateZawodnik(zawodnik);
        return "redirect:/zawodnicy";
    }

    @RequestMapping(value = "/updateZawodnicyUser", method = RequestMethod.POST)
    public String updateZawodnikUser(@ModelAttribute("zawodnikAdd") Zawodnik zawodnik){
        zawodnicyDAO.updateZawodnik(zawodnik);
        return "redirect:/zawodnicy_user";
    }
}