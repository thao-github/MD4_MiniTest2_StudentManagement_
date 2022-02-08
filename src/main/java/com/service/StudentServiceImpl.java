package com.service;

import com.model.Student;
import com.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public Optional<Student> findById(long id) {
        return studentRepo.findById(id);
    }

    @Override
    public void deleteById(long id) {
        studentRepo.deleteById(id);

    }

    @Override
    public List<Student> search(String name) {
        return studentRepo.findAllByName(name);
    }
}
