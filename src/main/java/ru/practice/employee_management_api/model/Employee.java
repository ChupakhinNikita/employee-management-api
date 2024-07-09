package ru.practice.employee_management_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = true)
    private String name;

    @NotNull
    @Column(name = "surname", nullable = true)
    private String surname;

    @Column(name = "passport_number", nullable = true, unique = true)
    private String passportNumber;

    @Column(name = "passport_date", nullable = true)
    private LocalDate passportDate;

    @Column(name = "salary", nullable = true)
    private BigDecimal salary;
}