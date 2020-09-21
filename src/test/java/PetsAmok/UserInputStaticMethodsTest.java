package PetsAmok;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UserInputStaticMethodsTest {
    VirtualPetShelter testShelter = new VirtualPetShelter();

    void setupTest(){

        ArrayList<VirtualPet> petsToAdd = new ArrayList<VirtualPet>();

        petsToAdd.add(new OrganicDog("realdog", 5, 1, 44, 20));
        petsToAdd.add(new RoboticDog("Samuel", 7, 12, 16));
        petsToAdd.add(new RoboticCat("robocat",  13, 25, 11));

        for (VirtualPet pet : petsToAdd) {
            testShelter.pets.put(pet.getName(), pet);
        }
    }

    @Test
    public void testingOurStringInputMethod(){
        //String testAnswer = UserInputStaticMethods.verifyOverallChoice(testShelter);

    }


}
