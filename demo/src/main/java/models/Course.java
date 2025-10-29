package models;
import lombok.*;

@Getter @Setter @AllArgsConstructor @Builder
public class Course
{
    public Long id;
    public String name;
    public String type;
    public String description;
    public int length;
}