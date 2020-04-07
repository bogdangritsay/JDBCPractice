package com.netcracker.hritsay.controllers;

import com.netcracker.hritsay.dao.OracleDAOConnection;
import com.netcracker.hritsay.entities.Employee;
import com.netcracker.hritsay.views.MainView;

public class AddController {
    public void doAction(OracleDAOConnection connection) {
        Employee emp = MainView.enterEemployee();
        connection.createEmployee(emp);


    }
}
