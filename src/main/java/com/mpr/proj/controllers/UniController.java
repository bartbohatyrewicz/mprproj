package com.mpr.proj.controllers;


import com.mpr.proj.dto.CourseRead;
import com.mpr.proj.dto.StudentRead;
import com.mpr.proj.services.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class UniController {

    private final DbService service;

    @PostMapping("/students")
    public void createStudent(){}
    @PostMapping("/courses")
    public void createCourse(){}
    @GetMapping("/students")
    public List<StudentRead> getStudents(){
        return service.getAllStudents();
    }
    @GetMapping("/students/{id}")
    public StudentRead getStudentById(@PathVariable Integer id){
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

}
