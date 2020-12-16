package populationEvolution;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Population extends JPanel {

    private static final long serialVersionUID = 2243349449279225107L;
    public Ball[] balls;

    private double fitnessSum = 0;

    int generation = 0;

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
        g.setColor(Color.GREEN);
        g.fillOval(400-6, 100-6, 12, 12);
        for (Ball b : balls){
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillOval(b.position[Constants.x] - b.radius, b.position[Constants.y]- b.radius, b.radius*2, b.radius*2);
        }
    }

    public void calculateFitness(){
        for(Ball b : balls){
            b.calculateFitness();
        }
    }

    public boolean allBallsDead(){
        for(Ball b : balls){
            if(!b.dead){
                return false;
            }
        }
        return true;

    }

    public void naturalSelection(){
        this.calculateFitness();
        this.calculateFitnessSum();
        Ball[] newBalls = new Ball[balls.length];

        for(int i = 1; i < balls.length; i++){
            Ball parent = selectParent();
            newBalls[i] = parent.getBaby();
        }
        newBalls[0] = getBestBall();

        balls = newBalls;
        generation++;

        for(Ball b : balls){
            b.brain.mutate();
        }
    }

    public void calculateFitnessSum(){
        double sum = 0;
        for (Ball b : balls){
            sum += b.fitness;
        }
        this.fitnessSum = sum;
    }

    public Ball selectParent(){
        double rand = Math.random() * this.fitnessSum;
        double runningSum = 0;

        for(Ball b : balls){
            runningSum += b.fitness;
            if(runningSum > rand){
                return b;
            }
        }

        System.out.println("ERROR parent not selected");
        return null;
    }

    public Ball getBestBall(){
        int bestIndex = 0;
        double bestFitness = 0;
        for(int i = 0; i < balls.length; i++){
            if(balls[i].fitness > bestFitness){
                bestIndex = i;
                bestFitness = balls[i].fitness;
            }
        }
        return balls[bestIndex].getBaby();
    }
}
