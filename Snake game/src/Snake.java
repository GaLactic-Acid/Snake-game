import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Snake {
    public boolean boundaries; // true = walls, false = no walls
    public int snakeX;
    public int snakeY;
    //public Pellet pellet;
    public int speed=25; // to change snake speed
    public int direction = 3; // 0 = up, 1 = down, 2 = left, 3 = right
    public int pDirection = 3; // previous direction
    int snakeWidth = 25;
    int snakeHeight = 25;
    Dimension panelSize;
    public ArrayList<Rectangle> snakeBody = new ArrayList<Rectangle>();
    public Snake(int snakeX, int snakeY, /*Pellet pellet,*/ Dimension panelSize, boolean boundaries) { //Pellet not needed as parameter
        snakeBody.add(new Rectangle(snakeX,snakeY,snakeWidth,snakeHeight));
        for(int i=1; i<4; i++) {
            snakeBody.add(new Rectangle(snakeBody.get(i-1).x-20,snakeBody.get(i-1).x,snakeWidth,snakeHeight));

        }
        this.boundaries = boundaries;
        this.panelSize = panelSize;
        //this.pellet = pellet;
        this.snakeX = snakeX;
        this.snakeY = snakeY;
    };

    public void paint(Graphics2D snakeG2D) {
        snakeG2D.setColor(Color.GREEN);
        for (Rectangle r : snakeBody) {
            snakeG2D.fillRect(r.x, r.y, snakeWidth, snakeHeight);
        }

        // Add eyes to the head of the snake
        Rectangle head = snakeBody.get(0); // The head is the first segment
        snakeG2D.setColor(Color.WHITE); // Set color for the eyes

        // Draw two small rectangles (eyes) on the head
        int eyeSize = 10;
        int eyeOffsetX = 0;
        int eyeOffsetY = 5;

        // Separate pupil offsets
        int pupilOffsetX = 0;
        int pupilOffsetY = -1;

        // Draw pupils
        int pupilSize = 4;

        if (direction == 0) { // Facing up
            snakeG2D.fillRect(head.x + eyeOffsetX, head.y + eyeOffsetY, eyeSize, eyeSize);
            snakeG2D.fillRect(head.x + snakeWidth - eyeOffsetX - eyeSize, head.y + eyeOffsetY, eyeSize, eyeSize);

            snakeG2D.setColor(Color.BLACK); // Pupils
            snakeG2D.fillRect(head.x + pupilOffsetX + (eyeSize - pupilSize) / 2, head.y + pupilOffsetY + (eyeSize - pupilSize) / 2, pupilSize, pupilSize);
            snakeG2D.fillRect(head.x + snakeWidth - eyeOffsetX - eyeSize + (eyeSize - pupilSize) / 2, head.y + pupilOffsetY + (eyeSize - pupilSize) / 2, pupilSize, pupilSize);
        } else if (direction == 1) { // Facing down
            snakeG2D.fillRect(head.x + eyeOffsetX, head.y + snakeHeight - eyeOffsetY - eyeSize, eyeSize, eyeSize);
            snakeG2D.fillRect(head.x + snakeWidth - eyeOffsetX - eyeSize, head.y + snakeHeight - eyeOffsetY - eyeSize, eyeSize, eyeSize);

            snakeG2D.setColor(Color.BLACK); // Pupils
            snakeG2D.fillRect(head.x + pupilOffsetX + (eyeSize - pupilSize) / 2, head.y + snakeHeight - pupilOffsetY - eyeSize + (eyeSize - pupilSize) / 2, pupilSize, pupilSize);
            snakeG2D.fillRect(head.x + snakeWidth - eyeOffsetX - eyeSize + (eyeSize - pupilSize) / 2, head.y + snakeHeight - pupilOffsetY - eyeSize + (eyeSize - pupilSize) / 2, pupilSize, pupilSize);
        } else if (direction == 2) { // Facing left
            snakeG2D.fillRect(head.x + eyeOffsetY, head.y + eyeOffsetX, eyeSize, eyeSize);
            snakeG2D.fillRect(head.x + eyeOffsetY, head.y + snakeHeight - eyeOffsetX - eyeSize, eyeSize, eyeSize);

            snakeG2D.setColor(Color.BLACK); // Pupils
            snakeG2D.fillRect(head.x + pupilOffsetY + (eyeSize - pupilSize) / 2, head.y + pupilOffsetX + (eyeSize - pupilSize) / 2, pupilSize, pupilSize);
            snakeG2D.fillRect(head.x + pupilOffsetY + (eyeSize - pupilSize) / 2, head.y + snakeHeight - eyeOffsetX - eyeSize + (eyeSize - pupilSize) / 2, pupilSize, pupilSize);
        } else if (direction == 3) { // Facing right
            snakeG2D.fillRect(head.x + snakeWidth - eyeOffsetY - eyeSize, head.y + eyeOffsetX, eyeSize, eyeSize);
            snakeG2D.fillRect(head.x + snakeWidth - eyeOffsetY - eyeSize, head.y + snakeHeight - eyeOffsetX - eyeSize, eyeSize, eyeSize);

            snakeG2D.setColor(Color.BLACK); // Pupils
            snakeG2D.fillRect(head.x + snakeWidth - pupilOffsetY - eyeSize + (eyeSize - pupilSize) / 2, head.y + pupilOffsetX + (eyeSize - pupilSize) / 2, pupilSize, pupilSize);
            snakeG2D.fillRect(head.x + snakeWidth - pupilOffsetY - eyeSize + (eyeSize - pupilSize) / 2, head.y + snakeHeight - pupilOffsetX - eyeSize + (eyeSize - pupilSize) / 2, pupilSize, pupilSize);
        }
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

public void checkBoundsEndless() { //not use in MyPanel by default (boundaries = false) in Mypanel Snake Object
    if(snakeBody.get(0).x<0-snakeWidth + 1) {
        snakeX = panelSize.width - snakeWidth;
    }
    if(snakeBody.get(0).x>panelSize.width - snakeWidth + 1) {
        snakeX = 0;
    }
    if(snakeBody.get(0).y<0 - snakeHeight + 1) {
        snakeY = panelSize.height - snakeHeight;
    }
    if(snakeBody.get(0).y>panelSize.height - snakeHeight + 1) {
        snakeY = 0;
    }
}

public boolean endGame(){
    // comment out this if statement if u want endless boundaries
    if(boundaries == true){
    if(snakeBody.get(0).x<0 - snakeWidth + 1 || snakeBody.get(0).x>=panelSize.width - snakeWidth + 1 || snakeBody.get(0).y<0 - snakeHeight + 1 || snakeBody.get(0).y>panelSize.height - snakeHeight + 1){
        return true;
    }
    } 
    if(snakeBody.size()>4){ // removes chances of snake dying at the start
        for(int i=4; i<snakeBody.size(); i++){
            if(snakeBody.get(0).x==snakeBody.get(i).x && snakeBody.get(0).y==snakeBody.get(i).y){
                return true;
            }
        }
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
