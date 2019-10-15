package ru.vlsu.lab5.service.impl;

import org.springframework.stereotype.Component;
import ru.vlsu.lab5.service.interfaces.IConnect;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Connection;

@Stateless
@Component
public class Connect implements IConnect {

    public Connection getConnect() {
        Connection conn = null;
        try {
            Context initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("jdbc/MySQLDataSource");
            conn = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    public void closeConnect(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}