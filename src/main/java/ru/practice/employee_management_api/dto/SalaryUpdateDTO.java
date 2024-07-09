package ru.practice.employee_management_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalaryUpdateDTO {
    private BigDecimal salary;
}