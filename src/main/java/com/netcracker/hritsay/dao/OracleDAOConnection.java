package com.netcracker.hritsay.dao;

import com.netcracker.hritsay.entities.Employee;
import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

public class OracleDAOConnection implements DAOConnection {
    private static OracleDAOConnection oracleDAOConnection;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private Driver driver;
    private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String USER = "NCSQLPR2";
    private final String PASSWORD = "356897-Bnm";

    public static OracleDAOConnection getInstance() {
        if (oracleDAOConnection != null) {
            return oracleDAOConnection;
        } else {
            oracleDAOConnection = new OracleDAOConnection();
            return oracleDAOConnection;
        }
    }


    public void connect() {
        try {
            driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection.isClosed()) {
                System.out.println("Connection is closed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();
            if(resultSet != null) {
                resultSet.close();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployee(int id) {
        connect();
        Employee emp = null;
        boolean realId = false;
        try {
            statement = connection.prepareStatement("SELECT * FROM EMP WHERE EMPNO =  ?");
                statement.setInt(1, id);
                resultSet =  statement.executeQuery();
                if (resultSet.next()) {
                    emp = parseEmployee(resultSet);
                } else {
                    System.out.println("Employee with this ID not found in database!");
                }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return emp;
    }

    public Employee parseEmployee(ResultSet resultSet) {
        Employee employee = null;
        try {
            int id = resultSet.getInt("EMPNO");
            String eName = resultSet.getString("ENAME");
            String job = resultSet.getString("JOB");
            int managerId = resultSet.getInt("MGR");
            Date hireDate = resultSet.getDate("HIREDATE");
            float salary = resultSet.getFloat("SAL");
            float commissions = resultSet.getFloat("COMM");
            int depNumber = resultSet.getInt("DEPTNO");
            employee = new Employee(id, eName, job, managerId, hireDate, salary, commissions, depNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void createEmployee(Employee emp) {
        connect();
        try {
            statement = connection.prepareStatement("INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)"
                    + "VALUES(emp_seq.nextval, ?, ?, ?, ?, ?, ? ,? )");
            statement.setString(1, emp.geteName());
            statement.setString(2, emp.getJob());

            if(emp.getManagerId() == 0)  {
                statement.setNull(3, Types.INTEGER);
            } else {
                statement.setInt(3, emp.getManagerId());
            }

            statement.setDate(4, emp.getHireDate());
            statement.setFloat(5, emp.getSalary());

            if(emp.getCommissions() == 0) {
                statement.setNull(6, Types.FLOAT);
            } else {
                statement.setFloat(6, emp.getCommissions());
            }

            statement.setInt(7, emp.getDepNumber());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public void deleteEmployee(int id) {
        connect();
        try {
            statement = connection.prepareStatement("DELETE FROM EMP WHERE EMPNO = ?");
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public boolean checkId(int id) {
        connect();
        try {
            statement = connection.prepareStatement("SELECT * FROM EMP WHERE EMPNO =  ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return false;
    }

    private ResultSet takeResult(int id) {
        connect();
        try {
            statement = connection.prepareStatement("SELECT * FROM EMP WHERE EMPNO =  ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return resultSet;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return null;
    }
}
