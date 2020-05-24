# iHoover

Syrine BEN AMEUR.

This project is about an automatic hoover that is supposed to sweep a room assimilated to a grid following a chain of commands.

This project is in Java 8.

In this project 3 classes were formed along with the Main class.

Class Grid : Can be initialized from console by the user using the function createGrid. It allows the user to set the dimensions of the grid (room). The dimensions incdicate the number of grid cells.

Class Hoover : This class allows the user to mark the initial position of the hoover via the function initiateHoover; it takes the info from the console. This class has a moving function that is "move" which calls on 3 other functions according to the received command. If the command is to turn right, it calls upon the function "rotateToTheRight", if the command is to turn left, it calls "rotateToTheLeft", if the command is to move forward, it calls the function "advance".

Class Instructions : This class reads the commands of the user from the console and it executes them one by one using the function "execute" which calls the Hoover function "move" for each single command.

At last it shows the last position of the hoover.

A few controls have also been implemented regarding the different inputs and allowed movements.
