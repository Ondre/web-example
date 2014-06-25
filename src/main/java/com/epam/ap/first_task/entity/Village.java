package com.epam.ap.first_task.entity;

import org.apache.log4j.Logger;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Village implements Comparable<Village>, Cloneable {
    private static final Logger log = Logger.getLogger(Village.class);
    private String name;
    private List<Person> villagers = new ArrayList<>();

    public Village() {
    }

    public void addPerson(Person p) {
        if (null == p) throw new NullPointerException("addPerson(null) not allowed");
        villagers.add(p);
    }

    public void removePerson(Person p) {
        if (null == p) throw new NullPointerException("removePerson(null) not allowed");
        villagers.remove(p);
    }

    @Override
    public int compareTo(Village o) {
        return this.villagers.size() > o.villagers.size() ? 1 :
                this.villagers.size() < o.villagers.size() ? -1 : 0;
    }

    public List<Person> getVillagers() {
        List<Person> result = new ArrayList<>();
        for (Person villager : villagers) {
            try {
                result.add(villager.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return villagers;
    }

    @Override
    public Village clone() throws CloneNotSupportedException {
        Village result = (Village) super.clone();
        result.name = this.name;
        result.villagers = new ArrayList<>();
        for (Person unit : this.villagers) {
            result.villagers.add(unit.clone());
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (null == name) throw new NullPointerException("Null not allowed.");
        this.name = name;
    }

    public void sortByName() {
        Collections.sort(villagers, Person.NAME_COMPARATOR);
        log.info("Village " + name + " was sorted by name: \n " + this);
    }

    public void sortByCoins() {
        Collections.sort(villagers);
    }

    @Override
    public String toString() {
        return "Village " + "'" + name + "'" + " {" + "Villagers: " + villagers + '}';
    }

    public void goNextDay() {
        for (Person unit : villagers) {
            unit.liveDay();
        }
    }

    private List<Person> getFilteredList(VillageFilter f) {
        List<Person> result = new ArrayList<>();
        for (Person villager : villagers) {
            if (f.filter(villager))
                result.add(villager);
        }
        return result;
    }

    public List<Person> findByAge(int min, int max) {
        if (min > max) throw new InvalidParameterException("'Min' age can't be greater than 'Max' age.");
        List<Person> result = getFilteredList(p -> p.getAge() >= min && p.getAge() <= max);
        log.info("Was found " + result.size() + " villagers according to findByAge(" + min + "-" + max + " years) request: \n" + result);
        return result;
    }

    public List<Person> filterByType(UnitType type) {
        if (null == type) throw new InvalidParameterException("Type cannot be null");
        List<Person> result;
        result = getFilteredList(p -> p.getType() == type);
        log.info("Was found " + result.size() + " villagers according to filterByType(" + type + ") request: \n" + result);
        return result;
    }

    public List<Person> filterByGender(Person.Gender gender) {
        if (null == gender) throw new InvalidParameterException("Gender cannot be null");
        List<Person> result;
        result = getFilteredList(p -> p.getGender() == gender);
        log.info("Was found " + result.size() + " villagers according to filterByGender(" + gender + ") request: \n" + result);
        return result;
    }
}
