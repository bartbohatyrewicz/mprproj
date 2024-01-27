package com.mpr.proj.dto;

import com.mpr.proj.data.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class StudentRead {
    private Integer id;
    private String name;
    private String surname;
    private int ECTS;
    private short age;
    private Course course;
}
