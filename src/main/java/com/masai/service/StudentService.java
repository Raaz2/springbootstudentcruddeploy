package com.masai.service;

import com.masai.exception.StudentException;
import com.masai.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student) throws StudentException;
    Student viewStudentByRoll(Integer roll) throws StudentException;
    Student updateStudent(Integer roll,Student student) throws StudentException;
    Student deleteStudent(Integer roll) throws StudentException;
    List<Student> viewAllStudent() throws StudentException;
}
