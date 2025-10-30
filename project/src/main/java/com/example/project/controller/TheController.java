package com.example.project.controller;

import com.example.project.data.TheData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Main controller for displaying lists of courses, instructors, students, and sessions.
 * Uses TheData as an in-memory data store.
 */
@Controller
public class TheController {

    private final TheData data;

    @Autowired
    public TheController(TheData data) {
        this.data = data;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/courses";
    }

    @GetMapping("/courses")
    public String showCourses(Model model) {
        model.addAttribute("courses", data.findAllCourses());
        return "courses"; // corresponds to templates/courses.html
    }

    @GetMapping("/instructors")
    public String showInstructors(Model model) {
        model.addAttribute("instructors", data.findAllInstructors());
        return "instructors"; // corresponds to templates/instructors.html
    }

    @GetMapping("/students")
    public String showStudents(Model model) {
        model.addAttribute("students", data.findAllStudents());
        return "students"; // corresponds to templates/students.html
    }

    @GetMapping("/sessions")
    public String showSessions(Model model) {
        model.addAttribute("sessions", data.findAllSessions());
        return "sessions"; // you'll need templates/sessions.html
    }
}
