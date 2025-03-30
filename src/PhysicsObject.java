import java.awt.*;
import java.util.Random;

public class PhysicsObject {

    double x;
    double y;
    double vx;
    double vy;
    double gravity = 0.5;
    double bounce = 0.8;
    int size; //come back to assign default size later
    Color randomColor;

    /**
     * CONSTRUCTOR
     *
     * @param x - x location
     * @param y - y location
     */
    public PhysicsObject(double x, double y) {
        this.x = x;
        this.y = y;
        this.vx = Math.abs(Math.random() * 4 - 2); //Initial velocity in x direction
        this.vy = Math.random() * 2; //Initial velocity in y direction

        //Random Color and size
        Random rando = new Random();
        this.randomColor = new Color(rando.nextInt(255), rando.nextInt(255), rando.nextInt(255));
        this.size = rando.nextInt(50);
    }

    public void update() {
        vy = vy + gravity; //Applying gravity
        x = x + vx;
        y = y + vy;

        if (y + size > 400) { //Collision with ground
            y = 400 - size;
            vy = vy * -bounce; //Bounce effect
        }
    }
}
