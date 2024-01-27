package com.mpr.proj.data;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private int ECTS;
    private String name;
    private String surname;
    private short age;
    @ManyToOne
    private Course course;
}
