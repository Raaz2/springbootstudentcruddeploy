package com.masai.controller;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired // for new spring version it's not needed to put @Autowired annotation, wihtout this also it will be autowired automatically
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudentHandler(@RequestBody Student student) throws StudentException {
        Student newStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @GetMapping("/view/{roll}")
    public ResponseEntity<Student> viewStudentHandler(@PathVariable Integer roll) throws StudentException {
        Student student = studentService.viewStudentByRoll(roll);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Student>> viewAllStudentHandler() throws StudentException {
        List<Student> student = studentService.viewAllStudent();
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Student> deleteStudentHandler(@RequestParam("id") Integer roll) throws StudentException {
        Student student = studentService.deleteStudent(roll);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudentHandler(@RequestParam("id") Integer roll, @RequestBody Student student) throws StudentException {
        Student student1 = studentService.updateStudent(roll, student);
        return new ResponseEntity<>(student1, HttpStatus.OK);
    }

}
