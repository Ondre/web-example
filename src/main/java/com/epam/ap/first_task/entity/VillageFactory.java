package com.epam.ap.first_task.entity;

import org.apache.log4j.Logger;

public class VillageFactory {
    private static Logger log = Logger.getLogger(VillageFactory.class);
    private VillageFactory() {
    }

    public static Village getRandomVillage(int quantity) {
        Village result = new Village();
        result.setName(RandomStringGetter.getString(RandomStringGetter.VILLAGE_NAME));
        for (int i = 0; i < quantity; i++) result.addPerson(PersonFactory.getRandomPerson());
        log.info("Village with " + result.getVillagers().size() + " villagers was created: \n" + result);
        return result;
    }

    public static Village getRandomVillage() throws CloneNotSupportedException {
        return getRandomVillage(1 + Person.rnd.nextInt(30));
    }
}
