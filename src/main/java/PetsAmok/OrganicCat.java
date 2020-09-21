package PetsAmok;


public class OrganicCat extends OrganicPet implements Cat {

    public OrganicCat(String name, int age, int happiness, int hunger, int thirst) {
        super(name, age, happiness, hunger, thirst);
        healthLevel = happinessLevel - hunger - thirst;
    }

    @Override
    void feedPet(int amountOfFood) {
        hunger -= amountOfFood * 2;
    }

    @Override
    void waterPet(int amountOfWater) {
        thirst -= amountOfWater * 3;
    }


    @Override
    public void chaseDogs() {
        happinessLevel += 10;
        hunger += 5;
    }

    @Override
    public void huntMice() {
        happinessLevel += 5;
        hunger -= 5;

    }

}
