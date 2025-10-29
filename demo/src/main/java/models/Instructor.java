package models;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @AllArgsConstructor @Builder
public class Instructor
{
    public Long id;
    public String name;
    public String surname;
    public int workExperience;
    @Builder.Default public List<Course> courses = new ArrayList<>();

    public void addCourse(Course c)
    {
        courses.add(c);
    }
}