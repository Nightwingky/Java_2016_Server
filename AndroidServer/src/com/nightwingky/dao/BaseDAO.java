package com.nightwingky.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by nightwingky on 16-12-31.
 */
public class BaseDAO {

    protected Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/db_java_shopping_cart";
            conn = DriverManager.getConnection(url, "nightwingky", "666796");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    protected void closeConnection(Connection conn) {
        if(conn == null)
            return;
        try {
            conn.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
