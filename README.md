# A_Shapes_Journey
Terminal-based Java RPG game

A Shape's Journey is a terminal-based RPG game where the player begins at level 1 with a standard weapon and is tasked with leveling up and gathering loot,
fighting their way through progressively more difficult rooms in sequence. The game features numerous classes which facilitate an object-oriented approach to
a simple RPG game. Dependencies and build were handled with Maven.

OOP Features:
1) Encapsulation: All data is encapsulated within related classes
2) Inheritance: Notably, weapons, armor, collectibles, potions, etc. all inherit from the base Item class.
3) Polymorphism: Given the general inheritance from the Item class, there are numerous polymorphic methods which vary depending on the subclass.
  For example: The Armor class has a specific damage reduction method which varies from the base method in the item class.

The game features:
1) A health system
2) A turn-based combat system
3) An experience and level-up system
4) A randomized, rarity-based loot system
5) Increasingly difficult rooms with greater experience rewards
6) A couple collections which are gathered throughout the game for the highest-level gear
7) An (x, y) movement system to gather loot from dropped chests
8) Rarity-based loot coloration in the terminal
9) JSON saving of player data
10) Terminal display of player data, including inventory and equipped items

![Endgame Screencap]
(/Users/ryanmckenzie/Desktop/Screen Shot 2020-06-25 at 2.37.42 PM.png)
