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
}
