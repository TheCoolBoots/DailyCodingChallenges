package populationEvolution;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Population extends JPanel {

    private static final long serialVersionUID = 2243349449279225107L;
    public Ball[] balls;

    public final int x = 0;
    public final int y = 1;

    public Population(int size){
        balls = new Ball[size];
        for (int i = 0; i < size; i++){
            balls[i] = new Ball();
        }
        this.setBackground(new Color(0, 0, 0, 0));
    } 

    public void update(){
        for (Ball b : balls){
            b.update();
        }
    }


    public void paintComponent(Graphics g){
        for (Ball b : balls){
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillOval(b.position[x] - b.radius, b.position[y]- b.radius, b.radius*2, b.radius*2);
        }
    }
}
