package com.netcracker.hritsay.controllers;


import com.netcracker.hritsay.dao.OracleDAOConnection;
import com.netcracker.hritsay.views.MainView;


import java.util.Scanner;

public class MainController implements Controller {
    private MainView view = new MainView();

    public void doAction(OracleDAOConnection connection) {
        do {
            Scanner sc = new Scanner(System.in);
            int action;
            view.drawMainMenu();
            action = sc.nextInt();
            try {
                switch (action) {
                    case 1:

                        break;
                    case 2:
                        GetController getController = new GetController();
                        getController.doAction(connection);
                        break;
                    case 3:
                        AddController addController = new AddController();
                        addController.doAction(connection);
                        break;
                    case 4:
                        DeleteController deleteController = new DeleteController();
                        deleteController.doAction(connection);
                        break;
                    case 5:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Undefined action!");
                        break;

                }
            } catch (NullPointerException e) {
                System.out.println("Error.");
                e.printStackTrace();
            }

        } while(true);

    }






}
