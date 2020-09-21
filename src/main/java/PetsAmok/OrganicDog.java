package PetsAmok;

public class OrganicDog extends OrganicPet implements Dog {

    private int cageMess;


    public OrganicDog(String name, int age, int happinesslevel, int hunger, int thirst) {
        super(name, age, happinesslevel, hunger, thirst);
        if (age < 3) {
            cageMess = 4;
        } else if (age < 6) {
            cageMess = 2;
        } else if (age < 10) {
            cageMess = 1;
        }
        healthLevel = happinessLevel - hunger - thirst - cageMess;
    }

    public int getCageMess() {
        return cageMess;
    }

    public void addCageMess() {
        cageMess += 1;
    }

    public void assessHealth() {
        healthLevel = happinessLevel - hunger - thirst - cageMess;
    }

    @Override
    void feedPet(int amountOfFood) {
        hunger -= amountOfFood;
    }

    @Override
    void waterPet(int amountOfWater) {
        thirst -= amountOfWater * 2;

    }


    @Override
    public void walkDog() {
        happinessLevel += 8;
        hunger += 5;
        thirst += 4;
    }

    @Override
    public void playCatch() {
        happinessLevel += 10;
        hunger += 5;

    }

    public void cleanCage() {
        if (cageMess > 3) {
            cageMess -= 3;
        } else if (cageMess > 0) {
            cageMess -= 1;
        }
        happinessLevel += 2;
        healthLevel += 5;
    }

    public String toString() {
        return super.toString() + "    " + cageMess;
    }


}




