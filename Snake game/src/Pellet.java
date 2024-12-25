import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import java.awt.Graphics2D;

public class Pellet {
    public Color color = new Color(255, 255, 255);
    public int pelletX;
    public int pelletY;
    public int pelletWidth = 10;
    public int pelletHeight = 10;
    public int panelWidth;
    public int panelHeight;
    public boolean pelletEaten = true;

    public Pellet(Dimension panelSize) {
        this.panelWidth = panelSize.width;
        this.panelHeight = panelSize.height;
        pelletCoords();
    }

    public void pelletCoords() {
        Random rand = new Random();
            int gridSize = 25; // Assuming each grid box is 25x25 pixels
            this.pelletX = rand.nextInt(panelWidth / gridSize) * gridSize + gridSize / 2 - pelletWidth / 2;
            this.pelletY = rand.nextInt(panelHeight / gridSize) * gridSize + gridSize / 2 - pelletHeight / 2;
        pelletEaten = false; // removable (transfer) as score is added
    }

    public void paint(Graphics2D pelletG2D) {
        pelletG2D.setColor(color);
        pelletG2D.fillOval(pelletX, pelletY, pelletWidth, pelletHeight);
    }
}
