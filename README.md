This is solution by JAVA code for below requirement.
<br>run:
java robot-simulate

REQUIREMENT<br>
The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5
units.
<br> There are no other obstructions on the table surface.
<br> The robot is free to roam around the surface of the table but must be prevented from falling to
destruction. Any movement that would result in the robot falling from the table must be prevented,
however further valid movement commands must still be allowed.
<br> Create an application that can read in commands of the following form -
<br> PLACE X,Y,F
<br> MOVE
<br> LEFT
<br> RIGHT
<br> REPORT
<br> PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST.
<br> The origin (0,0) can be considered to be the SOUTH WEST most corner.
<br> The first valid command to the robot is a PLACE command, after that, any sequence of commands may
be issued, in any order, including another PLACE command. The application should discard all
commands in the sequence until a valid PLACE command has been executed.
<br> MOVE will move the toy robot one unit forward in the direction it is currently facing.
<br> LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without changing the position
of the robot.
<br> REPORT will announce the X,Y and F of the robot. This can be in any form, but standard output is
sufficient.
<br> A robot that is not on the table can choose to ignore the MOVE, LEFT, RIGHT and REPORT commands.
<br> Input can be from a file, or from command line input, as the developer chooses. 

<br Provide test data to demonstrate the application in operation. (file input commands.txt)
<brCONSTRAINTS
<brThe toy robot must not fall off the table during movement. This also includes the initial placement of the toy
robot.
<brAny move that would cause the robot to fall must be ignored.
<brEXAMPLE 1
<brInput:
<br PLACE 0,0,NORTH
<br MOVE
<br REPORT
<brExample Output:
<br 0,1,NORTH
<brEXAMPLE 2
<brInput:
<br PLACE 0,0,NORTH
<br LEFT
<br REPORT
Output:
<br 0,0,WEST
