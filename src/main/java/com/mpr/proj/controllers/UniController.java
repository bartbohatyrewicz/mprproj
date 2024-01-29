package com.mpr.proj.controllers;


import com.mpr.proj.data.Course;
import com.mpr.proj.data.Student;
import com.mpr.proj.dto.CourseCreate;
import com.mpr.proj.dto.CourseRead;
import com.mpr.proj.dto.StudentCreate;
import com.mpr.proj.dto.StudentRead;
import com.mpr.proj.services.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class UniController {

    private final DbService service;

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody StudentCreate dto){
        return service.createStudent(dto);
    }
    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody CourseCreate dto){
        return service.createCourse(dto);
    }
    @GetMapping("/students")
    public List<StudentRead> getStudents(){
        return service.getAllStudents();
    }
    @GetMapping("/students")
    public StudentRead getStudentById(@RequestParam Integer id){
        return service.getStudentById(id);
    }
    @GetMapping("/course")
    public List<CourseRead> getCourses(){
        return service.getAllCourses();
    }
    @GetMapping("/course/{acronym}")
    public CourseRead getCourseByAcronym(@PathVariable String acronym){
        return service.getByAcronym(acronym);
    }
    @GetMapping("/course/{acronym}/count")
    public Integer getStudentCountInCourse(@PathVariable String acronym){
        return service.getStudentCountInCourse(acronym);
    }
    @DeleteMapping("/students")
    public Integer removeStudentById(@RequestParam Integer id){
        return service.deleteStudent(id);
    }
    @DeleteMapping("/course/{acronym}")
    public String deleteCourse(@PathVariable String acronym){
        return service.deleteCourse(acronym);
    }
    @DeleteMapping("/course/{acronym}/students")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Integer deleteStudentsByCourseAcronym(@PathVariable String acronym){
        return service.deleteAllByCourseAcronym(acronym);
    }
}
