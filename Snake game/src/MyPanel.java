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

public class MyPanel extends JPanel implements KeyListener, ActionListener {
  int PANEL_WIDTH = 600;
  int PANEL_HEIGHT = 600;
  Pellet pellet;
  Snake snake;
  Timer timer;
  Dimension panelSize = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);

  MyPanel() {
    this.setPreferredSize(panelSize);
    this.setBackground(Color.BLACK);
    pellet = new Pellet(panelSize);
    snake = new Snake(PANEL_WIDTH/2, PANEL_HEIGHT/2, pellet, panelSize);
    this.addKeyListener(this);
    this.setFocusable(true);
    this.requestFocusInWindow();

  timer = new Timer(10, new ActionListener(){
  @Override
  public void actionPerformed(ActionEvent e) {
      if (snake.direction == 0) {
          snake.SnakeUp();
      } else if (snake.direction == 1) {
          snake.SnakeDown();
      } else if (snake.direction == 2) {
          snake.SnakeLeft();
      } else if (snake.direction == 3) {
          snake.SnakeRight();
      }
      snake.checkBounds();
      repaint();
    }
  });
  timer.start();
}

public void paintComponent(Graphics g) {
  super.paintComponent(g);
  Graphics2D snakeG2D = (Graphics2D) g;
  Graphics2D pelletG2D = (Graphics2D) g;
  pellet.paint(pelletG2D);
  snake.paint(snakeG2D);
}

@Override
public void actionPerformed(ActionEvent e) {
  // TODO Auto-generated method stub
}

@Override
public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_W) {
        snake.direction = 0;
        System.out.println("Snake moved up");
    } else if (e.getKeyCode() == KeyEvent.VK_S) {
        snake.direction = 1;
        System.out.println("Snake moved down");
    } else if (e.getKeyCode() == KeyEvent.VK_A) {
        snake.direction = 2;
        System.out.println("Snake moved left");
    } else if (e.getKeyCode() == KeyEvent.VK_D) {
        snake.direction = 3;
        System.out.println("Snake moved right");
    }
      repaint();
}
  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub
  }
}
