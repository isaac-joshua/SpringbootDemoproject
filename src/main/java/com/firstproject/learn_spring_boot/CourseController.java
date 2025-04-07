package com.firstproject.learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/admin")
public class CourseController {
    
    @GetMapping("/cources")
    public List<Course> RetrieveAllCourses(){
        return Arrays.asList(
            new Course(1,"aws", "joshua"),
            new Course(2,"cloud", "joshua")
        );
    }


}
