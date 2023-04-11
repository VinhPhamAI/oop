import java.awt.*;

public class Picture implements Graphic{
    private final String filePath;
    private Dimension extent;
    public Picture(String file)
    {
        this.filePath = file;
        this.extent = getExtent();
    }
    @Override
    public void draw(Point position) {
        // code
    }

    @Override
    public Dimension getExtent() {
        return extent;
    }

    @Override
    public Point getPosition() {
        // code
        return null;
    }

    @Override
    public void handleMouse(Event mouseEvent) {
        // code
    }

    @Override
    public void store() {
        // code
    }

    @Override
    public void load() {
        // code
    }
}
