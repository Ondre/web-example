package com.epam.ap.servlet;

import com.epam.ap.first_task.entity.*;
import java.io.IOException;


public class MyFirstServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        try {
            request.setAttribute("Village", VillageFactory.getRandomVillage());
            request.setAttribute("RandomGuard", Guard.GuardType.getRandom());
            request.setAttribute("Name", RandomStringGetter.getString(RandomStringGetter.MALE_NAME));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
       }
        request.getRequestDispatcher("/WEB-INF/sample.jsp").forward(request,response);
    }
}
