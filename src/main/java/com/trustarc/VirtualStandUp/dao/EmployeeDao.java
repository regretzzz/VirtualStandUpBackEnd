package com.trustarc.VirtualStandUp.dao;

import com.trustarc.VirtualStandUp.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeDao {
    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee theEmployee);

    public void delete(Employee theEmployee);
}
