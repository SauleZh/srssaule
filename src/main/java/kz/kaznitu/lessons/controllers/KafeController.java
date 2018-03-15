package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Kafe;
import kz.kaznitu.lessons.models.Sponsor;
import kz.kaznitu.lessons.reposotories.KafeRepository;
import kz.kaznitu.lessons.reposotories.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/kafe")
public class KafeController {
    @Autowired
    private KafeRepository kafeRepository;
    private long a;
    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("kafe",new Kafe());
        return "kafe_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("kafee",new Kafe());
        return "kafe_update";
    }
    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Kafe kafe){
        kafeRepository.save(kafe);


        return "redirect:/kafe/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Kafe> allAuthors(){
        return kafeRepository.findAll();

    }

    @GetMapping("/all")
    public String allAuthors2(Model model){
        List<Kafe> kafes = (List<Kafe>) kafeRepository.findAll();
        model.addAttribute("kafes", kafes) ;
        return "kafes" ;
    }

    @PostMapping("/adds")
    public String addsAuthor(@ModelAttribute Kafe kafe){
        Kafe kafe1 = new Kafe();
        kafe1.setId(kafe.getId());
        kafe1.setKafeName(kafe.getKafeName());
        kafe1.setKafeName(kafe.getKafeName());
        kafe1.setNomer(kafe.getNomer());
        kafeRepository.save(kafe1) ;

        return "redirect:/kafe/all" ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model, @RequestParam("id") long id){
        a=id;
        Optional<Kafe> kafe = (Optional <Kafe> ) kafeRepository.findById(id);
        model.addAttribute("kafee",kafe);
        return new ModelAndView("kafe_update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        kafeRepository.deleteById(idd);
        return new ModelAndView("redirect:/kafe/all");
    }

}

