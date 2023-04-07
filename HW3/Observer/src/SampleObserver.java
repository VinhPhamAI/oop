import javax.swing.*;

public class SampleObserver {
    public static void main (String[] args)
    {
        JFrame frame = new JFrame();
        JButton button = new JButton("click click");
        frame.getContentPane().add(button);
        frame.setSize(500,500);
        frame.setVisible(true);

    }
}
