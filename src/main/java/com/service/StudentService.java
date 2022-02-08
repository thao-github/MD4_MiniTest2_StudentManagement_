package com.service;

import com.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();

    void save(Student student);

    Optional<Student> findById(long id);

    void deleteById (long id);

    List<Student> search(String name);
}
