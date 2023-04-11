import java.awt.*;

public interface Graphic {
    void draw(Point position);

    Dimension getExtent();

    Point getPosition();

    void handleMouse(Event mouseEvent);

    void store();

    void load();

}
