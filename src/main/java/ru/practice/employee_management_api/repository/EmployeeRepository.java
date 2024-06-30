package ru.practice.employee_management_api.repository;

import ru.practice.employee_management_api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}