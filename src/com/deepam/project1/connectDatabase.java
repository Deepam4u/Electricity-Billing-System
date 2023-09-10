package com.deepam.project1;

import java.sql.*;

public class connectDatabase {

    Connection c;
    Statement s;
    connectDatabase() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///pms", "root", "DeepaM@2519");
            s = c.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
