package com.repository;

import com.model.Classroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepo extends CrudRepository<Classroom, Long> {
}
