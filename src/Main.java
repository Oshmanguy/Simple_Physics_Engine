import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Physics Engine");
        SimplePhysics physics = new SimplePhysics();
        frame.add(physics);
        frame.setSize(500, 430);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        physics.requestFocusInWindow();//Ensures key clicks are focused to this window only
    }
}
