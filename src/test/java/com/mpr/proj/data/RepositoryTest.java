package com.mpr.proj.data;

import com.mpr.proj.repo.CourseRepository;
import com.mpr.proj.repo.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class RepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    void saveNew(){
        var course = new Course("MPR", "Metody programowania", 60);
        var student = new Student("Bartosz", "Bohatyrewicz", 0, (short)23, course);
        courseRepository.save(course);
        studentRepository.save(student);
    }

    @Test
    void givenOneStudentWhenCountStudentsThenReturnOne(){
        assertTrue(courseRepository.countStudentsInCourse("MPR").isPresent());
        assertEquals(1, courseRepository.countStudentsInCourse("MPR"));
    }
}
