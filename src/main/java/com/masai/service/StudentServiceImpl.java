package com.masai.service;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) throws StudentException {
        if (student != null) {
            return studentRepository.save(student);
        } else throw new StudentException("Provided student is null");
    }

    @Override
    public Student viewStudentByRoll(Integer roll) throws StudentException {
        return studentRepository.findById(roll).orElseThrow(() -> new StudentException("no student found with roll: " + roll));
    }

    @Override
    public Student updateStudent(Integer roll, Student student) throws StudentException {
        Optional<Student> optionalStudent = studentRepository.findById(roll);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setName(student.getName());
            existingStudent.setMarks(student.getMarks());
            return studentRepository.save(existingStudent);
        } else throw new StudentException("No student found with the roll: " + roll);
    }

    @Override
    public Student deleteStudent(Integer roll) throws StudentException {
        Optional<Student> optionalStudent = studentRepository.findById(roll);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            studentRepository.delete(student);
            return student;
        } else throw new StudentException("No student found with the roll: " + roll);
    }

    @Override
    public List<Student> viewAllStudent() throws StudentException {
        return studentRepository.findAll();
    }
}
