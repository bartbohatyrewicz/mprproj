package com.mpr.proj.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CoursesRead {
    private String name;
    private String acronym;
    private String description;
    private List<UUID> studentId;
    private int temp;
}
