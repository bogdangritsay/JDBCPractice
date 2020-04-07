package com.netcracker.hritsay.dao;



import com.netcracker.hritsay.entities.Employee;

import java.sql.Date;

public interface DAOConnection {
    void connect();
    void disconnect();
    Employee getEmployee(int id);
    void createEmployee(Employee emp);
    void deleteEmployee(int id);

}
