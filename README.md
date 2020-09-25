#ken-virtual-pets-amok


Your goal in this game is to manage the well-being of a group of virtual pets in a pet shelter for one single day. Since things have been left in disarray, you are confronted with both robotic and organic pets, each of whom is either a dog or a cat. The robotic pets don't need food, but they certainly require oiling, and the organic pets of course require not only food and water, but dogs need to be walked, cats would of course be happier if the communal litter box is clean, and all pets, robotic and organic, need to be healthy and happy. 

You will need to monitor the health of your group of pets and make decisions on the hour for what you think will leave them in a good state of health at the end of the day.


Included are classes and interfaces for virtual pets that can be either organic or robotic, dog or cat. 

RoboticPet and OrganicPet extend VirtualPet, and these in turn are parent classes of RoboticDog, RoboticCat, OrganicDog, and OrganicCat. Cat and Dog interfaces connect behavior of the associated classes.

VirtualPetShelterApp includes the main game loop.
VirtualPetShelter connects with of the remaining classes and also includes the verifiedOption() method to confirm that user input is from available choices, and also the display() method, which displays in several different formats, based on a String input from the user.
