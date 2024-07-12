package ru.practice.employee_management_api.service;

import ru.practice.employee_management_api.dto.EmployeeDto;
import ru.practice.employee_management_api.model.EmployeeEntity;
import ru.practice.employee_management_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity addEmployee(EmployeeDto employee) {
        return employeeRepository.save(EmployeeEntity.builder() //TODO Маппинг
                .name(employee.getName())
                .surname(employee.getSurname())
                .passportNumber(employee.getPassportNumber())
                .passportDate(employee.getPassportDate())
                .salary(employee.getSalary())
                .build());
    }


    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseGet(null);
    }

    public String updateEmployeeSalary(Long id, BigDecimal salary) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(id);
        employeeEntity.setSalary(salary);
        employeeRepository.save(employeeEntity);
        return "Зарплата сотрудника успешно обновлена.";
    }

    public String updateEmployeePassport(Long id, String passportNumber, LocalDate passportDate) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(id);
        employeeEntity.setPassportNumber(passportNumber);
        employeeEntity.setPassportDate(passportDate);
        employeeRepository.save(employeeEntity);
        return "Паспортные данные сотрудника успешно обновлены.";
    }
}
