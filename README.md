### Hero and Villians Game

### G4C Project from November 16th/ 17th

This is a Spring MVC Project to practice Loops. In this project:

Method / Controller Basics:

* The App has a Controller (HomeController) and 3 Classes
* Hero and Villian both extend the LivingThing Classes
* LivingThings have a health and a name
* A Hero has a SecretIdentity
* A Villain has a Classification

Functionality:

* A Hero can run an attack on a LivingThing, which inflicts a random amount of damage (1-10) from both the Hero and the Villain
* A single Hero is created, and an Array of 5 Villains are created for the Hero to fight (initGame method)
* When either the Hero or All Villians are dead the Game ends (isGameOver method)
* When a Monster has 0 Health, it is removed from the Monsters Array (killMonster method)
* A Reset button is displayed on the page to create a new game (initGame method)

Loop Specifics:

* Hitting the /death page starts a while loop which calls the isGameOver Method
* Inside that loop is a for loop which loops over the ourMonsters Array
* For each Monster Object, the Hero attacks them
* If a Monster goes to 0 Health (isAlive method) killMonster() is called and passed the Monster Object
* killMonster() removes the Object from the Array
* for loop continues to process the same through the additional Objects in the array until isGameOver is satisfied