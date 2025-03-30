public class PhysicsObject {

    double x;
    double y;
    double vx;
    double vy;
    double gravity = 0.5;
    double bounce = 0.8;
    int size = 20;

    public PhysicsObject(double x, double y) {
        this.x = x;
        this.y = y;
        this.vx = 2;
        this.vy = 0;
    }
}
