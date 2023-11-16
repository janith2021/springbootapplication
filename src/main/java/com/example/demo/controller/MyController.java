package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)

    public String Home() {
        return "Home";
    }

    //    @GetMapping("/test")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String name() {
        return "Hello Janith";
    }

    //    @RequestMapping (value = "/test",method = RequestMethod.GET)
//    @GetMapping("/testing")
//    public String name(){
    @RequestMapping(value = "/testing", method = RequestMethod.GET)
    public String hello() {
        return "Hi Janith";
    }

    @GetMapping("/allStudents")

    public List<Student> allStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getstudent/{id}")

    public Student getstudent(@PathVariable String id) {

        return studentService.getSpecifiedStudent(id);
    }

    @PostMapping("/createStudent")

    public List<Student> createstudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @PutMapping("/student/update")
    public String updatestudent(@RequestBody Student student) {

        return studentService.updateStudent(student);
    }

    @DeleteMapping("/student/delete/{id}")

    public String deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
//        RestTemplate template = new RestTemplate();
//        template.postForObject("",);
//        @RequestMapping(value = "",method = RequestMethod.POST);
    }
}