package com.mpr.proj.mappers;

import com.mpr.proj.data.Student;
import com.mpr.proj.dto.StudentCreate;
import com.mpr.proj.dto.StudentRead;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentRead toStudentDto(Student student){
        StudentRead dto = new StudentRead();
        dto.setId(student.getId());
        dto.setAge(student.getAge());
        dto.setName(student.getName());
        dto.setSurname(student.getSurname());
        dto.setECTSdebt(student.getECTSdebt());
        return dto;
    }

    public Student toStudent(StudentCreate studentCreate){
        Student student = new Student();
        student.setName(studentCreate.getName());
        student.setSurname(studentCreate.getSurname());
        student.setECTSdebt(studentCreate.getECTSdebt());
        student.setAge(studentCreate.getAge());
        return student;
    }
}
