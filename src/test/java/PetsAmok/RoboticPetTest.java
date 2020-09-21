package PetsAmok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoboticPetTest {
    RoboticDog sam = new RoboticDog("samuel", 12, 38, 12);
    RoboticCat sarah = new RoboticCat("robocat", 13, 25, 11);

    @Test
    public void testOilingPets(){
        sam.giveOil(5);
        assertEquals(sam.getOilLevel(), 7 );
    }

    @Test
    public void testHuntMice(){
        sarah.huntMice();
        assertEquals(sarah.getOilLevel(), 21);
    }

    @Test
    public void testWalkingRoboDog(){
        sam.walkDog();
        assertEquals(sam.happinessLevel, 43);
    }


}
