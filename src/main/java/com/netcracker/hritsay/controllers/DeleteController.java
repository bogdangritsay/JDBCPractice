package com.netcracker.hritsay.controllers;

import com.netcracker.hritsay.dao.OracleDAOConnection;
import com.netcracker.hritsay.views.MainView;


public class DeleteController implements Controller {

    public void doAction(OracleDAOConnection connection) {
        int id = MainView.enterId();
        if(connection.checkId(id)) {
            connection.deleteEmployee(id);
        } else {
            System.out.println("The employee with this id was not found!");
        }
    }
}
