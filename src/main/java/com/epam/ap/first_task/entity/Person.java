package com.epam.ap.first_task.entity;

import java.util.Comparator;
import java.util.Random;

public abstract class Person implements Comparable<Person>, Cloneable {

    static final int MIN_AGE = 15;
    static final int MAX_AGE = 60;
    public static Random rnd = new Random();
    public static Comparator<Person> NAME_COMPARATOR = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            String firstUnit = o1.getName().toUpperCase();
            String secondUnit = o2.getName().toUpperCase();
            return firstUnit.compareTo(secondUnit);
        }
    };
    private Gender gender;
    private String name;
    private int age;
    private int coins;

    protected Person() {
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void subtractCoins(int value) {
        if (value <= this.coins) this.coins -= value;
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    @Override
    public int compareTo(Person o) {
        return this.getCoins() > o.getCoins() ? 1 :
                this.getCoins() < o.getCoins() ? -1 : 0;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new NullPointerException("Name cannot be empty");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= MIN_AGE && age <= MAX_AGE) this.age = age;
        else throw new IllegalArgumentException("Unable to set this age to a person.");
    }

    public void addCoins(int goldenCoins) {
        if (goldenCoins >= 0)
            this.coins += goldenCoins;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", coins=" + coins;
    }

    public abstract void doWork();

    public void buyFood() {
        subtractCoins(3 + rnd.nextInt(3));
    }

    public void liveDay() {
        doWork();
        buyFood();
    }

    public abstract UnitType getType();

    public abstract void setType(UnitType type);

    public enum Gender {
        MALE, FEMALE;

        public static Gender getRandom() {
            return values()[Person.rnd.nextInt(values().length)];
        }
    }
}
