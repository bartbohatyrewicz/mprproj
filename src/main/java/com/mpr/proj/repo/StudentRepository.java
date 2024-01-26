package com.mpr.proj.repo;

import com.mpr.proj.data.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends CrudRepository<Student, UUID> {

    @Transactional
    @Modifying
    void deleteById(UUID uuid);

    List<Student> findAllByName(String name);

}
