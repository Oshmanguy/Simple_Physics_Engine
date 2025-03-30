import java.awt.*;
import java.util.Random;

public class PhysicsObject {

    double x;
    double y;
    double vx; //change in x direction (velocity)
    double vy; //change in y direction (velocity)
    double mass;
    int size; //come back to assign default size later
    Color randomColor;

    /**
     * CONSTRUCTOR
     *
     * @param x - x location
     * @param y - y location
     */
    public PhysicsObject(double x, double y, double vx, double vy, double mass) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.mass = mass;

        //Random Color and size
        Random rando = new Random();
        this.randomColor = new Color(rando.nextInt(255), rando.nextInt(255), rando.nextInt(255));
        this.size = rando.nextInt(50);
        //TODO: RANDOM MASS HERE MAKE IT THE SAME AS SIZE???
    }

    public boolean isColliding(PhysicsObject other) {
        double dx = other.x - this.x; //change in vertical distance
        double dy = other.y - this.y; //change in horizontal distance
        double distance = Math.sqrt(dx * dx + dy * dy); //calculate distance

        return distance < (this.size / 2 + other.size / 2); //checks to see if the center of the balls are touching or not, if true there is overlap
    }

    public void handleCollision(PhysicsObject other) {
        double v1Initial = this.vx;
        double v2Initial = other.vx;
        double m1 = this.mass;
        double m2 = other.mass;

        // Apply the 1D elastic collision formula for both objects
        this.vx = ((m1 - m2) * v1Initial + 2 * m2 * v2Initial) / (m1 + m2);
        other.vx = ((m2 - m1) * v2Initial + 2 * m1 * v1Initial) / (m1 + m2);
    }

    public void update() {
        // Update position based on velocity
        x += vx;
        y += vy;

        // Optionally handle boundaries (like screen edges or ground)
        // Bounce off the walls if the ball goes off the screen horizontally (x-axis)
        if (x < 0 || x > 500 - size) {  // Assuming a screen width of 500
            vx = -vx;  // Reflect the velocity on the x-axis
        }

        // Bounce off the ground if the ball reaches the bottom (y-axis)
        if (y < 0 || y > 400 - size) {  // Assuming a screen height of 400
            vy = -vy;  // Reflect the velocity on the y-axis
        }
    }
}
