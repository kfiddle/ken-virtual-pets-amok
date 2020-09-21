package PetsAmok;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualShelterPetTest {
    VirtualPetShelter testShelter = new VirtualPetShelter();

    RoboticDog roboDogTest = new RoboticDog("Samuel", 7, 16, 12);
    RoboticCat roboCatTest = new RoboticCat("robocat", 9, 13, 70);
    OrganicDog realDogTest = new OrganicDog("realdog", 2, 1, 35, 12);
    OrganicCat realCatTest = new OrganicCat("realCat", 5, 8, 37, 11);

    @Test
    public void testCleaningLitterBox() {
        testShelter.emptyLitterBox();
        assertEquals(testShelter.getLitterBoxLevel(), 5);
    }

    @Test
    public void testIfDifferentPetsAreInShelter() {
        testShelter.addPet(roboDogTest);
        testShelter.addPet(roboCatTest);
        testShelter.addPet(realDogTest);
        testShelter.addPet(realCatTest);
        assertEquals(testShelter.pets.size(), 4);
        assertEquals(testShelter.pets.get("Samuel"), roboDogTest);
    }

    @Test
    public void testOurOilMethod() {
        testShelter.addPet(roboDogTest);
        testShelter.addPet(roboCatTest);
        testShelter.addPet(realDogTest);
        testShelter.oilAllRobots(14);
        assertEquals(roboDogTest.getHealthLevel(), 0);
        assertEquals(roboCatTest.getHealthLevel(), 40);
        assertEquals(realDogTest.getHealthLevel(), 12);
    }

    @Test

    public void testCleaningDogCages() {
        testShelter.cleanAllCages();
        assertEquals(realDogTest.getCageMess(), 4);
    }

    @Test
    public void testTickMethod() {
        testShelter.tick();
        assertEquals(realCatTest.hunger, 11);
        assertEquals(realDogTest.getCageMess(), 4);
    }

    @Test
    public void testTotalHealthCalculation() {
        testShelter.addPet(roboDogTest);
        testShelter.addPet(roboCatTest);
        testShelter.addPet(realDogTest);
        testShelter.addPet(realCatTest);
        int health = testShelter.totalHealthOfPets();
        assertEquals(health, 66);
    }

    @Test
    public void testFeedingAllPets() {
        testShelter.addPet(realDogTest);
        testShelter.addPet(realCatTest);
        testShelter.feedAllPets(10);
        assertEquals(realDogTest.hunger, 2);
    }

    @Test
    public void testFeedingCatsOrDogs() {
        testShelter.addPet(realDogTest);
        testShelter.addPet(realCatTest);
        testShelter.feedDogs(10);
        testShelter.feedCats(10);
        assertEquals(realDogTest.hunger, 2);
        assertEquals(realCatTest.hunger, -9);
    }

    @Test
    public void testWateringPets() {
        testShelter.addPet(realDogTest);
        testShelter.addPet(realCatTest);
        testShelter.waterCats(5);
        testShelter.waterDogs(5);
        assertEquals(realCatTest.thirst, -3);
        assertEquals(realDogTest.thirst, -3);
    }

    @Test
    public void testDogWalking() {
        testShelter.addPet(realDogTest);
        testShelter.addPet(roboDogTest);
        testShelter.walkDogs("RobotDog");
        assertEquals(roboDogTest.getHappinessLevel(), 17);
        testShelter.walkDogs("OrganicDog");
        assertEquals(realDogTest.getHappinessLevel(), 43);
    }

    @Test
    public void testPlayingCatch() {
        testShelter.addPet(realDogTest);
        testShelter.playCatch("OrganicDog");
        assertEquals(realDogTest.happinessLevel, 45);
    }

    @Test
    public void testChasingDogs() {
        testShelter.addPet(realCatTest);
        testShelter.chaseDogs("OrganicCat");
        testShelter.dogsChased();
        assertEquals(realCatTest.happinessLevel, 47);
        assertEquals(realDogTest.happinessLevel, 35);
    }

    @Test
    public void testHuntingMice() {
        testShelter.addPet(realCatTest);
        testShelter.addPet(roboCatTest);
        testShelter.huntMice("OrganicCat");
        testShelter.huntMice("RobotCat");
        assertEquals(realCatTest.happinessLevel, 57);
        assertEquals(roboCatTest.happinessLevel, 78);


    }
}



