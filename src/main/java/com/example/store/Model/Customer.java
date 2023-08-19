package com.example.store.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should be not empty")
    @Size(min = 3 ,message = "name is too short")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @NotEmpty(message = "email should be not empty")
    @Email(message = "email is invalid")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotEmpty(message = "password should be not empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
    @Column(columnDefinition = "varchar(30) not null ")
    private String password;
    @NotEmpty(message = "address should be not empty")
    @Column(columnDefinition = "varchar(100) not null ")
    private String address;
    @NotEmpty(message = "phone number should be not empty")
    @Size(min = 10, max = 10)
    @Column(columnDefinition = "varchar(10) not null unique")
    private String phoneNumber;
    @NotNull(message = "balance should be not empty")
    @PositiveOrZero
    @Column(columnDefinition = "int default 0 ")
    private Double balance;
}
