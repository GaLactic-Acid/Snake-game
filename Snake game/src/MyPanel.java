import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Dimension;
import javax.swing.Timer;
import java.awt.BasicStroke;

public class MyPanel extends JPanel implements KeyListener, ActionListener {
  int PANEL_WIDTH = 500;
  int PANEL_HEIGHT = 500;
  Pellet pellet;
  Snake snake;
  Timer timer;
  Dimension panelSize = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);

  MyPanel() {
    this.setPreferredSize(panelSize);
    this.setBackground(Color.BLACK);
    pellet = new Pellet(panelSize);
    snake = new Snake(PANEL_WIDTH/2, PANEL_HEIGHT/2, pellet, panelSize, true); // true = walls, false = no walls
    this.addKeyListener(this);
    this.setFocusable(true);
    this.requestFocusInWindow();

  timer = new Timer(100, new ActionListener(){
  @Override
  public void actionPerformed(ActionEvent e) { // 0 = up, 1 = down, 2 = left, 3 = right
      if (snake.direction == 0 && snake.pDirection == 1 || snake.direction == 1 && snake.pDirection!= 0) { // combine the bottom ones with the top by ||
          snake.SnakeDown();
          snake.pDirection = 1;
      } else if (snake.direction == 1 && snake.pDirection == 0 || snake.direction == 0 && snake.pDirection!= 1) {
          snake.SnakeUp();
          snake.pDirection = 0;
      } else if (snake.direction == 2 && snake.pDirection == 3 || snake.direction == 3 && snake.pDirection!= 2) {
          snake.SnakeRight();
          snake.pDirection = 3;
      } else if (snake.direction == 3 && snake.pDirection == 2 || snake.direction == 2 && snake.pDirection!= 3) {
          snake.SnakeLeft();
          snake.pDirection = 2;
      }
      checkCollision();
      if(snake.boundaries == false){
       snake.checkBoundsEndless(); // for endless boundaries
    }
      repaint();
    }
  });
  timer.start();
}

public void paintComponent(Graphics g) {
  super.paintComponent(g);
  Graphics2D snakeG2D = (Graphics2D) g;
  Graphics2D pelletG2D = (Graphics2D) g;
  Graphics2D grid = (Graphics2D) g;
  Graphics2D Score = (Graphics2D) g;
  Graphics2D gameOver = (Graphics2D) g;
  pellet.paint(pelletG2D);
  paintGrid(grid);
  snake.paint(snakeG2D);
  paintScore(Score);
  if(snake.endGame() == true){
  paintGameOver(gameOver);
  timer.stop(); // stops action listener which stops game from repainting
  snake.snakeBody.clear(); // stops snake from moving after game over (but is still displayed in final form due to timer.stop)
}
}

public void paintGrid(Graphics2D grid){ //grid
  grid.setColor(Color.GRAY);
  grid.setStroke(new BasicStroke(1)); //change grid line thickness
  for(int i=0; i<PANEL_WIDTH; i+=25){
    grid.drawLine(i, 0, i, PANEL_HEIGHT);
  }
  for(int i=0; i<PANEL_HEIGHT; i+=25){
    grid.drawLine(0, i, PANEL_WIDTH, i);
  }
}
public void paintGameOver(Graphics2D gameOver) {
  gameOver.setColor(Color.red);
  gameOver.setFont(gameOver.getFont().deriveFont(50f));
  String gameOverText = "GAME OVER";
  int gameOverWidth = gameOver.getFontMetrics().stringWidth(gameOverText);
  gameOver.drawString(gameOverText, (PANEL_WIDTH - gameOverWidth) / 2, PANEL_HEIGHT / 2);
  gameOver.setColor(Color.WHITE);
  gameOver.setFont(gameOver.getFont().deriveFont(20f));
  String finalScoreText = "Final Score: " + (snake.snakeBody.size() - 4);
  int finalScoreWidth = gameOver.getFontMetrics().stringWidth(finalScoreText);
  gameOver.drawString(finalScoreText, (PANEL_WIDTH - finalScoreWidth) / 2, PANEL_HEIGHT / 2 + 25);
}

public void paintScore(Graphics2D Score){
  Score.setColor(Color.WHITE);
  Score.setFont(Score.getFont().deriveFont(18f)); // Set font size to 18
  Score.drawString("Score: " + (snake.snakeBody.size()-4), 10, 20);
}

public void checkCollision(){ // check if snake head touches pellet then reset pellet coords and add new segment to snake 
  if(snake.snakeBody.get(0).intersects(pellet.pelletX, pellet.pelletY, pellet.pelletWidth, pellet.pelletHeight)){
    pellet.pelletCoords();
    snake.newSegment();
    }
}


@Override
public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
        snake.direction = 0;
        System.out.println("Snake moved up");
    } else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
        snake.direction = 1;
        System.out.println("Snake moved down");
    } else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
        snake.direction = 2;
        System.out.println("Snake moved left");
    } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
        snake.direction = 3;
        System.out.println("Snake moved right");
    }
      repaint();
}


@Override
public void actionPerformed(ActionEvent e) {
}
  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent e) {

    }
}
