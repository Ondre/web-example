package com.epam.ap.first_task.entity;


public class Worker extends Person {

    private static final int MAX_SALARY_BUILDER = 7;
    private static final int MAX_SALARY_FARMER = 5;
    private static final int MAX_SALARY_LUMBERJACK = 6;
    private static final int MAX_SALARY_FISHERMAN = 5;
    private static final int FIXED_DAILY_SALARY_WORKER = 2;

    private WorkerType type;

    public Worker() {

    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public WorkerType getType() {
        return type;
    }

    public void setType(UnitType type) {
        if (!type.getClass().getName().equals(WorkerType.class.getName()))
            throw new IllegalArgumentException("Type not allowed");
        this.type = (WorkerType) type;
    }

    @Override
    public String toString() {
        return "\n {" + type + ": " + super.toString() + "}";
    }

    public void doWork() {
        switch (type) {
            case BUILDER:
                addCoins(FIXED_DAILY_SALARY_WORKER + Person.rnd.nextInt(MAX_SALARY_BUILDER + 1));
                break;
            case FARMER:
                addCoins(FIXED_DAILY_SALARY_WORKER + Person.rnd.nextInt(MAX_SALARY_FARMER + 1));
                break;
            case LUMBERJACK:
                addCoins(FIXED_DAILY_SALARY_WORKER + Person.rnd.nextInt(MAX_SALARY_LUMBERJACK + 1));
                break;
            case FISHERMAN:
                addCoins(FIXED_DAILY_SALARY_WORKER + Person.rnd.nextInt(MAX_SALARY_FISHERMAN + 1));
                break;
        }
    }

    public enum WorkerType implements UnitType {
        BUILDER, FARMER, LUMBERJACK, FISHERMAN;

        public static WorkerType getRandom() {
            return values()[Person.rnd.nextInt(values().length)];
        }
    }
}
