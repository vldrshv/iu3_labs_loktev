package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        SQLConsumerImpl sqlConsumer = new SQLConsumerImpl();
        sqlConsumer.extractQuery(sqlConsumer.SELECT_ALL + sqlConsumer.TABLE_LOGIN);

        try {
            ResultSet rs = sqlConsumer.getResultSet();
            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " - " +
                        rs.getString(2) + " - " +
                        rs.getString(3) + " - " +
                        rs.getDate(4).toString());
            }
        } catch (NullPointerException | SQLException e) {
            e.printStackTrace();
        }

        sqlConsumer.close();
    }
}
