import java.awt.*;

public class PictureProxy implements Graphic{
    private String fileName;
    private Dimension extent;
    private Point position;
    private Picture picture;
    public PictureProxy(String file, Dimension extent)
    {
        this.fileName = file;
    }
    @Override
    public void draw(Point position) {
        getPicture().draw(position);
    }

    @Override
    public Dimension getExtent() {
        return getPicture().getExtent();
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void handleMouse(Event mouseEvent) {
        getPicture().handleMouse(mouseEvent);
    }

    @Override
    public void store() {
        getPicture().store();
    }

    @Override
    public void load() {
        getPicture().load();
    }
    private Picture getPicture()
    {
        if (picture == null) {
            picture = new Picture(fileName);
        }
        return picture;
    }
}
