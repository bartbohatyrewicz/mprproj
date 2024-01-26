package com.mpr.proj.services;

import com.mpr.proj.data.Student;
import com.mpr.proj.mappers.CourseMapper;
import com.mpr.proj.mappers.StudentMapper;
import com.mpr.proj.repo.CourseRepository;
import com.mpr.proj.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DbService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;

    public Student createStudent(Student student){

        


        return null;
    }

    public void deleteStudent(UUID id){
        studentRepository.deleteById(id);
    }

}
