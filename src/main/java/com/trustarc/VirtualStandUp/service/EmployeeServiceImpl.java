package com.trustarc.VirtualStandUp.service;

import com.trustarc.VirtualStandUp.dao.EmployeeDao;
import com.trustarc.VirtualStandUp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService {

    @Autowired  EmployeeDao employeeDao;

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return employeeDao.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeDao.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(Employee theId) {
        employeeDao.delete(theId);
    }
}
