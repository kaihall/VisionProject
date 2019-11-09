# VisionProject2

This project has everything you need to run the Game Engine for the Vision Project in Object Oriented Design

Note: The project https://github.com/mlepinski/VisionProject has only the files related to the PlayerTeam interface 
(which is what you are implementing for this project)
This project additionally has the backend code for actually running a game

To run a game, compile all of the java files in LepinskiEngine (you will need JavaFX)
   javac LepinskiEngine\*java
Then run: 
   java LepinskiEngine.GameEngine

Note: This code assumes that your active (current) directory contains the example1.maze

This project includes a TestTeam as an example (that team is bad and will not pick up any coins)
If you want to run the GameEngine with a different type of PlayerTeam, 
... You can change the line in the Constructor of GameEngine which creates a new TestTeam()

In the Graphical Display, the Gold dots are Coins. 
The big C is your Coin Bot, and the big S letters are your Scout Bots
When multiple Robots occupy the same square, the game just shows one Robot, but makes the letter BOLD
The Bold indicates that there is another Robot sharing the square

Don't hesitate to email me if you have any questions!
