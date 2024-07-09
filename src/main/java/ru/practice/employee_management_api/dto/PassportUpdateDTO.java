package ru.practice.employee_management_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PassportUpdateDTO {
    private String passportNumber;
    private LocalDate passportDate;
}