package ru.practice.employee_management_api.controller;

import jakarta.validation.Valid;
import ru.practice.employee_management_api.model.EmployeeEntity;
import ru.practice.employee_management_api.service.EmployeeService;
import ru.practice.employee_management_api.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> addEmployee(@Valid @RequestBody EmployeeDto employee) { //TODO Тип данных на вход
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/{id}/salary")
    public ResponseEntity<String> updateEmployeeSalary(@PathVariable Long id, @RequestBody SalaryUpdateDTO salaryUpdateDTO) {  //TODO Тут можно не передавать целый json, а передавать просто значение
        return ResponseEntity.ok(employeeService.updateEmployeeSalary(id, salaryUpdateDTO.getSalary()));
    }

    @PutMapping("/{id}/passport")
    public ResponseEntity<String> updateEmployeePassport(@PathVariable Long id, @RequestBody PassportUpdateDTO passportUpdateDTO) {
        return ResponseEntity.ok(employeeService.updateEmployeePassport(id, passportUpdateDTO.getPassportNumber(), passportUpdateDTO.getPassportDate())); //TODO Тут в качестве параметра лучше передавать весь dto, а уже внутри сервисного метода работать со значениями
    }
}
