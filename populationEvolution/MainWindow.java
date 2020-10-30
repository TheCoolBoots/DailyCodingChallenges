package populationEvolution;

import java.awt.Color;
import java.util.Vector;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JFrame;

class test extends JPanel {

    private Vector<Ball> balls;
    static Ball myBall0;
    static Ball myBall1;
    static JFrame frame;
    // static Population pop;

    public static void main(String[] args) {
        // pop = new Population(20);
        myBall0 = new Ball();
        myBall1 = new Ball();
        frame = new JFrame("Evolution is Real!");
        frame.setBackground(Color.GRAY);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(myBall0, BorderLayout.CENTER);
        frame.getContentPane().add(myBall1, BorderLayout.CENTER);

        // pop.addToFrame(frame);
        frame.setVisible(true);
        while (true) {
            update();
        }
    }

    private static void update() {
        // pop.update();
        myBall0.update();
        myBall1.update();
        frame.repaint();
        try {
            Thread.sleep(4, 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}