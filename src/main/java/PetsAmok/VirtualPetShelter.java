package PetsAmok;

import java.util.*;

import static PetsAmok.UserInputStaticMethods.exitGame;

public class VirtualPetShelter {
    ArrayList<VirtualPet> pets = new ArrayList<>();
    private int litterBoxLevel;

    public VirtualPetShelter() {
        litterBoxLevel = 25;
    }

    public void addPet(VirtualPet newPet) {
        pets.add(newPet);
    }

    public int getLitterBoxLevel() {
        return litterBoxLevel;
    }

    public void emptyLitterBox() {
        litterBoxLevel -= 20;
        for (VirtualPet pet : pets) {
            if (pet instanceof OrganicCat) {
                pet.healthLevel += 3;
                pet.happinessLevel += 2;
            }
        }
    }

    public void cleanAllCages() {
        for (VirtualPet pet : pets) {
            if (pet instanceof OrganicDog) {
                ((OrganicDog) pet).cleanCage();
            }
        }
    }

    public void tick() {
        litterBoxLevel += 5;

        for (VirtualPet pet : pets) {
            if (pet instanceof RoboticPet) {
                if (pet.age > 5) {
                    ((RoboticPet) pet).oilThirst += 2;
                } else if (pet.age > 2) {
                    ((RoboticPet) pet).oilThirst += 1;
                }
            } else {
                ((OrganicPet) pet).hunger += 3;
                ((OrganicPet) pet).thirst += 3;
            }
            if (pet instanceof OrganicDog) {
                ((OrganicDog) pet).addCageMess();
            }
        }
    }

    public int totalHealthOfPets() {
        int sum = 0;
        for (VirtualPet pet : pets) {
            sum += pet.healthLevel;
        }
        return sum;
    }

    public void oilAllRobots(int oilAmount) {
        oilRoboticDogs(oilAmount);
        oilRoboticCats(oilAmount);
    }

    public void oilRoboticDogs(int oilAmount) {
        for (VirtualPet pet : pets) {
            if (pet instanceof RoboticDog) {
                ((RoboticPet) pet).giveOil(oilAmount);
            }
        }
    }

    public void oilRoboticCats(int oilAmount) {
        for (VirtualPet pet : pets) {
            if (pet instanceof RoboticCat) {
                ((RoboticPet) pet).giveOil(oilAmount);
            }
        }
    }

    public void feedAllPets(int amountOfFood) {
        feedDogs(amountOfFood);
        feedCats(amountOfFood);
    }

    public void feedDogs(int amountOfFood) {
        for (VirtualPet pet : pets) {
            if (pet instanceof OrganicDog) {
                ((OrganicPet) pet).feedPet(amountOfFood);
            }
        }
    }

    public void feedCats(int amountOfFood) {
        for (VirtualPet pet : pets) {
            if (pet instanceof OrganicCat) {
                ((OrganicPet) pet).feedPet(amountOfFood);
            }
        }
    }

    public void walkDogs(String dogType) {
        if (dogType.equals("RobotDog")) {
            for (VirtualPet pet : pets) {
                if (pet instanceof RoboticDog) {
                    ((Dog) pet).walkDog();
                }
            }
        } else if (dogType.equals("OrganicDog")) {
            for (VirtualPet pet : pets) {
                if (pet instanceof OrganicDog) {
                    ((Dog) pet).walkDog();
                }
            }
        } else {
            walkDogs("RobotDog");
            walkDogs("OrganicDog");
        }
    }

    public void playCatch(String dogType) {
        if (dogType.equals("RobotDog")) {
            for (VirtualPet pet : pets) {
                if (pet instanceof RoboticDog) {
                    ((Dog) pet).playCatch();
                }
            }
        } else if (dogType.equals("OrganicDog")) {
            for (VirtualPet pet : pets) {
                if (pet instanceof OrganicDog) {
                    ((Dog) pet).playCatch();
                }
            }
        } else {
            playCatch("RobotDog");
            playCatch("OrganicDog");
        }
    }

    public void waterDogs(int servingsOfWater) {
        for (VirtualPet pet : pets) {
            if (pet instanceof OrganicDog) {
                ((OrganicDog) pet).waterPet(servingsOfWater);
            }
        }
    }

    public void waterCats(int servingsOfWater) {
        for (VirtualPet pet : pets) {
            if (pet instanceof OrganicCat) {
                ((OrganicCat) pet).waterPet(servingsOfWater);
            }
        }
    }

