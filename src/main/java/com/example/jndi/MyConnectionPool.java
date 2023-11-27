package com.example.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import java.sql.Connection;
import java.sql.SQLException;

public class MyConnectionPool {
    private static  MyConnectionPool myConnectionPool=new MyConnectionPool();
    private DataSource dataSource;
    private MyConnectionPool(){
        try {
            Context ctx=new InitialContext();
            dataSource= (DataSource) ctx.lookup("java:comp/env/jdbc/myConnection");


        } catch (NamingException e) {
            e.printStackTrace();
        }


    }
    public static Connection getConnection(){
        try {
            return myConnectionPool.dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }


    }
}
