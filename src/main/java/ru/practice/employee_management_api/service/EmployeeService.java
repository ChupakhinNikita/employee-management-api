package ru.practice.employee_management_api.service;

import ru.practice.employee_management_api.model.Employee;
import ru.practice.employee_management_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseGet(null);
    }

    public String updateEmployeeSalary(Long id, BigDecimal salary) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setSalary(salary);
        employeeRepository.save(employee);
        return "Зарплата сотрудника успешно обновлена.";
    }

    public String updateEmployeePassport(Long id, String passportNumber, LocalDate passportDate) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setPassportNumber(passportNumber);
        employee.setPassportDate(passportDate);
        employeeRepository.save(employee);
        return "Паспортные данные сотрудника успешно обновлены.";
    }
}
