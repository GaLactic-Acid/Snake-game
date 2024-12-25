import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Snake {

    public int snakeX;
    public int snakeY;
    public Pellet pellet;
    public int speed=4; // to change snake speed
    public int direction = 3; // 0 = up, 1 = down, 2 = left, 3 = right
    int snakeWidth = 20;
    int snakeHeight = 20;
    Dimension panelSize;
    public ArrayList<Rectangle> snakeBody = new ArrayList<Rectangle>();
    public ArrayList<Integer> snakeXPos = new ArrayList<Integer>();
    public ArrayList<Integer> snakeYPos = new ArrayList<Integer>();

    // add position of snake tail as attribute
    public Snake(int snakeX, int snakeY, Pellet pellet, Dimension panelSize) {
        snakeBody.add(new Rectangle(snakeX,snakeY,snakeWidth,snakeHeight));
        snakeXPos.add(snakeBody.get(0).x);
        snakeYPos.add(snakeBody.get(0).y);
        for(int i=1; i<4; i++) {
            snakeBody.add(new Rectangle(snakeXPos.get(i-1)-20,snakeYPos.get(i-1),snakeWidth,snakeHeight));
            snakeXPos.add(snakeBody.get(i).x);
            snakeYPos.add(snakeBody.get(i).y);
        }
        this.panelSize = panelSize;
        this.pellet = pellet;
        this.snakeX = snakeX;
        this.snakeY = snakeY;
    };

    public void paint(Graphics2D snakeG2D) {
        snakeG2D.setColor(Color.white);
        // snakeG2D.fillRect(snakeX,snakeY,snakeWidth,snakeHeight);
        for(Rectangle r: snakeBody) {
            snakeG2D.fillRect(r.x,r.y,snakeWidth,snakeHeight);
        }
        // snakeG2D.fillRect(snakeBody.get(0).x,snakeBody.get(0).y,snakeWidth,snakeHeight);
    }

    public void SnakeRight() {
        snakeBody.get(0).x+=speed;
        for (int i = 1; i < snakeBody.size(); i++) {
            if(snakeBody.get(i-1).x>0){
            snakeBody.get(i).x = snakeBody.get(i-1).x-snakeWidth;
            snakeBody.get(i).y = snakeBody.get(i-1).y;
            }
            else {
                snakeBody.get(i).x+=speed;
            }
        }
        // this.snakeX+=speed;
    }

    public void SnakeLeft() {
        snakeBody.get(0).x-=speed;
        for (int i = 1; i < snakeBody.size(); i++) {
            if(snakeBody.get(i-1).x<panelSize.width-snakeWidth){
            snakeBody.get(i).x = snakeBody.get(i-1).x+snakeWidth;
            snakeBody.get(i).y = snakeBody.get(i-1).y;
            }
            else {
                snakeBody.get(i).x-=speed;
            }
        }
        // this.snakeX-=speed;
    }

    public void SnakeUp() {
        snakeBody.get(0).y-=speed;
        for (int i = 1; i < snakeBody.size(); i++) {
            if(snakeBody.get(i-1).y<panelSize.height-snakeHeight){
            snakeBody.get(i).y = snakeBody.get(i-1).y+20;
            snakeBody.get(i).x = snakeBody.get(i-1).x;
            }
            else {
                snakeBody.get(i).y-=speed;
            }
        }
        // this.snakeY-=speed;
    }

    public void SnakeDown() {
        snakeBody.get(0).y+=speed;
        for (int i = 1; i < snakeBody.size(); i++) {
            if(snakeBody.get(i-1).y>snakeHeight){
            snakeBody.get(i).y = snakeBody.get(i-1).y-20;
            snakeBody.get(i).x = snakeBody.get(i-1).x;
        }
            else{
                snakeBody.get(i).y+=speed;
            }
        }
        // this.snakeY+=speed;
    }
public void checkBounds() {
    if(snakeBody.get(0).x<0-snakeWidth) {
        snakeBody.get(0).x = panelSize.width;
    }
    if(snakeBody.get(0).x>panelSize.width+snakeWidth) {
        snakeBody.get(0).x =0;
    }
    if(snakeBody.get(0).y<0-snakeHeight) {
        snakeBody.get(0).y = panelSize.height;
    }
    if(snakeBody.get(0).y>panelSize.height) {
        snakeBody.get(0).y = 0;
    }

    // if(snakeX<0-snakeWidth) {
    //     snakeX = panelSize.width;
    // }
    // if(snakeX>panelSize.width) {
    //     snakeX = 0;
    // }
    // if(snakeY<0-snakeHeight) {
    //     snakeY = panelSize.height;
    // }
    // if(snakeY>panelSize.height) {
    //     snakeY = 0;
    // }
}
}
