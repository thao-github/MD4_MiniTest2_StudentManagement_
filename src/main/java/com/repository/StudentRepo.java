package com.repository;

import com.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {
    @Query(value = "select s from Student s where s.name like concat('%',:name, '%')")
    List<Student> findAllByName(@Param("name") String name);
}