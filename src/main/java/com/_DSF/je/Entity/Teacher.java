package com._DSF.je.Entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends User {
    @OneToMany(mappedBy = "teacher")
    private Set<Course> coursesTaught;
}
