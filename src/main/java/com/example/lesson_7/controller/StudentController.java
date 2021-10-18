package com.example.lesson_7.controller;

import com.example.lesson_7.entity.Student;
import com.example.lesson_7.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getStudents(Model model) {
        List<Student> allStudents = studentService.findAllStudents();
        model.addAttribute("students", allStudents);
        return "index";
    }


    @PostMapping("/update")
    public ModelAndView updateStudent(@RequestParam(name = "name") String name, @RequestParam(name = "oldName") String oldName, ModelMap modelMap, Model model) {
        Student byName = studentService.findByName(oldName);
        byName.setName(name);
        studentService.updateStudent(byName);
        return new ModelAndView("redirect:/students", modelMap);
    }


    @PostMapping("/add")
    public ModelAndView addStudent(@RequestParam(name = "name") String name, @RequestParam(name = "age") Integer age, ModelMap model) {
        studentService.addStudent(new Student(name, age));
        return new ModelAndView("redirect:/students", model);
    }

    @PostMapping("delete")
    public ModelAndView deleteStudent(@RequestParam(name = "name") String name, ModelMap model) {
        studentService.deleteByName(name);
        return new ModelAndView("redirect:/students", model);
    }


    @GetMapping("getUpdateView")
    public String getUpdateView(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("oldName", name);
        return "up";
    }
}
