package com.example.studentresultmanagementsystem.dto;

import com.example.studentresultmanagementsystem.validator.DateOfBirth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;


public class StudentDTO {


    @NotBlank(message = "The firstName is required.")
    private String firstName;

    @NotBlank(message = "The lastName is required.")
    private String lastName;

    @NotNull
    @DateOfBirth(message = "Age should be greater than 10")
    private LocalDate dateOfBirth;

    @NotBlank
    @Email(message = "Email address is not valid")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                '}';
    }
}
