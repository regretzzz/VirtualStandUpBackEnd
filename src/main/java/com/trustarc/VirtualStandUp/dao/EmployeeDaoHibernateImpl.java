package com.trustarc.VirtualStandUp.dao;

import com.trustarc.VirtualStandUp.entity.Employee;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {
    private EntityManager entityManager;


    @Autowired
    public EmployeeDaoHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        Session session = entityManager.unwrap(Session.class);

        Query<Employee> theQuery =
                session.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Session session = entityManager.unwrap(Session.class);

        Employee theEmployee = session.get(Employee.class, theId);

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(theEmployee);
    }

    @Override
    public void delete(Employee theEmployee) {
        Session session = entityManager.unwrap(Session.class);

        Query theQuery = session.createQuery("delete from Employee where id=:employeeId");

        theQuery.setParameter("employeeId",theEmployee.getId() );

        theQuery.executeUpdate();

    }
}
