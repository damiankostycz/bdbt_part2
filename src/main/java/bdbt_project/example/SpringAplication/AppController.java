package bdbt_project.example.SpringAplication;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
        List<Zawodnicy> zawodnicyList = zawodnicyDAO.list();
        model.addAttribute("zawodnicy", zawodnicyList);
        return "admin/zawodnicy";
    }

    @RequestMapping("/trenerzy")
    public String viewMatchesTrenerzy(Model model){
        List<Trenerzy> trenerzyList = trenerzyDAO.list();
        model.addAttribute("trenerzy", trenerzyList);
        return "user/trenerzy";
    }


    @RequestMapping("/nasze_zawody")
    public String viewMatchesZawody(Model model){
        List<Zawody> zawodyList = zawodyDAO.list();
        model.addAttribute("zawody", zawodyList);
        return "user/nasze_zawody";
    }
}