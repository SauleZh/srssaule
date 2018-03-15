package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Sponsor;
import kz.kaznitu.lessons.reposotories.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/sponsor")
public class SponsorController {
    @Autowired
    private SponsorRepository sponsorRepository;
    private long a;
    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("sponsor",new Sponsor());
        return "sponsor_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("sponsorr",new Sponsor());
        return "sponsor_update";
    }
    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Sponsor sponsor){
        sponsorRepository.save(sponsor) ;

        return "redirect:/sponsor/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Sponsor> allAuthors(){
        return sponsorRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allAuthors2(Model model){
        List<Sponsor> sponsors = (List<Sponsor>) sponsorRepository.findAll();
        model.addAttribute("sponsors", sponsors) ;
        return "sponsors" ;
    }

    @PostMapping("/adds")
    public String addsAuthor(@ModelAttribute Sponsor sponsor){
        Sponsor sponsor1 = new Sponsor();
        sponsor1.setId(sponsor.getId());
        sponsor1.setFirstName(sponsor.getFirstName());
        sponsor1.setLastName(sponsor.getLastName());
        sponsor1.setEmail(sponsor.getEmail());
        sponsorRepository.save(sponsor1) ;

        return "redirect:/sponsor/all" ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model, @RequestParam("id") long id){
        a=id;
        Optional<Sponsor> sponsor = (Optional <Sponsor> ) sponsorRepository.findById(id);
        model.addAttribute("sponsorr",sponsor);
        return new ModelAndView("sponsor_update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        sponsorRepository.deleteById(idd);
        return new ModelAndView("redirect:/sponsor/all");
    }

}
