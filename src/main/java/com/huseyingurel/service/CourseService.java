package com.huseyingurel.service;

import com.huseyingurel.entity.Course;
import com.huseyingurel.entity.CourseContents;
import com.huseyingurel.pojos.CourseRequest;
import com.huseyingurel.repository.CourseContentRepository;
import com.huseyingurel.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.ManyToMany;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseContentRepository coursecontentRepository;

    public CourseService(){

    }

    public Course addCourseWithContents(CourseRequest courseRequest){
        Course course = new Course();
        course.setId(courseRequest.id);
        course.setCoursename(courseRequest.coursename);
        course.setCoursecontents(courseRequest.coursecontents
                .stream()
                .map(coursecontents -> {
                    CourseContents ccontents = coursecontents;
                    if(ccontents.getId() > 0){
                        ccontents = coursecontentRepository.findById(ccontents.getId());
                    }
                    ccontents.addCourse(course);
                    return ccontents;
                })
                .collect(Collectors.toSet()));
        return courseRepository.save(course);

    }



}
