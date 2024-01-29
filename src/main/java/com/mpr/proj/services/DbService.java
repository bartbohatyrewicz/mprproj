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
import jakarta.transaction.Transactional;
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


    @Transactional
    public Boolean saveBoth(StudentCreate studentDto, CourseCreate courseDto){
        Student student = studentMapper.toStudent(studentDto);
        Course course = courseMapper.toCourse(courseDto);
        studentRepository.save(student);
        courseRepository.save(course);
        return true;
    }
    @Transactional
    public Student createStudent(StudentCreate dto){
        Student student = studentMapper.toStudent(dto);
        studentRepository.save(student);
        return student;
    }

    @Transactional
    public Integer deleteStudent(Integer id){
        studentRepository.findById(id).map(studentMapper::toStudentDto)
                .orElseThrow(()-> new NotFoundException("Student of given id ("+id+") not found"));
        studentRepository.deleteById(id);
        return id;
    }


    public StudentRead getStudentById(Integer id){
        return studentRepository.findById(id).map(studentMapper::toStudentDto)
                .orElseThrow(()-> new NotFoundException("Student of given id ("+id+") not found"));
    }

    public List<StudentRead> getAllStudents(){
        return studentRepository.findAll().stream().map(studentMapper::toStudentDto).toList();
    }

    @Transactional
    public Integer deleteAllByCourseAcronym(String acronym){
        Integer count = courseRepository.countStudentsInCourse(acronym)
                .orElseThrow(() -> new NotFoundException("Course of given acronym ("+acronym+") not found"));
        studentRepository.deleteAllByCourseAcronym(acronym);
        return count;
    }

    @Transactional
    public Course createCourse(CourseCreate dto){
        Course course = courseMapper.toCourse(dto);
        courseRepository.save(course);
        return course;
    }

    @Transactional
    public String deleteCourse(String acronym){
        courseRepository.findByAcronym(acronym).map(courseMapper::toCourseDto)
                .orElseThrow(() -> new NotFoundException("Course of given acronym ("+acronym+") not found"));
        deleteAllByCourseAcronym(acronym);
        courseRepository.deleteByAcronym(acronym);
        return acronym;
    }

    public CourseRead getByAcronym(String acronym){
        return courseRepository.findByAcronym(acronym).map(courseMapper::toCourseDto)
                .orElseThrow(() -> new NotFoundException("Course of given acronym ("+acronym+") not found"));
    }

    public int getStudentCountInCourse(String acronym){
        return courseRepository.countStudentsInCourse(acronym)
                .orElseThrow(() -> new NotFoundException("Course of given acronym ("+acronym+") not found"));
    }
    public List<CourseRead> getAllCourses(){
        return courseRepository.findAll().stream().map(courseMapper::toCourseDto).toList();
    }

}
