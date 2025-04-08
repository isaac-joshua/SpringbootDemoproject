package com.firstproject.learn_spring_boot;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
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

    //Retrieve Course by id
    @GetMapping("/courses/{id}")
    public Course retrieveCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    //Delete Course
    @DeleteMapping
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
}
