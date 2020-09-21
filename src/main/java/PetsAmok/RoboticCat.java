package PetsAmok;

public class RoboticCat extends RoboticPet implements Cat {

    public RoboticCat(String name, int age, int happinessLevel, int oilThirst) {
        super(name, age, happinessLevel, oilThirst);
        healthLevel = happinessLevel - oilThirst;
    }

    @Override
    void giveOil(int oilAmount) {
        oilThirst -= oilAmount * 2;
    }


    @Override
    public void chaseDogs() {
        happinessLevel += 10;
        oilThirst += 5;
    }


    @Override
    public void huntMice() {
        happinessLevel += 5;
        oilThirst += 10;

    }
}

