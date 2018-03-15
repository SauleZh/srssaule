package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Menu;
import kz.kaznitu.lessons.reposotories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/menu")
public class MenuController {
    @Autowired
    private MenuRepository menuRepository;
    private long a;
    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("menu",new Menu());
        return "menu_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("menuu",new Menu());
        return "menu_update";
    }
    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Menu menu){
        menuRepository.save(menu);


        return "redirect:/menu/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Menu> allAuthors(){
        return menuRepository.findAll();
    }

    @GetMapping("/all")
    public String allAuthors2(Model model){
        List<Menu> menus = (List<Menu>) menuRepository.findAll();
        model.addAttribute("menus", menus) ;
        return "menus" ;
    }

    @PostMapping("/adds")
    public String addsAuthor(@ModelAttribute Menu menu){
        Menu menu1 = new Menu();
        menu1.setId(a);
        menu1.setMenuName(menu.getMenuName());
        menu1.setPrice(menu.getPrice());
        menuRepository.save(menu1) ;

        return "redirect:/menu/all" ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model, @RequestParam("id") long id){
        a=id;
        Optional<Menu> menu = (Optional <Menu> ) menuRepository.findById(id);
        model.addAttribute("menuu",menu);
        return new ModelAndView("menu_update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        menuRepository.deleteById(idd);
        return new ModelAndView("redirect:/menu/all");
    }

}
