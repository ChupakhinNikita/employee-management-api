package ru.practice.employee_management_api.repository;

import org.springframework.stereotype.Repository;
import ru.practice.employee_management_api.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository //TODO Аннотация
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}