package com.mpr.proj.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseCreate {
    @NotBlank
    private String acronym;
    @NotBlank
    private String name;
    @Nullable
    private String description;

    private int hours = 0;
}
