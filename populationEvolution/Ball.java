package populationEvolution;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Ball extends JPanel {

    public final int brainSize = 1000; 
    public final double maxSpeed = 3.0;
    public final int maxEdge = 800;
    public final int minEdge = 0;

    public final int x = 0;
    public final int y = 1;

    private static final long serialVersionUID = 7507425470242757620L;
    int[] position;
    double[] velocity;
    double[] acceleration;
    int radius = 3;
    Brain brain;
    int step = 0;
    boolean dead = false;


    public Ball(){
        this.brain = new Brain(brainSize);
        this.position = new int[2];
        this.position[x] = 800 / 2;
        this.position[y] = 800 / 2;
        this.velocity = new double[2];
        this.velocity[x] = 0.0;
        this.velocity[y] = 0.0;
        this.acceleration = new double[2];
        this.acceleration[x] = 0.0;
        this.acceleration[y] = 0.0;
        this.setBackground(new Color(0, 0, 0, 0));
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillOval(this.position[x] - radius, this.position[y]- radius, radius*2, radius*2);
    }

    public void move(){
        if(!dead){
            if(this.step > brain.directions.size() - 1){
                step = 0;
            }

            acceleration[x] = brain.directions.get(step).get(0);
            acceleration[y] = brain.directions.get(step).get(1);

            velocity[x] += acceleration[x];
            velocity[y] += acceleration[y];

            if(Math.abs(velocity[x]) > maxSpeed){
                if(velocity[x] < 0)
                    velocity[x] = -maxSpeed;
                else
                    velocity[x] = maxSpeed;
            }

            if(Math.abs(velocity[y]) > maxSpeed){
                if(velocity[y] < 0)
                    velocity[y] = -maxSpeed;
                else
                    velocity[y] = maxSpeed;
            }
            
            position[x] += (int) velocity[x];
            position[y] += (int) velocity[y];
            this.step += 1;
        }
    }

    public void update(){
        this.move();
        if(this.position[x] > maxEdge || this.position[x] < minEdge || this.position[y] > maxEdge || this.position[y] < minEdge){
            this.dead = true;
        }
    }

}