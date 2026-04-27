package com.sci;

import com.sci.dao.DBEmployee;
import com.sci.models.Employee;
import com.sci.util.DBConfig;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DBEmployee db = new DBEmployee();

        // 1. Get all employees
        List<Employee> list = db.get();
        list.forEach(e ->
                System.out.println(e.getFirstName() + " " + e.getLastName()));

        // 2. Get by ID
        Employee emp = db.get(100);
        System.out.println("Found: " + emp.getFirstName());

        // 3. Always shut down!
        DBConfig.shutdown();
    }
}