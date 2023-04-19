public class Main {
    public static void main(String[] args) {
        TextGraphics graphics = TextGraphics.getInstance();
        graphics.init(15, 10);
        graphics.drawPoint('*', 1, 1);
        graphics.fillRect('o', 5, 5, 3, 2);
        graphics.render();
    }
}
