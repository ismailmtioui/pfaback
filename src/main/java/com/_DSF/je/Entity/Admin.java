package com._DSF.je.Entity;

import com._DSF.je.Enumeration.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Admin extends User{

    // Default constructor
    public Admin() {
    }
}
