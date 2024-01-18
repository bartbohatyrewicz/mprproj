package com.mpr.proj.data;

import com.mpr.proj.dto.CoursesRead;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student {
    @Id
    @GeneratedValue
    private UUID id;
    private int coursesAmount = 0;
    private String name;
    private String surname;
    private short age;
}
