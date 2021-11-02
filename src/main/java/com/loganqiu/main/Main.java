package com.loganqiu.main;


import com.melloware.jintellitype.JIntellitype;

import java.sql.*;

class Main{

    public static void main(String [] args) {
        System.out.println("test");
        System.setProperty("java.library.path", "/");
        JIntellitype.getInstance().registerHotKey(1,0,120);

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\YQTEST\\AppData\\Roaming\\CardReader\\card2");
            System.out.println("open connection successful");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM cardinfo ORDER BY readtime DESC LIMIT 1");

            if (rs.next()) {
                String name = rs.getString("cardname");
                String id = rs.getString("cardid");
                System.out.println(name + " / " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}