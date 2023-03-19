public class Circle {
    private Point center;
    private double radius;

    public Circle (Point center, double radius)
    {
        this.center = center;
        this.radius = radius;
    }
    public Point getCenter()
    {
        return center;
    }
    public double getRadius()
    {
        return radius;
    }
    public boolean intersects (Circle other)
    {
        double distance = center.distance(other.getCenter());
        return distance == radius + other.getRadius();
    }
    public boolean contains (Circle other)
    {
        double distance = center.distance(other.getCenter());
        return distance < radius;
    }
}
