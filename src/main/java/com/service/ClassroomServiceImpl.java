package com.service;

import com.model.Classroom;
import com.repository.ClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    ClassroomRepo classroomRepo;

    @Override
    public List<Classroom> findALl() {
        return (List<Classroom>) classroomRepo.findAll();
    }
}
