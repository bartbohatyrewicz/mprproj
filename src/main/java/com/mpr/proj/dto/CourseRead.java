package com.mpr.proj.dto;

import com.mpr.proj.data.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CourseRead {
    private String acronym;
    private String name;
    private String description;
    private int hours;
    private List<StudentRead> students;
}
