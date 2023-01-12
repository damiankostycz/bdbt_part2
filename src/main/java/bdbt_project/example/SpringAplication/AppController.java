package bdbt_project.example.SpringAplication;

import bdbt_project.example.SpringAplication.DAOs.TrenerzyDAO;
import bdbt_project.example.SpringAplication.DAOs.ZawodnicyDAO;
import bdbt_project.example.SpringAplication.DAOs.ZawodyDAO;
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
        registry.addViewController("/nasze_zawody").setViewName("user/nasze_zawody");
        registry.addViewController("/trenerzy").setViewName("user/trenerzy");
        registry.addViewController("/zawodnicy").setViewName("admin/zawodnicy");

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
        return "admin/zawodnicy";
    }

    @RequestMapping("/trenerzy")
    public String viewMatchesTrenerzy(Model model){
        List<Trener> trenerList = trenerzyDAO.list();
        model.addAttribute("trenerzy", trenerList);
        return "user/trenerzy";
    }

    @RequestMapping("/nasze_zawody")
    public String viewMatchesZawody(Model model){
        List<Zawody> zawodyList = zawodyDAO.list();
        model.addAttribute("zawody", zawodyList);
        return "user/nasze_zawody";
    }

    @RequestMapping("/delete_trenerzy/{id}")
    public String deleteTrenerzy(@PathVariable(name = "id") int id){
        trenerzyDAO.delete(id);
        return "redirect:/trenerzy";

    }
    @RequestMapping("/delete_zawodnicy/{id}")
    public String deleteZawodnicy(@PathVariable(name = "id") int id){
        zawodnicyDAO.delete(id);
        return "redirect:/zawodnicy";

    }
    @RequestMapping("/delete_zawody/{id}")
    public String deleteZawody(@PathVariable(name = "id") int id){
        zawodyDAO.delete(id);
        return "redirect:/nasze_zawody";

    }

//    @RequestMapping(value = "/addZawody", method = RequestMethod.POST)
//    public String addZawody(@ModelAttribute("addZawody") Zawody model){
//        zawodyDAO.save(model);
//        return "redirect:/nasze_zawody";
//    }
//
//    @RequestMapping("/addTrener")
//    public String addTrener(Model model){
//        Zawody zawody = new Zawody();
//        model.addAttribute("trener", zawody);
//        return "redirect:/trenerzy";
//    }
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String saveTrener(@ModelAttribute("trener") Trener trener){
//        trenerzyDAO.save(trener);
//        return "redirect:/trenerzy";
//    }
//    @RequestMapping("/addZawodnik")
//    public String addZawodnik(Model model){
//        Zawodnik zawodnik = new Zawodnik();
//        model.addAttribute("zawodnik", zawodnik);
//        return "redirect:/zawodnicy";
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String saveZawody(@ModelAttribute("zawodnk") Zawodnik zawodnik){
//        zawodnicyDAO.save(zawodnik);
//        return "redirect:/zawodnicy";
//    }
}