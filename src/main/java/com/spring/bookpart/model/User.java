package com.spring.bookpart.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class User
{
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private LocalDate dob;
    private String password;
}
