# About
An attempt at making the classic snake game in Java by myself. 

**To download, press [releases](https://github.com/GaLactic-Acid/Snake-game/tags) and download either the 'exe' or 'jar' file of the newest version (currently V1).**

# References
**All references/resources used for aid in this project:**
- 2D Graphics: https://www.youtube.com/watch?v=KcEvHq8Pqs0&t=426ss
-  Java MouseListener: https://www.youtube.com/watch?v=jptf1Wd_omw
- reset Button: https://www.youtube.com/watch?v=cA1GvZ5Y3-U
- how to make Jbutton invisible: https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable


## Progress
***(Refer to the GitHub repository's commit history to track the raw progress of code development.)***

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
- **First (pre)release of 'Snake Game by Hrithik Singh' in both exe and JAR file form.**


**29/12/2024**
- Added reset button

## Future Potential Features
- Fix endless mode glitch where snake stops if it hit upper boundary
- GameMode where the computer plays the snake game (AI)
- Add extra obstacles which get more difficult as the game progresses
- Create a menu to select gameModes
- More details to the snake and background
- Make game animation more fluent (snake movement is chunky as of now)
