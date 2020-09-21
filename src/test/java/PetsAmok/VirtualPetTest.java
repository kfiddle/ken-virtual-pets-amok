package PetsAmok;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class VirtualPetTest {
    RoboticDog roboDogTest = new RoboticDog("Samuel",16, 12, 12);
    RoboticCat roboCatTest = new RoboticCat("robocat", 13, 70, 30);
    OrganicDog realDogTest = new OrganicDog("realdog", 1, 35, 12, 7);
    OrganicCat realCatTest = new OrganicCat("realCat", 8, 37, 11, 12);



    @Test
    public void testIfPetIsCreated() {
        assertEquals(realCatTest.getHappinessLevel(), 37);
        assertEquals(realCatTest.getName(), "realCat");
        assertEquals(realDogTest.getHealthLevel(), 12);

    }

    @Test
    public void testComparingPetsForSorting(){
        int difference = roboDogTest.compareTo(roboCatTest);
        assertEquals(difference, 40);
    }

}
