package com._DSF.je.Entity;

import com._DSF.je.Enumeration.Role;
import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    // Store the image as a byte array
    @Lob
    private byte[] image;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Additional common fields for all users
}
