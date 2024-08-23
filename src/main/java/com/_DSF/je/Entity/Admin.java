package com._DSF.je.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    // Default constructor
    public Admin() {
    }
}
