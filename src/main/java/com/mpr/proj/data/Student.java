package com.mpr.proj.data;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private int ECTSdebt;
    private String name;
    private String surname;
    private short age;
    @ManyToOne
    private Course course;

    public Student(String name, String surname, int ECTSdebt, short age, Course course) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.course = course;
        this.ECTSdebt = ECTSdebt;
    }
}
