package PetsAmok;

abstract class RoboticPet extends VirtualPet{
    protected int oilThirst;


    public RoboticPet(String name, int age, int happinessLevel, int oilThirst) {
        super(name, age, happinessLevel);
        this.oilThirst = oilThirst;

    }

    abstract void giveOil(int oilAmount);

    public int getOilLevel() {
        return oilThirst;
    }

    public void assessHealth(){
        healthLevel = happinessLevel - oilThirst;
    }

    public String toString(){
        return String.format("%-10s %8d %8d %8d", name, healthLevel, oilThirst, age);

    }
}
