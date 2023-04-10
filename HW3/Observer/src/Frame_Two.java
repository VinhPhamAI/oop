import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame_Two extends Observer {
    private JFrame secondFrame;
    private JButton startAndStopButton;
    private JLabel label;
    private int countNumberOfBounce = 0;
    public JFrame getSecondFrame()
    {
        return secondFrame;
    }
    public Frame_Two()
    {
        secondFrame = new JFrame("Observer");
        secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startAndStopButton = new JButton("start");
        startAndStopButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(CanMove.move)
                {
                    CanMove.move = false;
                    startAndStopButton.setText("Start");
                }
                else
                {
                    CanMove.move = true;
                    startAndStopButton.setText("Stop");
                }
            }
        });
        label = new JLabel("Bounce count : 0");
        secondFrame.getContentPane().add(BorderLayout.SOUTH,startAndStopButton);
        secondFrame.getContentPane().add(BorderLayout.NORTH,label);
        secondFrame.setSize(500,100);
        secondFrame.setLocation(0,500);
        secondFrame.setVisible(true);
    }
    @Override
    public void notifies()
    {
        countNumberOfBounce++;
        label.setText("Bounce count: " + countNumberOfBounce);
    }

}
