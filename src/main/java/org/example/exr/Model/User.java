package org.example.exr.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "cant be empty")
    @Size(min = 5, message = "Name must be at least 5 characters long")
    @Column(columnDefinition ="varchar(5) check (length(name)>5) not null" )
    private String name;

    @NotEmpty(message = "cant be empty")
    @Size(min = 5, message = "Name must be at least 5 characters long")
    @Column(columnDefinition ="varchar(5) check (length(username)>5) not null unique" )
    private String username;

    @NotNull(message = "cant be null")
    @Column(columnDefinition ="varchar(20) not null" )
    private String password;

    @NotEmpty(message = "Email can't be empty")
    @Email
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotNull(message = "Role can't be null")
    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role must be either 'Admin' or 'User'")
    @Column(columnDefinition = "varchar(10) not null  check(role='admin' or role='user')")
    private String role;

    @NotNull(message = "Age can't be null")
    @Column(columnDefinition = "int not null ")
    private Integer age;
}
