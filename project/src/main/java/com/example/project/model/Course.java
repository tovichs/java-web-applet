package com.example.project.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Fixed Course model.
 *
 * Note: Lombok does not allow mixing @Singular and @Builder.Default on the same field.
 * To avoid the compiler error, @Singular annotations have been removed and collections
 * are kept initialized via @Builder.Default so the object is safe to use without the builder.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Course {
    private Long id;
    private String name;
    private String description; // can be null
    private String duration;    // can be null
    private boolean active;

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Instructor> instructors = new ArrayList<>();

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CourseSession> sessions = new ArrayList<>();
}