    public void waterAllPets(int servingsOfWater) {
        waterCats(servingsOfWater);
        waterDogs(servingsOfWater);
    }


    public void chaseDogs(String catType) {
        if (catType.equals("OrganicCat")) {
            for (VirtualPet pet : pets) {
                if (pet instanceof OrganicCat) {
                    ((OrganicCat) pet).happinessLevel += 10;
                    ((OrganicCat) pet).thirst += 5;
                    ((OrganicCat) pet).hunger += 3;
                }
            }
        } else if (catType.equals("RoboticCat")) {
            for (VirtualPet pet : pets) {
                if (pet instanceof RoboticCat) {
                    pet.happinessLevel += 10;
                    ((RoboticCat) pet).oilThirst += 7;
                }
            }
        } else {
            chaseDogs("OrganicCat");
            chaseDogs("RoboticCat");
        }
    }

    public void dogsChased() {
        for (VirtualPet pet : pets) {
            if (pet instanceof OrganicDog) {
                pet.happinessLevel -= 5;
            }
        }
    }


    public void huntMice(String catType) {
        if (catType.equals("OrganicCat")) {
            for (VirtualPet pet : pets) {
                if (pet instanceof OrganicCat) {
                    ((OrganicCat) pet).thirst += 5;
                    ((OrganicCat) pet).hunger -= 5;
                    pet.happinessLevel += 10;
                }
            }
        } else if (catType.equals("RoboticCat")) {
            for (VirtualPet pet : pets) {
                if (pet instanceof RoboticCat) {
                    pet.happinessLevel += 8;
                    ((RoboticCat) pet).oilThirst += 10;
                }
            }
        } else {
            huntMice("OrganicCat");
            huntMice("RoboticCat");

        }
    }

    public String verifiedOption(String[] choices) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> menu = new ArrayList<>();
        for (String item : choices) {
            menu.add(item);
        }
        String reply = (input.nextLine().toLowerCase());
        while (!menu.contains(reply)) {
            if (reply.equals("exit")) {
                exitGame();
            } else if (reply.equals("menu")) {
                for (String item : choices) {
                    System.out.println(item);
                }
            } else if (reply.equals("health")) {
                display("health");
            } else {
                System.out.println("I didn't catch that. Try again please.");
            }
            reply = (input.nextLine().toLowerCase());
        }
        return reply;
    }

    public void display(String choice) {
        if (choice.equals("all")) {
            display("organics");
            display("robots");
            System.out.println("The litter Box level is at:  " + litterBoxLevel);
        } else if (choice.equals("organics")) {
            display("organic dogs");
            display("organic cats");
        } else if (choice.equals("robots")) {
            display("robotic dogs");
            display("robotic cats");
        } else if (choice.equals("dogs")) {
            display("organic dogs");
            display("robotic dogs");
        } else if (choice.equals("cats")) {
            display("organic cats");
            display("robotic cats");
        } else if (choice.equals("robotic dogs")) {
            System.out.println("The Robotic dogs...");
            System.out.println("Name      Health Level   Oil-need   Age");
            for (VirtualPet pet : pets) {
                if (pet instanceof RoboticDog) {
                    System.out.println(pet.toString());
                }
            }
            System.out.println();
        } else if (choice.equals("organic dogs")) {
            System.out.println("Organic dogs...");
            System.out.println("Name      Health Level     Hunger     Thirst     Age   CageMess");
            for (VirtualPet pet : pets) {
                if (pet instanceof OrganicDog) {
                    System.out.println(pet.toString());
                }
            }
            System.out.println();
        } else if (choice.equals("robotic cats")) {
            System.out.println("The Robotic cats...");
            System.out.println("Name      Health Level   Oil-need   Age");
            for (VirtualPet pet : pets) {
                if (pet instanceof RoboticCat) {
                    System.out.println(pet.toString());
                }
            }
            System.out.println();
        } else if (choice.equals("organic cats")) {
            System.out.println("The Organic cats...");
            System.out.println("Name      Health Level     Hunger     Thirst    Age");
            for (VirtualPet pet : pets) {
                if (pet instanceof OrganicCat) {
                    System.out.println(pet.toString());
                }
            }
            System.out.println();
        } else if (choice.equals("health")) {
            Collections.sort(pets);
            System.out.println(" Name          Health\n");
            for (VirtualPet pet : pets) {
                System.out.printf("%-12s %d", pet.getName(), pet.getHealthLevel());
                System.out.println();
            }
        }
    }
}

