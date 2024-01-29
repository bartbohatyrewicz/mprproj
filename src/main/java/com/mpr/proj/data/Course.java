package com.mpr.proj.data;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private String acronym;
    private String name;
    private String description;
    private int hours;
    @OneToMany(mappedBy = "course")
    private List<Student> students;

    public Course(String acronym, String name, int hours){
        this.acronym = acronym;
        this.name = name;
        this.hours = hours;
    }
}
