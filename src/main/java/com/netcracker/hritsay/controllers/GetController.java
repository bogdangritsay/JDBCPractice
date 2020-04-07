package com.netcracker.hritsay.controllers;

import com.netcracker.hritsay.dao.OracleDAOConnection;
import com.netcracker.hritsay.entities.Employee;
import com.netcracker.hritsay.views.MainView;


public class GetController implements Controller {
    public void doAction(OracleDAOConnection connection) {
        int id = MainView.enterId();
        Employee emp = null;
        emp =  connection.getEmployee(id);
        System.out.println(emp.toString());
    }
}
