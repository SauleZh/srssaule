package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Author;
import kz.kaznitu.lessons.models.Kafedra;
import kz.kaznitu.lessons.reposotories.KafedraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/kafedra")
public class KafedraController {
    @Autowired
    private KafedraRepository kafedraRepository;
    private long a;
    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("kafedra",new Kafedra());
        return "kafedra_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("kafedraa",new Kafedra());
        return "kafedra_update";
    }
    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Kafedra kafedra){
        kafedraRepository.save(kafedra) ;

        return "redirect:/kafedra/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Kafedra> allAuthors(){
        return kafedraRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allAuthors2(Model model){
        List<Kafedra> kafedras = (List<Kafedra>) kafedraRepository.findAll();
        model.addAttribute("kafedras", kafedras) ;
        return "kafedras" ;
    }

    @PostMapping("/adds")
    public String addsAuthor(@ModelAttribute Kafedra kafedra){
        Kafedra kafedra1 = new Kafedra();
        kafedra1.setId(a);
        kafedra1.setKafedraName(kafedra.getKafedraName());
        kafedra1.setYear(kafedra.getYear());
        kafedraRepository.save(kafedra1) ;

        return "redirect:/kafedra/all" ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model, @RequestParam("id") long id){
        a=id;
        Optional<Kafedra> kafedra = (Optional <Kafedra> ) kafedraRepository.findById(id);
        model.addAttribute("kafedraa",kafedra);
        return new ModelAndView("kafedra_update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        kafedraRepository.deleteById(idd);
        return new ModelAndView("redirect:/kafedra/all");
    }

}
