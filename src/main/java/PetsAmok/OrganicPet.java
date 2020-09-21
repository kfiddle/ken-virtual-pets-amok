package PetsAmok;

public abstract class OrganicPet extends VirtualPet {
    protected int hunger;
    protected int thirst;


    public OrganicPet(String name, int age, int happinessLevel, int hunger, int thirst) {
        super(name, age, happinessLevel);
        this.hunger = hunger;
        this.thirst = thirst;
        this.healthLevel = happinessLevel - hunger - thirst;
    }

    abstract void feedPet(int amountOfFood);

    abstract void waterPet(int amountOfWater);

    public void assessHealth(){
        healthLevel = happinessLevel - hunger - thirst;
    }

    public String toString(){
        return String.format("%-10s %10d %10d %10d %7d", name, healthLevel, hunger, thirst, age);
    }
}
