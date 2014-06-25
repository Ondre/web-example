package com.epam.ap.servlet;

import com.epam.ap.first_task.entity.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MyFirstServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Village village = null;
        PrintWriter writer = response.getWriter();
        try {
             village = VillageFactory.getRandomVillage();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        writer.println("Hello, my first servlet usage example!");
        writer.println("Here is my village!");
        writer.println(village);
        if (village != null) {
            writer.println();
            writer.println("Here you can see my village sorted by name: ");
            village.sortByName();
            writer.println(village);
            writer.println();
            writer.println("Village sorted in age between 25 and 30: ");
            writer.println(village.findByAge(25, 30));
            writer.println();
            writer.println("Village sorted by random gender: ");
            writer.println(village.filterByGender(Person.Gender.getRandom()));
            writer.println();
            writer.println("Village filtered by random guard type: ");
            writer.println(village.filterByType(Guard.GuardType.getRandom()));
            writer.println();
            writer.println("Village filtered by random worker type: ");
            writer.println(village.filterByType(Worker.WorkerType.getRandom()));
        }

    }
}
