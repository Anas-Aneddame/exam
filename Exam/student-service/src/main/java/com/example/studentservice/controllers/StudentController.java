package com.example.studentservice.controllers;

import com.example.studentservice.entity.Student;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
    public class StudentController {
        private StudentRepository studentRepository;
        public StudentController(StudentRepository studentRepository) {
            this.studentRepository = studentRepository;
        }
        @GetMapping("/students")
        public List<Student> studentList(){
            return studentRepository.findAll();
        }

        @GetMapping("/students/{id}")
        public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
            Optional<Student> student = studentRepository.findById(String.valueOf(id));
            return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }




    }


