package PetsAmok;

abstract class VirtualPet implements Comparable<VirtualPet>{
    protected String name;
    protected int age;
    protected int happinessLevel;
    protected int healthLevel;


    public VirtualPet(String name, int age, int happinessLevel) {
        this.name = name;
        this.age = age;
        this.happinessLevel = happinessLevel;
    }

    public int compareTo(VirtualPet that){
        return that.healthLevel - this.healthLevel;
    }

    abstract void assessHealth();

    public String getName() {
        return name;
    }

    public int getHappinessLevel(){
        return happinessLevel;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public abstract String toString();

}

