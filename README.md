#ken-virtual-pets-amok

Included are classes and interfaces for virtual pets that can be either organic or robotic, dog or cat. 

RoboticPet and OrganicPet extend VirtualPet, and these in turn are parent classes of RoboticDog, RoboticCat, OrganicDog, and OrganicCat. Cat and Dog interfaces connect behavior of the associated classes.

VirtualPetShelterApp includes the main game loop.
VirtualPetShelter connects with of the other classes and also includes the verifiedOption() method to confirm that user input is from available choices, and also the display() method, which displays in several different format, based on a String input.
