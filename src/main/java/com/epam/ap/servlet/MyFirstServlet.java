package com.epam.ap.servlet;

import com.epam.ap.first_task.entity.Village;
import com.epam.ap.first_task.entity.VillageFactory;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFirstServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        PrintWriter writer = response.getWriter();
        writer.println("Hello, my first servlet usage example!");

    }
}
