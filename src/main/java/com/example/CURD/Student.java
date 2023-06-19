package com.example.CURD;

public class Student {
    private int id;
    private String studentName;
    private String password;
    private String email;

    public Student() {

    }

    public Student(String studentName, String password, String email) {
        this.studentName = studentName;
        this.password = password;
        this.email = email;
    }

    public Student(int id, String studentName, String password, String email) {
        this.id = id;
        this.studentName = studentName;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
