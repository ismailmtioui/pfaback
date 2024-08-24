package com._DSF.je.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Teacher extends User{

    @OneToMany(mappedBy = "teacher")
    private Set<Course> coursesTaught;

    // Default constructor
    public Teacher() {
    }
}
