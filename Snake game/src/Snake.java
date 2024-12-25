import java.awt.Color;
import java.awt.Graphics2D;
public class Snake {
    public int snakeX;
    public int snakeY;
    public Pellet pellet;
    public int speed=4; // to change snake speed
    public int direction = 3; // 0 = up, 1 = down, 2 = left, 3 = right

    // add position of snake tail as attribute
    public Snake(int snakeX, int snakeY, Pellet pellet) {
        this.pellet = pellet;
        this.snakeX = snakeX;
        this.snakeY = snakeY;
    };

    public void paint(Graphics2D snakeG2D) {
        snakeG2D.setColor(Color.white);
        snakeG2D.fillRect(snakeX,snakeY,20,20);
    }

    public void SnakeRight() {

        this.snakeX+=speed;
    }

    public void SnakeLeft() {
        this.snakeX-=speed;
    }

    public void SnakeUp() {
        this.snakeY-=speed;
    }

    public void SnakeDown() {
        this.snakeY+=speed;
    }
}
