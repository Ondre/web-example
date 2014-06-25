package com.epam.ap.first_task.entity;

public class Guard extends Person {
    private static final int FIXED_DAILY_SALARY_GUARD = 7;
    private GuardType type;

    public Guard() {

    }

    public GuardType getType() {
        return type;
    }

    public void setType(UnitType type) {
        if (!type.getClass().getName().equals(GuardType.class.getName()))
            throw new IllegalArgumentException("Type not allowed");
        this.type = (GuardType) type;
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void doWork() {
        addCoins(FIXED_DAILY_SALARY_GUARD);
    }

    @Override
    public String toString() {
        return " {" + type + ": " + super.toString() + "}";
    }

    public enum GuardType implements UnitType {
        SWORDSMAN, BOWMAN;

        public static GuardType getRandom() {
            return values()[rnd.nextInt(values().length)];
        }
    }
}