import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ball extends JPanel {
    private Graphics g;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int radius ;


    public Ball(int x, int y, int dx, int dy, int radius)
    {
        this.dx = dx;
        this.dy = dy;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    List<Observer> observers = new ArrayList<>();
    public void intersect(Observer other){
        observers.add(other);
    }
    public void unIntersect(Observer other){
        observers.remove(other);
    }
    public void notification(){
        for(Observer ob : observers){
            ob.notifies();
        }
    }
    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, radius, radius);
    }
    public void ball_move(int wid, int hei)
    {
        if(CanMove.move)
        {
            x += dx;
            y += dy;
        }
        if((x > hei - radius || x <= 0) && (y < hei && y > 0))
        {
            dx *= -1;
            notification();
        }
        if(( x < wid && x > 0 ) && ( y > wid - 2 * radius || y <= 0))
        {
            dy *= -1;
            notification();
        }
        repaint();
    }
}
