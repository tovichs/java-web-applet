package com.example.project.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CourseSession {
    private Long id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Student student;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Course course;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Instructor instructor;

    private LocalDate enrollmentDate;
}