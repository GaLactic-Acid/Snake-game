import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import java.awt.Graphics2D;
public class Pellet{
    public Color color = new Color(255, 255, 255);
    public int pelletX;
    public int pelletY;
    public int panelWidth;
    public int panelHeight;
    public Pellet(Dimension panelSize) {
        this.panelWidth = panelSize.width;
        this.panelHeight = panelSize.height;
        pelletCoords();
        }
        public void pelletCoords() {
            Random rand = new Random();
            this.pelletX = rand.nextInt(panelWidth);
            this.pelletY = rand.nextInt(panelHeight);
        }

        public void paint(Graphics2D pelletG2D){
            pelletG2D.setColor(color);
            pelletG2D.fillOval(pelletX, pelletY, 10, 10);
        }  
}
