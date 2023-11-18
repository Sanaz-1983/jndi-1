package com.example.jndi.dao;


import com.example.jndi.MyConnectionPool;
import com.example.jndi.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public UserEntity get(String username) {


        try (Connection connection=MyConnectionPool.getConnection()){
            String sql="select * from user where username=?";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                UserEntity userEntity=new UserEntity();
                userEntity.setUsername(username);
                userEntity.setPassword(rs.getString("password"));
                userEntity.setFullname(rs.getString("fullname"));
                return userEntity;
            }
            else  return null;

        }

         catch (SQLException e) {
            e.printStackTrace();
             System.out.println(e);
             return null;
        }


    }
    public List<UserEntity> getAll() {


        try (Connection connection=MyConnectionPool.getConnection()){
            String sql="select * from user";
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            List<UserEntity>list=new ArrayList<>();
            while(rs.next()){
                UserEntity userEntity=new UserEntity();
                userEntity.setUsername(rs.getString("username"));
                userEntity.setPassword(rs.getString("password"));
                userEntity.setFullname(rs.getString("fullname"));
                list.add(userEntity);

            }
            return list;

        }

        catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            return null;
        }


    }

}
