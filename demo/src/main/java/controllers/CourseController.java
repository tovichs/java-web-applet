package controllers;
import data.ExistingData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import models.Course;
import service.DemoApplication;

@Controller @AllArgsConstructor
public class CourseController {
    private final ExistingData data;
    private final DemoApplication service;
    private final Course course;

    @GetMapping("/")
    public String home()
    {
        return "redirect:/courses";
    }
    @GetMapping("/courses")
    public String courses(Model model)
    {
        model.addAttribute("courses", data.findAllCourses());
        return "courses";
    }

}
