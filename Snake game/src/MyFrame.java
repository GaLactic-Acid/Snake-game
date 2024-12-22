import javax.swing.JFrame;
//import java.awt.Color;
// import java.awt.Graphics;
// import java.awt.Graphics2D;

import java.awt.Color;

public class MyFrame extends JFrame {
    MyPanel panel;
     MyFrame() {
        panel = new MyPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.add(panel);
        this.pack(); 
        this.setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Snake by Hrithik Singh");
    }
}