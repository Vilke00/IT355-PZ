package com.metropolitan.IT355_Projekat.controller;

import com.metropolitan.IT355_Projekat.model.Carolija;
import com.metropolitan.IT355_Projekat.model.Cudoviste;
import com.metropolitan.IT355_Projekat.model.User;
import com.metropolitan.IT355_Projekat.service.CudovisteService;
import com.metropolitan.IT355_Projekat.service.CarolijaService;
import com.metropolitan.IT355_Projekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private CarolijaService carolijaService;
    @Autowired
    private CudovisteService cudovisteService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/success")
    public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {

        String role =  authResult.getAuthorities().toString();

        if(role.contains("ROLE_ADMIN")){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/adminDashboard"));
        }
        else if(role.contains("ROLE_USER")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
        }
    }

//    @GetMapping("/")
//    public String home() {
//        return "index";
//    }

//    @GetMapping("/adminDashboard")
//    public String admin() {
//        return "adminDashboard";
//    }

    // prikazi spiskove
    @RequestMapping("/adminDashboard")
    public String viewAdminDashboard(Model model){
        model.addAttribute("listKorisnici", userService.getAllKorisnici());
        model.addAttribute("listCarolije", carolijaService.getAllCarolije());
        model.addAttribute("listCudovista", cudovisteService.getAllCudovista());
        return "adminDashboard";
    }
    // prikazi spiskove
    @RequestMapping("/")
    public String viewUserDashboard(Model model){
        model.addAttribute("listCudovistaUser", cudovisteService.getAllCudovista());
        model.addAttribute("listCarolijeUser", carolijaService.getAllCarolije());
        return "index";
    }


    @GetMapping("/adminDashboard/showNoviUserForm")
    public String showAddStudent(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("adminDashboard/dodajUsera")
    public String dodajUsera(@ModelAttribute("user") User user){
        userService.saveKorisnik(user);
        return "redirect:/adminDashboard";
    }

    @GetMapping("/adminDashboard/formUpdate/{id}")
    public String showFormUpdate(@PathVariable(value = "id") long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/adminDashboard/obrisiUsera/{id}")
    public String obrisiUsera(@PathVariable (value = "id") long id) {
        this.userService.deleteUserById(id);
        return "redirect:/adminDashboard";
    }

    //Carolija
    @GetMapping("/adminDashboard/showNoviCarolijaForm")
    public String showAddcarolija(Model model){
        Carolija carolija = new Carolija();
        model.addAttribute("carolija", carolija);
        return "new_carolija";
    }

    @PostMapping("adminDashboard/dodajCaroliju")
    public String dodajcarolija(@ModelAttribute("carolija") Carolija carolija){
        carolijaService.saveCarolija(carolija);
        return "redirect:/adminDashboard";
    }

    @GetMapping("/adminDashboard/formUpdateCaroliju/{id_carolija}")
    public String showFormUpdatecarolija(@PathVariable (value = "id_carolija") long id, Model model){
        Carolija carolija = carolijaService.getCarolijaById(id);
        model.addAttribute("carolija", carolija);
        return "update_carolija";
    }

    @GetMapping("/adminDashboard/obrisiCaroliju/{id}")
    public String obrisicarolija(@PathVariable (value = "id") long id) {
        this.carolijaService.deleteCarolijaById(id);
        return "redirect:/adminDashboard";
    }

    //Cudovista
    @GetMapping("/adminDashboard/showNoviCudovisteForm")
    public String showAddCudoviste(Model model){
        Cudoviste cudoviste = new Cudoviste();
        model.addAttribute("cudoviste", cudoviste);
        return "new_cudoviste";
    }

    @PostMapping("adminDashboard/dodajCudoviste")
    public String dodajLekciju(@ModelAttribute("cudoviste") Cudoviste cudoviste){
        cudovisteService.saveCudoviste(cudoviste);
        return "redirect:/adminDashboard";
    }

    @GetMapping("/adminDashboard/formUpdateCudoviste/{id_cudoviste}")
    public String showFormUpdateCudoviste(@PathVariable (value = "id_cudoviste") long id, Model model){
        Cudoviste cudoviste = cudovisteService.getCudovisteById(id);
        model.addAttribute("cudoviste", cudoviste);
        return "update_cudoviste";
    }

    @GetMapping("/adminDashboard/obrisiCudoviste/{id}")
    public String obrisiLekciju(@PathVariable (value = "id") long id) {
        this.cudovisteService.deleteCudovisteById(id);
        return "redirect:/adminDashboard";
    }
}
