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

    // Store the image as a byte array
    @Lob
    private byte[] image;

    // Additional fields specific to Admin can be added here

    // Default constructor
    public Admin() {
    }

    // Constructor with all arguments
    public Admin(Long id, String username, String password, String email, byte[] image) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.image = image;
    }
}

