package com.controller;

import com.model.Classroom;
import com.model.Student;
import com.service.ClassroomService;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    ClassroomService classroomService;

    @Autowired
    StudentService studentService;

    @ModelAttribute("student")
    public Student student() {
        return new Student();
    }

    @ModelAttribute("classrooms")
    public List<Classroom> classrooms() {
        return classroomService.findALl();
    }

    @GetMapping("/showAll")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("/showAll");
        modelAndView.addObject("classrooms", classrooms());
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        return new ModelAndView("/create");
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/students/showAll";
    }

    @GetMapping("{id}/edit")
    public ModelAndView edit(@PathVariable Long id){
        Optional<Student> student = studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Student student){
        studentService.save(student);
        return "redirect:/students/showAll";
    }

    @GetMapping("{id}/delete")
    public ModelAndView deleteForm(@PathVariable Long id){
        Optional<Student> student = studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id){
        studentService.deleteById(id);
        return "redirect:/students/showAll";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String search){
        List<Student> students = studentService.search(search);
        ModelAndView modelAndView = new ModelAndView("/search");
        modelAndView.addObject("students", students);
        return modelAndView;
    }
}

