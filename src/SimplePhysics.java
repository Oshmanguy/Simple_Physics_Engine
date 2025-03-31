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
            for (int i = 0; i < balls.size(); i++) {
                for (int j = i + 1; j < balls.size(); j++) {
                    PhysicsObject ball1 = balls.get(i);
                    PhysicsObject ball2 = balls.get(j);

                    //Detect collision
                    if (ball1.isColliding(ball2)) {
                        //Handle the collisions (change velocities based on momentum)
                        ball1.handleCollision(ball2);
                    }
                }
            }
            ball.update();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) { // Ability to add new balls by pressing space
            // Create a new ball with random initial velocities
            double randomVx = Math.random() * 4 - 2; // Random horizontal velocity between -2 and 2
            double randomVy = Math.random() * 2;     // Random vertical velocity between 0 and 2
            //double randomMass = Math.random() * 40;
            //TODO: coralate size to mass
            balls.add(new PhysicsObject(50, 50, randomVx, randomVy));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
