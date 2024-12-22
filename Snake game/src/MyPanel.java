import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;

public class MyPanel extends JPanel implements MouseListener {
  int PANEL_WIDTH = 800;
  int PANEL_HEIGHT = 800;
  Pellet pellet;

  MyPanel() {
    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    this.setBackground(Color.BLACK);
    pellet = new Pellet(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    this.addMouseListener(this);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D pelletG2D = (Graphics2D) g;
    pellet.paint(pelletG2D);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // pellet.pelletEaten = true;
    // pellet.pelletCoords();
    // repaint();
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
  }
}
