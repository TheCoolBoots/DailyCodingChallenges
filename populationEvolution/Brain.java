package populationEvolution;

import java.util.ArrayList;

public class Brain {
    public ArrayList<ArrayList<Double>> directions;
    private int size;

    public Brain(int size){
        this.directions = new ArrayList<ArrayList<Double>>(size);
        this.size = size;
        randomize();
    }

    private void randomize(){
        for (int i = 0; i < size; i++){
            ArrayList<Double> randomDirection = new ArrayList<Double>(2);
            double angle = Math.random() * 2 * Math.PI;
            randomDirection.add(Math.sin(angle));
            randomDirection.add(Math.cos(angle));
            directions.add(randomDirection);
        }
    }

    public Brain clone(){
        Brain newBrain = new Brain(size);
        newBrain.directions = (ArrayList<ArrayList<Double>>) directions.clone();
        return newBrain;
    }

    public void mutate(){
        for(int i = 0; i < directions.size(); i++){
            double rand = Math.random();
            if(rand < Constants.mutationRate){
                ArrayList<Double> randomDirection = new ArrayList<Double>(2);
                double angle = Math.random() * 2 * Math.PI;
                randomDirection.add(Math.sin(angle));
                randomDirection.add(Math.cos(angle));
                directions.set(i, randomDirection);
            }
        }
    }
}

