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
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployeeSalary(Long id, BigDecimal salary) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            employee.setSalary(salary);
            return employeeRepository.save(employee);
        }
        return null;
    }

    public Employee updateEmployeePassport(Long id, String passportNumber, LocalDate passportDate) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            employee.setPassportNumber(passportNumber);
            employee.setPassportDate(passportDate);
            return employeeRepository.save(employee);
        }
        return null;
    }
}
