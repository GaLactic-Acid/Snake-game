import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
public class MyPanel extends JPanel{
  int PANEL_WIDTH = 800;
  int PANEL_HEIGHT = 800;
  Pellet pellet;
  MyPanel() {
    this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
    this.setBackground(Color.BLACK);
    pellet = new Pellet(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    public void paintComponent(Graphics g) {
      //super.paintComponent(g);
      Graphics2D pelletG2D = (Graphics2D) g;
      pellet.paint(pelletG2D);
      pellet.pelletCoords();
  }
}
