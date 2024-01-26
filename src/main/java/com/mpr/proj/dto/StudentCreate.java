package com.mpr.proj.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentCreate {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    private int ECTS = 0;
    @NotBlank
    private short age;
}
