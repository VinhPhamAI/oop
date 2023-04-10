import javax.swing.*;
import java.awt.*;
public class Frame_One extends JFrame {

    private JFrame firstFrame;
    private Ball ball;
    private int width;
    private int height;

    public Frame_One(int width, int height)
    {
        firstFrame = new JFrame();
        ball = new Ball(100, 100, 2, 2, 20);
        this.width = width;
        this.height = height;
        firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        firstFrame.setSize(width, height);
        firstFrame.setLocation(0,0);
        firstFrame.add(ball);
        firstFrame.setVisible(true);
    }
    public Ball getBall()
    {
        return ball;
    }
    public void moveBall()
    {
        ball.ball_move(width, height);
    }
    public void go()
    {
        while(true)
        {
            ball.ball_move(width,height);
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException exe)
            {
                exe.printStackTrace();
            }
        }
    }


}
