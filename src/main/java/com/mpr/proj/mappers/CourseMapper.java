package com.mpr.proj.mappers;

import com.mpr.proj.data.Course;
import com.mpr.proj.dto.CourseCreate;
import com.mpr.proj.dto.CourseRead;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseRead toCourseDto(Course course){
        CourseRead dto = new CourseRead();
        dto.setAcronym(course.getAcronym());
        dto.setName(course.getName());
        dto.setHours(course.getHours());
        dto.setDescription(course.getDescription());
        return dto;
    }

    public Course toCourse(CourseCreate courseCreate){
        Course course = new Course();
        course.setName(courseCreate.getName());
        course.setAcronym(courseCreate.getAcronym());
        course.setHours(courseCreate.getHours());
        course.setDescription(courseCreate.getDescription());
        return course;
    }
}
