import javax.swing. *;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class SimplePhysics extends JPanel implements ActionListener, KeyListener {
    ArrayList<PhysicsObject> balls; // list of balls instead of one
    Timer timer;

    public SimplePhysics() {
        balls = new ArrayList<>();
        timer = new Timer(16, this); //60 FPS
        timer.start();

        addKeyListener(this); //listen for keystroke to spawn ball
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PhysicsObject ball : balls) {
            g.setColor(ball.randomColor); //Uses colour assigned at spawn
            g.fillOval((int) ball.x, (int) ball.y, ball.size, ball.size);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (PhysicsObject ball : balls) {
            ball.update();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) { //ablity to add new balss by pressing space
            balls.add(new PhysicsObject(50, 50));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
