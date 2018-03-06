package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Kafedra;
import kz.kaznitu.lessons.models.Teacher;
import kz.kaznitu.lessons.reposotories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/teacher")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;
    private long a;
    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("teacher",new Teacher());
        return "teacher_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("teacherr",new Teacher());
        return "teacher_update";
    }
    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Teacher teacher){
        teacherRepository.save(teacher) ;

        return "redirect:/teacher/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Teacher> allAuthors(){
        return teacherRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allAuthors2(Model model){
        List<Teacher> teachers = (List<Teacher>) teacherRepository.findAll();
        model.addAttribute("teachers", teachers) ;
        return "teachers" ;
    }

    @PostMapping("/adds")
    public String addsAuthor(@ModelAttribute Teacher teacher){
        Teacher teacher1 = new Teacher();
        teacher1.setId(teacher.getId());
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        teacherRepository.save(teacher1) ;

        return "redirect:/teacher/all" ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model, @RequestParam("id") long id){
        a=id;
        Optional<Teacher> teacher = (Optional <Teacher> ) teacherRepository.findById(id);
        model.addAttribute("teacherr",teacher);
        return new ModelAndView("teacher_update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        teacherRepository.deleteById(idd);
        return new ModelAndView("redirect:/teacher/all");
    }

}
