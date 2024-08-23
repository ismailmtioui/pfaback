package com._DSF.je.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    @OneToMany(mappedBy = "teacher")
    private Set<Course> coursesTaught;

    // Default constructor
    public Teacher() {
    }
}
