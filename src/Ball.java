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

    public void moveBall() {

        x += cx;
        y += cy;

    }

    public void bounceOffEdges(int left, int right) {

        if (x > right - size) {
            reverseX();
        }

        if (x < left) {
            reverseX();
        }

    }

    public void reverseY() {

        cy *= -1;

    }

    public void reverseX() {

        cx *= -1;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize(){
        return size;
    }
}