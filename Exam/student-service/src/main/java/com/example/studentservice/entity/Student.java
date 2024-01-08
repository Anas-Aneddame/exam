package com.example.studentservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {
    @Id
    private Long id;
    private String nom;
    private String nomClass;
    @ElementCollection
    @CollectionTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id")
    )
    @Column(name = "course_id")
    private Set<Long> courseIds = new HashSet<>();


}
