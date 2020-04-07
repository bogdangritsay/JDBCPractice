package com.netcracker.hritsay.controllers;

import com.netcracker.hritsay.dao.OracleDAOConnection;

public interface Controller {
    void doAction(OracleDAOConnection connection);
}
