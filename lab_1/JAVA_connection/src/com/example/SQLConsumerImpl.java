package com.example;

import java.sql.*;


public class SQLConsumerImpl extends SQLConnection implements SQLConsumer{


    public SQLConsumerImpl(){
        super();
    }

    public SQLConsumerImpl(String url, String user, String password){
        super(url, user, password);
    }

    public void extractQuery(String query) {
        try{
            this.setResultSet(getStatement().executeQuery(query));
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * TODO: Описать методы SELECT *, UPDATE и тд.
     */
}
