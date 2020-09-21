package PetsAmok;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import static PetsAmok.UserInputStaticMethods.*;

public class VirtualPetShelterApp {
    VirtualPetShelter shelter = new VirtualPetShelter();
    String userName = "";
    String nextAnswer = "";
    Scanner answer = new Scanner(System.in);
    int tickCounter = 0;
    String[] initialOptions = {"robots", "organics", "dogs", "cats", "box"};
    String[] robotOptions = {"oil"};
    String[] organicOptions = {"feed", "water"};
    String[] dogOptions = {"walk", "play catch"};
    String[] catOptions = {"chase dogs", "hunt mice"};


    void setup() {
        ArrayList<VirtualPet> petsToAdd = new ArrayList<VirtualPet>();

        petsToAdd.add(new OrganicDog("max", 1, 44, 30, 5));
        petsToAdd.add(new RoboticDog("samuel", 12, 38, 12));
        petsToAdd.add(new RoboticCat("robocat", 13, 25, 11));
        petsToAdd.add(new OrganicDog("wimbley", 1, 40, 20, 5));
        petsToAdd.add(new OrganicCat("dogkiller", 8, 60, 20, 12));
        petsToAdd.add(new OrganicDog("linus", 9, 40, 5, 15));
        petsToAdd.add(new RoboticCat("isabelle", 2, 20, 17));
        petsToAdd.add(new RoboticDog("jack", 5, 12, 10));
        petsToAdd.add(new OrganicCat("gracie", 16, 55, 17, 8));
        petsToAdd.add(new RoboticCat("sophieCita", 12, 17, 9));

        for (VirtualPet pet : petsToAdd) {
            shelter.pets.put(pet.getName(), pet);
        }
    }

