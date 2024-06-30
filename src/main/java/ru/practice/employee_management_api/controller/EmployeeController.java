package ru.practice.employee_management_api.controller;

import ru.practice.employee_management_api.model.Employee;
import ru.practice.employee_management_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(newEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employeeOpt = employeeService.getEmployeeById(id);
        return employeeOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/salary")
    public ResponseEntity<Employee> updateEmployeeSalary(@PathVariable Long id, @RequestBody SalaryUpdateRequest salaryUpdateRequest) {
        Employee updatedEmployee = employeeService.updateEmployeeSalary(id, salaryUpdateRequest.getSalary());
        return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/passport")
    public ResponseEntity<Employee> updateEmployeePassport(@PathVariable Long id, @RequestBody PassportUpdateRequest passportUpdateRequest) {
        Employee updatedEmployee = employeeService.updateEmployeePassport(id, passportUpdateRequest.getPassportNumber(), passportUpdateRequest.getPassportDate());
        return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
    }

    public static class SalaryUpdateRequest {
        private BigDecimal salary;

        public BigDecimal getSalary() {
            return salary;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }
    }

    public static class PassportUpdateRequest {
        private String passportNumber;
        private LocalDate passportDate;

        public String getPassportNumber() {
            return passportNumber;
        }

        public void setPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
        }

        public LocalDate getPassportDate() {
            return passportDate;
        }

        public void setPassportDate(LocalDate passportDate) {
            this.passportDate = passportDate;
        }
    }
}
