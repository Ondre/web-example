package com.epam.ap.first_task.utill;

import com.epam.ap.first_task.entity.*;
import org.apache.log4j.Logger;

public class Runner {
    private static Logger log = Logger.getLogger(Runner.class);

/*
 java ee history, nginx, tomcat-скачать, запустить, javaserver pages standart tag libraries, webSocket
 порт 8080
 localhost 8080
 web.xml - very important. look all examples. use version 3.0
 servlet container
 index.jsp
 application server -> api
 hw - <packaging>war</packaging>
 application context - гибкость и независимость
 mvc
 <scope> provided servlet-api 3.0.1 & jsp-api 2.2.1
*/
    public static void main(String[] args) throws CloneNotSupportedException {
        Village village = VillageFactory.getRandomVillage();
        village.sortByName();
        village.filterByType(Worker.WorkerType.getRandom());
        village.filterByType(Guard.GuardType.getRandom());
        village.findByAge(25, 30);
        village.filterByGender(Person.Gender.getRandom());
    }
}