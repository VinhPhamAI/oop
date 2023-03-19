import java.util.*;

public class Shape {
    private Vector<Point> points = new Vector<>();
    private Circle circle;

    public Shape (String input) {
        String[] str = input.split("\\s+");
        this.points = new Vector<Point>();
        for(int i=0;i<str.length-1;i+=2){
            double x = Double.parseDouble(str[i]);
            double y = Double.parseDouble(str[i+1]);
            Point temp = new Point(x,y);
            points.add(temp);
        }
        calculateCircle(); // added call to calculateCircle() method
    }

    public Vector<Point> getPoints() {
        return points;
    }



    private void calculateCircle()
    {
        double center_X = 0;
        double center_Y = 0;
        int n = points.size();
        for (Point vertex : points)
        {
            center_X += vertex.getX()/n;
            center_Y += vertex.getY()/n;
        }
        double Min_distance = 10000;
        for (Point vertex : points)
        {
            double dis_point = Math.pow(vertex.getX()-center_X,2) + Math.pow(vertex.getY()-center_Y,2);
            if(dis_point < Min_distance) Min_distance = dis_point;
        }
        circle = new Circle(new Point(center_X,center_Y),Math.sqrt(Min_distance));
    }
    public Circle getCircle() {
        return circle;
    }
    public boolean is_cross (Shape a, Shape b)
    {
        double distance1;
        double distance2;
        Vector<Point> pointA = a.getPoints();
        Circle B = b.circle;
        Point heartB = B.getCenter();
        double radiusB = B.getRadius();
        for(int i=0;i<pointA.size()-1;i++){
            distance1 = heartB.distance(pointA.get(i));
            distance2 = heartB.distance(pointA.get(i+1));
            if(( (distance1 < radiusB) && (distance2 > radiusB) ) || ( (distance1 > radiusB) && (distance2 < radiusB) )){
                return true;
            }
        }
        return false;
    }

    public int encircle (Shape other)
    {
        Circle other_Circle = other.circle;
        double distance = circle.getCenter().distance(other_Circle.getCenter());
        if(circle.intersects_inside(other_Circle) || circle.intersects_outside(other_Circle))
        {
            return 1;
        }
        else if (circle.contains(other_Circle))
        {
            return 2;
        }
        else {
            return 0;
        }
    }
}
