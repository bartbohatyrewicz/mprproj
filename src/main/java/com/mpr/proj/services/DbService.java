package com.mpr.proj.services;

import com.mpr.proj.data.Course;
import com.mpr.proj.data.Student;
import com.mpr.proj.dto.CourseCreate;
import com.mpr.proj.dto.CourseRead;
import com.mpr.proj.dto.StudentCreate;
import com.mpr.proj.dto.StudentRead;
import com.mpr.proj.exception.NotFoundException;
import com.mpr.proj.mappers.CourseMapper;
import com.mpr.proj.mappers.StudentMapper;
import com.mpr.proj.repo.CourseRepository;
import com.mpr.proj.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DbService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;

    public Student createStudent(StudentCreate dto){
        Student student = studentMapper.toStudent(dto);
        studentRepository.save(student);
        return student;
    }

    public void deleteStudent(Integer id){
        studentRepository.deleteById(id);
    }

    public StudentRead getStudentById(Integer id){
        return studentRepository.findById(id).map(studentMapper::toStudentDto)
                .orElseThrow(()-> new NotFoundException("Student of given UUID not found"));
    }

    public void deleteAllByCourse(Course course){
        studentRepository.deleteAllByCourse(course);
    }

    public Course createCourse(CourseCreate dto){
        Course course = courseMapper.toCourse(dto);
        courseRepository.save(course);
        return course;
    }

    public void deleteCourse(String acronym){
        courseRepository.deleteByAcronym(acronym);
    }

    public CourseRead getByAcronym(String acronym){
        return courseRepository.findByAcronym(acronym).map(courseMapper::toCourseDto)
                .orElseThrow(() -> new NotFoundException("Course of given acronym ("+acronym+") not found"));
    }

    public int getStudentCountInCourse(String acronym){
        return courseRepository.countStudentsInCourse(acronym)
                .orElseThrow(() -> new NotFoundException("Course of given acronym ("+acronym+") not found"));
    }

}
