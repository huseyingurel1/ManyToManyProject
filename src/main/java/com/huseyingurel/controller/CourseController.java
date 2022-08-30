package com.huseyingurel.controller;

import com.huseyingurel.entity.Course;
import com.huseyingurel.pojos.CourseRequest;
import com.huseyingurel.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;


    @PostMapping("/addcourse")
    public Course addCourse(@RequestBody CourseRequest courseRequest){
        return courseService.addCourseWithContents(courseRequest);
    }
}
