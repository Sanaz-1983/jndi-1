package com.example.jndi.controller;

import com.example.jndi.dao.UserDao;
import com.example.jndi.entity.UserEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
UserDao userDao=new UserDao();
        List<UserEntity> all = userDao.getAll();
        for (UserEntity userEntity : all) {
            System.out.println(   userEntity.getFullname());

        }
    }
}
