package com.firstproject.learn_spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController //used for conveting the response to JSON format 
@RequestMapping("/admin")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    //Retrieve all courses
    @GetMapping("/courses")
    public List<Course> RetrieveAllCourses(){
        return courseService.getAllCourses();
    }
    // create new course
    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    // (Command in terminal to add data)curl -X POST -H "Content-Type: application/json" -d '{"id":4, "name":"Java", "author":"John Doe"}' http://localhost:8080/admin/cources

    //Retrieve Course by id
    @GetMapping("/courses/{id}")
    public Course retrieveCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    //Delete Course
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
}
