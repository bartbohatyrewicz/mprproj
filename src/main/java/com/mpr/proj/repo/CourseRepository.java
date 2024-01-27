package com.mpr.proj.repo;

import com.mpr.proj.data.Course;
import com.mpr.proj.data.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

    @Query("select count(course.students) from Course course where course.acronym = :acronym")
    Optional<Integer> countStudentsInCourse(String acronym);

    @Transactional
    @Modifying
    void deleteByAcronym(String acronym);

    Optional<Course> findByAcronym(String acronym);

    @Override
    List<Course> findAll();
}
