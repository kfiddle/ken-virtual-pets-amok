package PetsAmok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrganicCatTest {
    OrganicCat grace = new OrganicCat("gracie", 16, 25, 17, 8);


    @Test
    public void testIfOrganicCatCreated() {
        assertEquals(grace.getHappinessLevel(), 25);
    }

    @Test
    public void canIFeedCat() {
        grace.feedPet(5);
        assertEquals(grace.hunger, 7);
    }

    @Test
    public void canIChaseDogs(){
        grace.chaseDogs();
        assertEquals(grace.getHappinessLevel(), 35);
    }

    @Test
    public void canIHuntMice(){
        grace.huntMice();
        assertEquals(grace.getHappinessLevel(), 30);
        assertEquals(grace.hunger, 12);
    }

}
