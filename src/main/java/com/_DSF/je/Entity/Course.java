package com._DSF.je.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore // Avoid serialization issues
    private User teacher;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore // Avoid serialization issues
    private Set<User> students;

    @OneToMany(mappedBy = "course")
    @JsonIgnore // Avoid serialization issues
    private Set<Assignment> assignments;

    @OneToMany(mappedBy = "course")
    @JsonIgnore // Avoid serialization issues
    private Set<Quiz> quizzes;

    @OneToMany(mappedBy = "course")
    @JsonIgnore // Avoid serialization issues
    private Set<Video> videos;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore // Avoid serialization issues
    private Category category;
}
