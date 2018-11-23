package com.example;

import java.sql.*;

public abstract class SQLConnection {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    private String URL = "jdbc:mysql://localhost:3306/labs";
    private String USER = "root";
    private String PASSWORD = "1234";

    public String TABLE_LOGIN = "login_table";

    public SQLConnection(){
        makeConnection();
        createStatement();
    }
    public SQLConnection(String url, String user, String password){
        this.URL = url;
        this.USER = user;
        this.PASSWORD = password;

        makeConnection();
        createStatement();
    }

    private void makeConnection() {
        try{
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void createStatement() {
        try{
            stmt = con.createStatement();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void close(){
        try{ con.close(); } catch (SQLException e) { e.printStackTrace(); }
        try{ stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        try{ rs.close(); } catch (SQLException e) { e.printStackTrace(); }
    }

    public Connection getConnection() {
        return con;
    }

    public Statement getStatement() {
        return stmt;
    }

    public ResultSet getResultSet() {
        return rs;
    }

    public void setResultSet(ResultSet rs) {
        this.rs = rs;
    }
}
