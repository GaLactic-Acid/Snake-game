import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Snake {

    public int snakeX;
    public int snakeY;
    public Pellet pellet;
    public int speed=25; // to change snake speed
    public int direction = 3; // 0 = up, 1 = down, 2 = left, 3 = right
    public int pDirection = 3; // previous direction
    int snakeWidth = 25;
    int snakeHeight = 25;
    Dimension panelSize;
    public ArrayList<Rectangle> snakeBody = new ArrayList<Rectangle>();
    // public ArrayList<Integer> snakeXPos = new ArrayList<Integer>();
    // public ArrayList<Integer> snakeYPos = new ArrayList<Integer>();

    // add position of snake tail as attribute
    public Snake(int snakeX, int snakeY, Pellet pellet, Dimension panelSize) {
        snakeBody.add(new Rectangle(snakeX,snakeY,snakeWidth,snakeHeight));
        // snakeXPos.add(snakeBody.get(0).x);
        // snakeYPos.add(snakeBody.get(0).y);
        for(int i=1; i<4; i++) {
            snakeBody.add(new Rectangle(snakeBody.get(i-1).x-20,snakeBody.get(i-1).x,snakeWidth,snakeHeight));
            // snakeXPos.add(snakeBody.get(i).x);
            // snakeYPos.add(snakeBody.get(i).y);
        }
        this.panelSize = panelSize;
        this.pellet = pellet;
        this.snakeX = snakeX;
        this.snakeY = snakeY;
    };

    public void paint(Graphics2D snakeG2D) {
        snakeG2D.setColor(Color.GREEN);
        // snakeG2D.fillRect(snakeX,snakeY,snakeWidth,snakeHeight);
        for(Rectangle r: snakeBody) {
            snakeG2D.fillRect(r.x,r.y,snakeWidth,snakeHeight);
        }
        // snakeG2D.fillRect(snakeBody.get(0).x,snakeBody.get(0).y,snakeWidth,snakeHeight);
    }

    public void SnakeRight() {
        moveSnake();
        snakeX+=speed;
    }

    public void SnakeLeft() {
        moveSnake();
        snakeX-=speed;
    }

    public void SnakeUp() {
        moveSnake();
        snakeY-=speed;
    }

    public void SnakeDown() {
        moveSnake();
        snakeY+=speed;

    }

    private void moveSnake() {
        for (int i = snakeBody.size() - 1; i > 0; i--) {
            snakeBody.get(i).setLocation(snakeBody.get(i - 1).x, snakeBody.get(i - 1).y);
        }
        snakeBody.get(0).setLocation(snakeX, snakeY);
    }

public void checkBoundsEndless() {
    if(snakeBody.get(0).x<0+snakeWidth) {
        snakeX = panelSize.width;
    }
    if(snakeBody.get(0).x>=panelSize.width-snakeWidth) {
        snakeX =0;
    }
    if(snakeBody.get(0).y<0 + snakeHeight) {
        snakeY = panelSize.height;
    }
    if(snakeBody.get(0).y>=panelSize.height - snakeHeight) {
        snakeY = 0;
    }
}

public boolean endGame(){
    if(snakeBody.get(0).x<0 + snakeWidth || snakeBody.get(0).x>=panelSize.width - snakeWidth || snakeBody.get(0).y<0 + snakeHeight || snakeBody.get(0).y>=panelSize.height - snakeHeight){
        return true;
    }
    return false;
}

public void newSegment(){
    if(direction==0){
        snakeBody.add(new Rectangle(snakeBody.get(snakeBody.size()-1).x,snakeBody.get(snakeBody.size()-1).y+snakeHeight,snakeWidth,snakeHeight));
    }
    if(direction==1){
        snakeBody.add(new Rectangle(snakeBody.get(snakeBody.size()-1).x,snakeBody.get(snakeBody.size()-1).y-snakeHeight,snakeWidth,snakeHeight));
    }
    if(direction==2){
        snakeBody.add(new Rectangle(snakeBody.get(snakeBody.size()-1).x+snakeWidth,snakeBody.get(snakeBody.size()-1).y,snakeWidth,snakeHeight));
    }
    if(direction==3){
        snakeBody.add(new Rectangle(snakeBody.get(snakeBody.size()-1).x-snakeWidth,snakeBody.get(snakeBody.size()-1).y,snakeWidth,snakeHeight));
    }
}
}
