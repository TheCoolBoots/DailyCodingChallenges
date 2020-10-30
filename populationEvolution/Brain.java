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

    // public static void main(String[] args){
    //     Brain b = new Brain(10);
    //     System.out.println(b.directions);
    // }
}

