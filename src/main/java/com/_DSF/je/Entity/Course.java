package com._DSF.je.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

//the final version

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
    private User teacher;

    @ManyToMany(mappedBy = "courses")
    private Set<User> students;


    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private Set<Assignment> assignments;

    //@OneToMany(mappedBy = "course")
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Quiz> quizzes;

    @OneToMany(mappedBy = "course")
    private Set<Video> videos;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}