package com.epam.ap.first_task.entity;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RandomStringGetter {
    public static final int MAX_LINE_NUMBER = 70;
    public static final String MALE_NAME = "MaleVillagerNames.txt";
    public static final String FEMALE_NAME = "FemaleVillagerNames.txt";
    public static final String VILLAGE_NAME = "VillageNames.txt";
    public static final String NO_RESULT = "no result";

    public static String getString(String fileName) {
        try {
            return runThroughFile(fileName, Person.rnd.nextInt(MAX_LINE_NUMBER));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return NO_RESULT;
    }

    private static String runThroughFile(String fileName, int lineNumber) throws IOException {
        InputStream is = RandomStringGetter.class.getClassLoader().getResourceAsStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        int i = 0;
        while (i < lineNumber) {
            br.readLine();
            i++;
        }
        String result = br.readLine();
        if (result != null) {
            return result;
        }
        return runThroughFile(fileName, Person.rnd.nextInt(MAX_LINE_NUMBER));
    }
}