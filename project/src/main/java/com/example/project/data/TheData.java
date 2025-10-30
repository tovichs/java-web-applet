package com.example.project.data;

import com.example.project.model.Course;
import com.example.project.model.CourseSession;
import com.example.project.model.Instructor;
import com.example.project.model.Student;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class TheData {
    private static final AtomicLong courseSeq = new AtomicLong(1L);
    private static final AtomicLong instructorSeq = new AtomicLong(1L);
    private static final AtomicLong studentSeq = new AtomicLong(1L);
    private static final AtomicLong sessionSeq = new AtomicLong(1L);

    private static final Map<Long, Course> courses = new HashMap<>();
    private static final Map<Long, Instructor> instructors = new HashMap<>();
    private static final Map<Long, Student> students = new HashMap<>();
    private static final Map<Long, CourseSession> sessions = new HashMap<>();

    static {
        students.put(1L, new Student(1L, "Dnn", "Dnnie"));
        students.put(2L, new Student(2L, "Enn", "Ennie"));
        students.put(3L, new Student(3L, "Fnn", "Fnnie"));
        studentSeq.set(4L);

        courses.put(1L, Course.builder().id(1L).name("C").description("C Language").duration("30 hours").active(true).build());
        courses.put(2L, Course.builder().id(2L).name("C++").description("C++ Language").duration("40 hours").active(true).build());
        courses.put(3L, Course.builder().id(3L).name("C#").description("C# Language").duration("50 hours").active(true).build());
        courseSeq.set(4L);

        instructors.put(1L, Instructor.builder().id(1L).name("Ann").surname("Annie").description("Expert in C").email("ann.annie@mail.com").build());
        instructors.put(2L, Instructor.builder().id(2L).name("Bnn").surname("Bnnie").description("Expert in C++").email("bnn.bnnie@mail.com").build());
        instructors.put(3L, Instructor.builder().id(3L).name("Cnn").surname("Cnnie").description("Expert in C#").email("cnn.cnnie@mail.com").build());
        instructorSeq.set(4L);

        CourseSession s1 = CourseSession.builder().id(1L).student(students.get(1L)).course(courses.get(1L)).instructor(instructors.get(1L)).enrollmentDate(LocalDate.now()).build();
        sessions.put(1L, s1);
        sessionSeq.set(2L);
    }

    // Course-related
    public List<Course> findAllCourses() {
        return new ArrayList<>(courses.values());
    }

    public Course findCourse(Long id) {
        return courses.get(id);
    }

    public Course saveCourse(Course c) {
        if (c.getId() == null) c.setId(courseSeq.getAndIncrement());
        courses.put(c.getId(), c);
        return c;
    }

    // Instructor-related
    public List<Instructor> findAllInstructors() {
        return new ArrayList<>(instructors.values());
    }

    public Instructor findInstructor(Long id) {
        return instructors.get(id);
    }

    public Instructor saveInstructor(Instructor i) {
        if (i.getId() == null) i.setId(instructorSeq.getAndIncrement());
        instructors.put(i.getId(), i);
        return i;
    }

    // Student-related
    public List<Student> findAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student findStudent(Long id) {
        return students.get(id);
    }

    public Student saveStudent(Student s) {
        if (s.getId() == null) s.setId(studentSeq.getAndIncrement());
        students.put(s.getId(), s);
        return s;
    }

    // CourseSession-related (was Enrollment)
    public List<CourseSession> findAllSessions() {
        return new ArrayList<>(sessions.values());
    }

    public CourseSession findSession(Long id) {
        return sessions.get(id);
    }

    public CourseSession saveSession(CourseSession sess) {
        if (sess.getId() == null) sess.setId(sessionSeq.getAndIncrement());
        sessions.put(sess.getId(), sess);
        return sess;
    }
}