package PetsAmok;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OrganicDogTest {

    OrganicDog realDogTest = new OrganicDog("realdog", 1, 35, 12, 15);
    OrganicDog linus = new OrganicDog("linus", 9, 40, 15, 15);

    @Test

    public void testInitializeCageMess(){
        assertEquals(linus.getCageMess(), 1);
    }

    @Test
    public void testFeedingDog(){
        linus.feedPet(10);
        assertEquals(linus.hunger, 5);
    }

    @Test void testWateringDog(){
        realDogTest.waterPet(5);
        assertEquals(realDogTest.thirst, 5);
    }

    @Test
    public void testWalkingDog(){
        linus.walkDog();
        assertEquals(linus.getHappinessLevel(), 48);
    }

    @Test
    public void testPlayingCatch(){
        realDogTest.playCatch();
        assertEquals(realDogTest.getHappinessLevel(), 45);
    }

    @Test
    public void testcleaningCage(){
        linus.cleanCage();
        assertEquals(linus.getCageMess(), 0);
        assertEquals(linus.getHealthLevel(), 14);
    }

}