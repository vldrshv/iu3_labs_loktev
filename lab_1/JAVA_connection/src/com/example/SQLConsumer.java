package com.example;

import java.sql.ResultSet;

public interface SQLConsumer {
    String SELECT_ALL = "SELECT * FROM ";

    void extractQuery(String query);
}
