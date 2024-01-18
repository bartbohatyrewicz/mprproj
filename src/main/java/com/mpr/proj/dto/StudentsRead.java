package com.mpr.proj.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class StudentsRead {
    private UUID id;
    private String name;
    private String surname;
    private int ECTS;
    private short age;
}
