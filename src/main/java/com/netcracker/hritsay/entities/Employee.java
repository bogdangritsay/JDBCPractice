package com.netcracker.hritsay.entities;

import java.sql.Date;

public class Employee {
    private int id;
    private String eName;
    private String job;
    private int managerId;
    private Date hireDate;
    private float salary;
    private float commissions;
    private int depNumber;

    public Employee(int id, String eName, String job, int managerId, Date hireDate, float salary, float commissions, int depNumber) {
        this.id = id;
        this.eName = eName;
        this.job = job;
        this.managerId = managerId;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissions = commissions;
        this.depNumber = depNumber;
    }

    @Override
    public String toString() {
        return "ID EMLOYEE:  " + id +
                "\t NAME: " + eName +
                "\t JOB: " + job  +
                "\t MGR_ID: " + managerId +
                "\t HIREDATE: " + hireDate +
                "\t salary: " + salary +
                "\t COMMISSIONS: " + commissions +
                "\t DEPNUMBER: " + depNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getCommissions() {
        return commissions;
    }

    public void setCommissions(float commissions) {
        this.commissions = commissions;
    }

    public int getDepNumber() {
        return depNumber;
    }

    public void setDepNumber(int depNumber) {
        this.depNumber = depNumber;
    }
}
