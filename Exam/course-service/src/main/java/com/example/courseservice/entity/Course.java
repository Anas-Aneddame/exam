package com.example.courseservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Course {
    @Id
    private Long id;
    private String nom;
    private String prenom;
    @ElementCollection
    @CollectionTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "course_id")
    )
    @Column(name = "student_id")
    private Set<Long> studentIds = new HashSet<>();

}
