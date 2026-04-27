package com.sci.dao;

import com.sci.models.Employee;
import com.sci.util.DBConfig;
import org.hibernate.*;
import java.util.List;

public class DBEmployee {

    // ── Get ALL employees ─────────────────────
    public List<Employee> get() {
        try (Session s = DBConfig.SESSION_FACTORY.openSession()) {
            return s.createQuery("FROM Employee", Employee.class)
                    .list();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }
    }

    // ── Get by Primary Key ────────────────────
    public Employee get(Integer id) {
        try (Session s = DBConfig.SESSION_FACTORY.openSession()) {
            return s.get(Employee.class, id); // null if not found
        }
    }

    // ── Insert a new Employee ─────────────────
    public Integer insert(Employee emp) {
        Transaction tx = null;
        try (Session s = DBConfig.SESSION_FACTORY.openSession()) {
            tx = s.beginTransaction();
            Integer id = (Integer) s.save(emp);
            tx.commit();
            return id;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            return null;
        }
    }
}