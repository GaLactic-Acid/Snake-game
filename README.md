# About
An attempt at making the classic snake game in Java by myself :) 
![snakecopy](https://github.com/user-attachments/assets/d5d5af83-f7d4-4028-9b34-16eb2d5cb0b5)
**To download, press [releases](https://github.com/GaLactic-Acid/Snake-game/tags) and download the 'jar' file of the newest version (currently V1.01).**

# References
**All references/resources used for aid in this project:**
- 2D Graphics: https://www.youtube.com/watch?v=KcEvHq8Pqs0&t=426ss
-  Java MouseListener: https://www.youtube.com/watch?v=jptf1Wd_omw
- reset Button: https://www.youtube.com/watch?v=cA1GvZ5Y3-U
- how to make Jbutton invisible: https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable


## Progress
***(Refer to the GitHub repository's commit history to track the progress of code development in greater detail.)***

*(Progress before not logged but can be found in github commit history)*

**25/12/2024:** 
- Started logging progress
- Added checkbounds (making sure snake stays within window boundaries) for the snake, as well as successfully learning how to utilise ArrayList for Rectangles (snake segments), and updating coordinates for them.
- Learned how to use ActionListener and KeyListener as well as timer to create the project.
- added interaction with pellet and snake where when snake eats pellet, it increases in size (another rectangle is added to 'snakeBody' arraylist), and a new pellet is generated (pelletCoords is updated)

**26/12/2024:**
- Added 'paintScore' in 'MyPanel.java' to display the size increase of the snake.
- Added snake collision to itself
- Added endScreen with Gameover and final score
- **Finished basic game of snake**
- Fixed bug where snake could go off-screen
- removed redundant code in 'actionPerformed' method found in 'MyPanel.java'

**28/12/2024**
- Resolved issue in MyPanel.java's 'actionPerformed' method to prevent illegal snake movement, ensuring the snake cannot move in the opposite direction (e.g., if the snake is moving up, it cannot immediately move down).
- **First (pre)release of 'Snake Game by Hrithik Singh' (V1) in JAR file form.**


**29/12/2024**
- Added reset button

**05/01/2025**
- Fixed endless Boundary issues.

**24/03/2025**
- Added Eyes to snake

**11/04/2025**
- **Released Version 1.01 of Snake Game (JAR)**

**12/04/2025**
- Fixed eye bug which didnt account for previous direction (user input)
- Fixed V1.01 jar file: "A Java exception had occurred" error (caused by reset icon and other images not being in src folder)
- Reset Icon now shows (was invisible)
- Removed exe game version support since it required Java Runtime Environment anyway

## Future Potential Features
- GameMode where the computer plays the snake game (AI)
- Add extra obstacles that get more difficult as the game progresses
- Create a menu to select gameModes
- More details on the snake and background (e.g. interval snake tongue animation)
- Refine the code for 'eyes' in "Snake.java" for easier readability and the ability to edit
- Make game animation more fluent (snake movement is chunky as of now)
- Option for the user to change the snake colour
- User can adjust snake speed
