package populationEvolution;

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
        pop = new Population(20);
        frame = new JFrame("Evolution is Real!");
        frame.setBackground(Color.GRAY);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(pop, BorderLayout.CENTER);


        frame.setVisible(true);
        while (true) {
            update();
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