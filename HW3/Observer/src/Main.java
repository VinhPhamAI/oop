
public class Main {

    public static void main (String[] args) {
        Frame_One frameOne = new Frame_One(500, 500);
        Frame_Two frameTwo = new Frame_Two();
        frameOne.getBall().intersect(frameTwo);
        frameOne.go();
    }

}
