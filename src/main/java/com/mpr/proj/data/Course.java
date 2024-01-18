package com.mpr.proj.data;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course {
    @Id
    private String acronym;
    private String name;
    private String description;
    private int hours;
    @OneToMany
    private List<Student> students;
}
