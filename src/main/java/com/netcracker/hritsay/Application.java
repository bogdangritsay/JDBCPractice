package com.netcracker.hritsay;


import com.netcracker.hritsay.controllers.MainController;
import com.netcracker.hritsay.dao.OracleDAOConnection;

public class Application {
    public static void main(String[] args) {
        OracleDAOConnection connection = OracleDAOConnection.getInstance();
        MainController controller = new MainController();
        controller.doAction(connection);
    }
    }