    void intro() {
        System.out.println("Welcome. Your job for the day will be to prevent our pet shelter from being over-run. To begin,\n" +
                "I'll need your name please.");
        String preName = answer.nextLine();
        userName = capitalize(preName);
        System.out.println("Thank you " + userName + ". You will be tending to an assortment of pets, both organic and robotic.\n" +
                "They will of course have different needs, and don't forget that these needs might vary with the pet's age. Shall we proceed?\n" +
                "'yes' of 'no'");
        if (!twoOptionVerify("yes", "no")) {
            exitGame();
        }
        System.out.println("Ok then. I'll begin with the current situation. Since nobody showed up to help yesterday,\n" +
                "everything is a mess. Some of the older robotic pets are running out of oil, some of the younger organic pets in particular\n" +
                "are hungry, and the communal litter box is already a problem.\n\nSo, you get the idea. You can do the dogs a big favor by " +
                "making sure you walk them.\nI'll check back in on you at 5 pm, and I hope that by then, you have things under control.\n" +
                "At any point, typing 'exit' will let you leave the game. Shall I go on? 'yes' or 'no'");
        if (!twoOptionVerify("yes", "no")) {
            exitGame();
        } else {
            System.out.println("Just so you know, the game is a little different now. I'll need you to type in exactly what you need.\n" +
                    "You can always type 'menu', and I'll help you with some current choices, and if you need to see all the pets\n" +
                    "listed by their levels of health, enter 'health' at any time during the game.\n" +
                    "Ready then? 'yes' or 'no'.");
        }
        if (!twoOptionVerify("yes", "no")) {
            exitGame();
        }


        while (tickCounter <= 8) {
            String reply = "all";
            displayTime(tickCounter);
            shelter.display("all");
            reply = shelter.verifiedOption(initialOptions);
            if (reply.equals("box")) {
                System.out.println("very wise. Someone had to do it.");
                shelter.emptyLitterBox();
                shelter.tick();
                tickCounter++;

            } else {
                shelter.display(reply);
                System.out.println("Would you like to narrow down to a smaller group, take some action? 'act', or 'narrow'");
                String[] actionType = {"act", "narrow"};
                String newAnswer = shelter.verifiedOption(actionType);

                if (newAnswer.equals("act")) {
                    System.out.println("what would you like to do with these?");
                    if (reply.equals("robots")) {
                        newAnswer = shelter.verifiedOption(robotOptions);

                    } else if (reply.equals("organics")) {
                        newAnswer = shelter.verifiedOption(organicOptions);

                    } else if (reply.equals("dogs")) {
                        newAnswer = shelter.verifiedOption(dogOptions);

                    } else if (reply.equals("cats")) {
                        newAnswer = shelter.verifiedOption(catOptions);
                    }


                } else if (newAnswer.equals("narrow")) {
                    String[] robotOrLive = {"robots", "organics"};
                    String[] catOrDog = {"cats", "dogs"};
                    System.out.println("ok- which group would you like to view?");
                    if (reply.equals("dogs") || reply.equals("cats")) {
                        nextAnswer = shelter.verifiedOption(robotOrLive);
                    } else if (reply.equals("robots") || reply.equals("organics")) {
                        nextAnswer = shelter.verifiedOption(catOrDog);
                    }
                }
                actOnLargePetsGroups(newAnswer);
            }

            if (reply.equals("dogs") && nextAnswer.equals("robots") || reply.equals("robots") && nextAnswer.equals("dogs")) {
                shelter.display("robotic dogs");
                String[] roboDogOptions = {"oil", "play catch", "walk"};
                String answer = shelter.verifiedOption(roboDogOptions);
                if (answer.equals("oil")) {
                    System.out.println("..and how many cups of oil?");
                    int oil = validInteger(10);
                    shelter.oilRoboticDogs(10);
                } else if (answer.equals("play catch")) {
                    shelter.playCatch("RoboticDog");
                } else if (answer.equals("walk")) {
                    shelter.walkDogs("RoboticDog");
                }


            } else if (reply.equals("cats") && nextAnswer.equals("robots") || reply.equals("robots") && nextAnswer.equals("cats")) {
                shelter.display("robotic cats");
                String[] roboCatOptions = {"oil", "chase dogs", "hunt mice"};
                String answer = shelter.verifiedOption(roboCatOptions);
                if (answer.equals("oil")) {
                    System.out.println("..and how many cups of oil?");
                    int oil = validInteger(10);
                    shelter.oilRoboticCats(oil);
                } else if (answer.equals("chase dogs")) {
                    shelter.chaseDogs("RoboticCat");
                    shelter.dogsChased();
                } else if (answer.equals("hunt mice")) {
                    shelter.huntMice("RoboticCat");

                }


            } else if (reply.equals("dogs") && nextAnswer.equals("organics") || reply.equals("organics") && nextAnswer.equals("dogs")) {
                shelter.display("organic dogs");
                String[] realDogOptions = {"feed", "water", "play catch", "walk", "clean cages"};
                String answer = shelter.verifiedOption(realDogOptions);
                if (answer.equals("feed")) {
                    System.out.println("How much would you like to serve?");
                    int foodAmount = validInteger(10);
                    shelter.feedDogs(foodAmount);
                } else if (answer.equals("water")) {
                    System.out.println("How many cups for water for your organic dogs?");
                    int waterCups = validInteger(10);
                    shelter.waterDogs(waterCups);
                } else if (answer.equals("play catch")) {
                    shelter.playCatch("OrganicDog");
                } else if (answer.equals("walk")) {
                    shelter.walkDogs("OrganicDog");
                } else if (answer.equals("clean cages")) {
                    shelter.cleanAllCages();
                }

            } else if (reply.equals("cats") && nextAnswer.equals("organics") || reply.equals("organics") && nextAnswer.equals("cats")) {
                shelter.display("organic cats");
                String[] catOptions = {"feed", "water", "chase dogs", "hunt mice"};
                String answer = shelter.verifiedOption(catOptions);
                if (answer.equals("feed")) {
                    System.out.println("How much would you like to serve your cats?");
                    int foodAmount = validInteger(10);
                    shelter.feedCats(foodAmount);
                } else if (answer.equals("water")) {
                    System.out.println("How many cups for water for your cats?");
                    int waterCups = validInteger(10);
                    shelter.waterCats(waterCups);
                } else if (answer.equals("chase dogs")) {
                    shelter.chaseDogs("OrganicCat");
                    shelter.dogsChased();
                } else if (answer.equals("hunt mice")) {
                    shelter.huntMice("OrganicCat");
                }
            }

            System.out.println();
            shelter.tick();
            tickCounter++;
        }

        System.out.println("And this concludes your day! Would you like to see how did? I will assess the\n " +
                "health of your pets and review your skills as a caretaker. 'yes' or 'no'.");
        if (!twoOptionVerify("yes", "no")) {
            exitGame();
        }
        int totalHealth = shelter.totalHealthOfPets();

        if (totalHealth > 100) {
            System.out.println("These pets are suffering...it's just not your day.");
        } else if (totalHealth > 85) {
            System.out.println("You're doing ok. This could have been worse.");
        } else if (totalHealth > 0) {
            System.out.println("Well done today!");
        }
    }


    public void actOnLargePetsGroups(String action) {
        if (action.equals("oil")) {
            System.out.println("How many quarts for each robot?");
            int quarts = validInteger(10);
            shelter.oilAllRobots(quarts);
        } else if (action.equals("feed")) {
            System.out.println("How many serving for all of your organic pets?");
            int servings = validInteger(10);
            shelter.feedAllPets(servings);
        } else if (action.equals("water")) {
            System.out.println("How many cups per pet?");
            int cups = validInteger(5);
            shelter.waterAllPets(cups);
        } else if (action.equals("walk")) {
            System.out.println("You now have some happy dogs.");
            shelter.walkDogs("all dogs");
        } else if (action.equals("chase dogs")) {
            System.out.println("Well, if you insist. While they're at it, maybe you'd like to get some dog cages cleaned? 'yes' or 'no'");
            if (!twoOptionVerify("yes", "no")) {
                System.out.println("Really? Be a professional.");
            } else {
                shelter.cleanAllCages();
                shelter.chaseDogs("all cats");
                shelter.dogsChased();
            }
        }
    }

    public static void main(String[] args) {
        VirtualPetShelterApp game = new VirtualPetShelterApp();
        game.setup();
        game.intro();
    }
}

