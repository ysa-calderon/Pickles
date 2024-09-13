import java.awt.*;

public class Ball {

    private int x, y, cx, cy, speed, size;
    private Color color;

    public Ball(int x, int y, int cx, int cy, int speed, Color color, int size) {

        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.color = color;
        this.size = size;

    }

    public void paint(Graphics g) {

        g.setColor(color);
        g.fillOval(x, y, size, size);

    }
}