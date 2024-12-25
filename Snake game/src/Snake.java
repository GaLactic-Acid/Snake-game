import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Dimension;
public class Snake {
    public int snakeX;
    public int snakeY;
    public Pellet pellet;
    public int speed=4; // to change snake speed
    public int direction = 3; // 0 = up, 1 = down, 2 = left, 3 = right
    int snakeWidth = 20;
    int snakeHeight = 20;
    Dimension panelSize;

    // add position of snake tail as attribute
    public Snake(int snakeX, int snakeY, Pellet pellet, Dimension panelSize) {
        this.panelSize = panelSize;
        this.pellet = pellet;
        this.snakeX = snakeX;
        this.snakeY = snakeY;
    };

    public void paint(Graphics2D snakeG2D) {
        snakeG2D.setColor(Color.white);
        snakeG2D.fillRect(snakeX,snakeY,snakeWidth,snakeHeight);
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
public void checkBounds() {
    if(snakeX<0-snakeWidth) {
        snakeX = panelSize.width;
    }
    if(snakeX>panelSize.width) {
        snakeX = 0;
    }
    if(snakeY<0-snakeHeight) {
        snakeY = panelSize.height;
    }
    if(snakeY>panelSize.height) {
        snakeY = 0;
    }
}
}
