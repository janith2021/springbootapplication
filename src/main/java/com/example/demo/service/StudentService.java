package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    List<Student> students = new ArrayList<Student>();

    public StudentService() {

        Student student1 = new Student();

        student1.setName("Janith");
        student1.setId("STU_001");
        student1.setEmail("janith@gmail.com");

        Student student2 = new Student();

        student2.setName("Amal");
        student2.setEmail("amal@gmail.com");
        student2.setId("STU_002");

        Student student3 = new Student();

        student3.setName("Kamal");
        student3.setEmail("kamal@gmail.com");
        student3.setId("STU_003");

        Student student4 = new Student();

        student4.setName("Bimal");
        student4.setEmail("bimal@gmail.com");
        student4.setId("STU_004");

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Student getSpecifiedStudent(String id){

        return students.stream().filter(student -> student.getId().equals(id)).findFirst().get();
//        if(foundstudent){
    }

    public List<Student> createStudent(Student student){
        students.add(student);
        return students;
    }

    public String updateStudent(Student student){

        try {
            students.stream().filter(s -> s.getId().equals(student.getId())).forEach(s -> {
                s.setName(student.getName());
                s.setEmail(student.getEmail());
            });
            return "Student Updated Successfully";
        } catch (Exception e){
            return e.getMessage();
        }
    }

    public String deleteStudent(String id){
        try {
            Student student = students.stream().filter(s-> s.getId().equals(id)).findFirst().get();
//            students.removeIf(s->s.getId().equals(id));
            students.remove(student);
            return "Student Deleted Successfully.";
        }catch (Exception e){
            return e.getMessage();
        }


    }
}
