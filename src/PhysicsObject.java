public class PhysicsObject {

    double x;
    double y;
    double vx;
    double vy;
    double gravity = 0.5;
    double bounce = 0.8;
    int size = 20;

    /**
     * CONSTRUCTOR
     *
     * @param x - x location
     * @param y - y location
     */
    public PhysicsObject(double x, double y) {
        this.x = x;
        this.y = y;
        this.vx = 2; //Initial velocity in x direction
        this.vy = 0; //Initial velocity in y direction
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
