package com.epam.ap.first_task.entity;

public class PersonFactory {
    private static final int MAX_COINS_QUANTITY = 10;

    private PersonFactory() {
    }

    public static Person getRandomPerson() {
        Person result;
        if (Person.rnd.nextBoolean()) {
            result = new Worker();
            result.setType(Worker.WorkerType.getRandom());
        } else {
            result = new Guard();
            result.setType(Guard.GuardType.getRandom());
        }
        result.setGender(Person.Gender.getRandom());
        switch (result.getGender()) {
            case MALE:
                result.setName(RandomStringGetter.getString(RandomStringGetter.MALE_NAME));
                break;
            case FEMALE:
                result.setName(RandomStringGetter.getString(RandomStringGetter.FEMALE_NAME));
                break;
        }
        result.setCoins(Person.rnd.nextInt(MAX_COINS_QUANTITY));
        result.setAge(Person.MIN_AGE + Person.rnd.nextInt(Person.MAX_AGE - Person.MIN_AGE));
        return result;
    }
}
