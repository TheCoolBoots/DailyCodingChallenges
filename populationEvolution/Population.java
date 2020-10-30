package populationEvolution;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Population {
    public Ball[] balls;

    public Population(int size){
        balls = new Ball[size];
        for (int i = 0; i < size; i++){
            balls[i] = new Ball();
        }
    } 

    public void update(){
        for (Ball b : balls){
            b.update();
        }
    }

    public void addToFrame(JFrame frame){
        for (Ball b : balls){
            frame.getContentPane().add(b, BorderLayout.CENTER);
        }
    }
}
