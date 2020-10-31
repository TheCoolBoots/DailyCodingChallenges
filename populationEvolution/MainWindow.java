package populationEvolution;

import populationEvolution.Constants;
import java.awt.Color;
import java.util.Vector;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JFrame;

class MainWindow extends JPanel {

    private static final long serialVersionUID = 1L;
    private Vector<Ball> balls;
    static JFrame frame;
    static Population pop;

    public static void main(String[] args) {
        pop = new Population(Constants.popSize);
        frame = new JFrame("Evolution is Real!");
        frame.setBackground(Color.GRAY);
        frame.setSize(Constants.maxEdge, Constants.maxEdge);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(pop, BorderLayout.CENTER);


        frame.setVisible(true);
        while (true) {
            int counter = 0;
            while(true){
                if(counter > 10){
                    if(pop.allBallsDead())
                        break;
                    counter = 0;
                }
                update();
                counter++;
            }

            // perform natural selection & mutate babies
            pop.naturalSelection();

        }
    }

    private static void update() {
        pop.update();
        frame.repaint();
        try {
            Thread.sleep(4, 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}