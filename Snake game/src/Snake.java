public class Snake {
public int snakeLength;
public int snakeDirection; //0 = up, 1 = right, 2 = down, 3 = left
public int snakeSpeed;
public int snakeX;
public int snakeY;
//add position of snake tail as attribute
    public Snake(int snakeX, int snakeY, int snakeLength, int snakeDirection, int snakeSpeed) {
        this.snakeX = snakeX;
        this.snakeY = snakeY;
        this.snakeLength = snakeLength;
        this.snakeDirection = snakeDirection;
        this.snakeSpeed = snakeSpeed;
    };
}
