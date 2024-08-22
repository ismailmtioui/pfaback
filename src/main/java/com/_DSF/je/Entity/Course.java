package com._DSF.je.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses")  // Updated to match Student entity
    private Set<Student> students;

    @OneToMany(mappedBy = "course")
    private Set<Assignment> assignments;

    @OneToMany(mappedBy = "course")
    private Set<Quiz> quizzes;

    @OneToMany(mappedBy = "course")
    private Set<Video> videos;
}
