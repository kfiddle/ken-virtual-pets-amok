package PetsAmok;

public class RoboticDog extends RoboticPet implements Dog {


    public RoboticDog(String name, int age, int happinessLevel, int oilThirst) {
        super(name, age, happinessLevel, oilThirst);
        healthLevel = happinessLevel - oilThirst;
    }


    @Override
    public void walkDog() {
        happinessLevel += 5;
        oilThirst += 5;

    }

    @Override
    public void playCatch() {
        happinessLevel +=5;
        oilThirst +=7;

    }

    @Override
    void giveOil(int oilServing) {
        oilThirst -= oilServing;
    }
}

