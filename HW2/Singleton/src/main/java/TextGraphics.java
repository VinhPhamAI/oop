public class TextGraphics {
    private int width;
    private int height;
    private static TextGraphics instance;
    private char[][] buffer;
    private TextGraphics() {}
    public static TextGraphics getInstance()
    {
        if (instance == null) instance = new TextGraphics();
        return instance;
    }
    public void init(int width, int height)
    {
        this.width = width;
        this.height = height;
        buffer = new char[width][height];
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                buffer[i][j] = ' ';
            }
        }
    }
    public void drawPoint(char c, int x, int y)
    {
        buffer[x][y] = c;
    }
    public void drawLine(char c, int x1, int y1, int x2, int y2)
    {
        for (int i = x1 ; i < x2; i++)
        {
            if(y1 < y2) drawPoint(c, i, y1++);
        }
    }
    public void fillRect (char c, int x, int y, int width, int height)
    {
        for (int i = y; i < y + height; i++) {
            for (int j = x; j < x + width; j++) {
                drawPoint(c, j, i);
            }
        }
    }
    public void render() {
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                System.out.print(buffer[i][j]);
            }
            System.out.println();
        }
    }
}
