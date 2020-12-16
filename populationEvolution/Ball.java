package populationEvolution;
import populationEvolution.Constants;

public class Ball{

    private static final long serialVersionUID = 7507425470242757620L;
    int[] position;
    double[] velocity;
    double[] acceleration;
    int radius = 3;
    Brain brain;
    int step = 0;
    boolean dead = false;
    double fitness;
    boolean hitGoal = false;


    public Ball(){
        this.brain = new Brain(Constants.brainSize);
        this.position = new int[2];
        this.position[Constants.x] = 400;
        this.position[Constants.y] = 750;
        this.velocity = new double[2];
        this.velocity[Constants.x] = 0.0;
        this.velocity[Constants.y] = 0.0;
        this.acceleration = new double[2];
        this.acceleration[Constants.x] = 0.0;
        this.acceleration[Constants.y] = 0.0;
        
    }

    public void move(){
        if(!dead){

            acceleration[Constants.x] = brain.directions.get(step % Constants.brainSize).get(0);
            acceleration[Constants.y] = brain.directions.get(step % Constants.brainSize).get(1);

            velocity[Constants.x] += acceleration[Constants.x];
            velocity[Constants.y] += acceleration[Constants.y];

            if(Math.abs(velocity[Constants.x]) > Constants.maxSpeed){
                if(velocity[Constants.x] < 0)
                    velocity[Constants.x] = -Constants.maxSpeed;
                else
                    velocity[Constants.x] = Constants.maxSpeed;
            }

            if(Math.abs(velocity[Constants.y]) > Constants.maxSpeed){
                if(velocity[Constants.y] < 0)
                    velocity[Constants.y] = -Constants.maxSpeed;
                else
                    velocity[Constants.y] = Constants.maxSpeed;
            }
            
            position[Constants.x] += (int) velocity[Constants.x];
            position[Constants.y] += (int) velocity[Constants.y];
            this.step += 1;
        }
    }

    public void update(){
        this.move();
        if(this.position[Constants.x] > Constants.maxEdge || this.position[Constants.x] < Constants.minEdge || 
                this.position[Constants.y] > Constants.maxEdge || this.position[Constants.y] < Constants.minEdge || 
                hitGoal() || step >= Constants.brainSize){
            this.dead = true;
        }
    }

    public boolean hitGoal(){
        if(Math.abs(this.position[Constants.x] - Constants.goalX) <= 5 &&
            Math.abs(this.position[Constants.y] - Constants.goalY) <= 5){
                this.hitGoal = true;
                return true; 
        }
        return false;
    }

    public void calculateFitness(){
        if(this.hitGoal){
            this.fitness = 1.0/(step + step);
        } else {
            double distanceToGoal = Math.sqrt(Math.pow(this.position[Constants.x] - Constants.goalX, 2)
                    + Math.pow(this.position[Constants.y] - Constants.goalY, 2));
            System.out.println(distanceToGoal);
            this.fitness = 1.0/(distanceToGoal * distanceToGoal * (step + step));
        }
    }

    public Ball getBaby(){
        Brain newBrain = brain.clone();
        Ball newBall = new Ball();
        newBall.brain = newBrain;
        return newBall;
    }

}