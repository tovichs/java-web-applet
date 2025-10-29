package data;
import java.util.*;
import org.springframework.stereotype.Component;

import models.*;
@Component
public class ExistingData {
    public final Map <Long, Course> courses = new LinkedHashMap<>();
    public final Map <Long, Instructor> instructors = new LinkedHashMap<>();
    private long courseSeq = 1;
    private long instructorSeq = 1;

    public ExistingData()
    {
        saveCourse(new Course(null, "C# kurs", "C#", "C#", 60));
        saveCourse(new Course(null, "C++ kurs", "C++", "C++", 60));
        saveCourse(new Course(null, "C kurs", "C", "C", 60));

        //saveInstructor(new Instructor(null, "Ann", "Ann", 3, 0));
    }

    //COURSES
    public List<Course> findAllCourses()
    {
        return new ArrayList<>(courses.values());
    }

    public Course saveCourse(Course course)
    {
        if (course.getId() == null) course.setId(courseSeq++);
        courses.put(course.getId(), course);
        return course;
    }

    public Course findCourseById(Long CourseId)
    {
        return courses.get(CourseId);
    }

    //INSTRUCTORS
    public List<Instructor> findAllInstructors()
    {
        return new ArrayList<>(instructors.values());
    }

    public Instructor saveInstructor(Instructor instructor)
    {
        if(instructor.getId() == null) instructor.setId(instructorSeq++);
        instructors.put(instructor.getId(), instructor);
        return instructor;
    }

    public Instructor findInstructorById(Long instructorId)
    {
        return instructors.get(instructorId);
    }
}