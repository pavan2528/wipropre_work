package com.example.onetoone.service;

import com.example.onetoone.entity.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
}
