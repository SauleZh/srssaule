package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Restoran;
import kz.kaznitu.lessons.reposotories.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/restoran")
public class RestoranController {
    @Autowired
    private RestoranRepository RestoranRepository;
    private long a;
    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("restoran",new Restoran());
        return "restoran_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("restoran",new Restoran());
        return "restoran_update";
}
    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Restoran kafe){
        RestoranRepository.save(kafe);


        return "redirect:/restoran/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Restoran> allAuthors(){
        return RestoranRepository.findAll();

    }

    @GetMapping("/all")
    public String allAuthors2(Model model){
        List<Restoran> restorans = (List<Restoran>) RestoranRepository.findAll();
        model.addAttribute("restoran", restorans) ;
        return "restoran" ;
    }

    @PostMapping("/adds")
    public String addsAuthor(@ModelAttribute Restoran restoran){
        Restoran restoran1 = new Restoran();
        restoran1.setId(restoran1.getId());
        restoran1.setRestoranName(restoran.getRestoranName());
        restoran1.setRestoranName(restoran.getRestoranName());
        restoran1.setNomer(restoran.getNomer());
        RestoranRepository.save(restoran1) ;

        return "redirect:/restoran/all" ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model, @RequestParam("id") long id){
        a=id;
        Optional<Restoran> restoran = (Optional <Restoran> ) RestoranRepository.findById(id);
        model.addAttribute("restoran",restoran);
        return new ModelAndView("restoran_update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        RestoranRepository.deleteById(idd);
        return new ModelAndView("redirect:/restoran/all");
    }

}

