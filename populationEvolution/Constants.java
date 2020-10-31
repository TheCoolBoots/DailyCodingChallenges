package populationEvolution;

public class Constants {
    public static final int x = 0;
    public static final int y = 1;

    public static int brainSize = 1000;     // the number of predetermined moves each ball will make
    public static double maxSpeed = 3.0;    // the maximum distance traveled at each update
    public static int maxEdge = 800;        // the length of one side of the starting grid
    public static int minEdge = 0;

    public static int goalX = 400;          // position of the goal box
    public static int goalY = 100;
    
    public static int popSize = 100;        // how many balls will be in each population

    public static double mutationRate = .03;    
            // percentage of the child's predetermined moves that will be overwritten with a new, random move
}
