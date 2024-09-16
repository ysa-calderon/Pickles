import java.awt.*;

public class Paddle {

    private int width, x, y, speed;
    private Color color;

    static final int PADDLE_HEIGHT = 15;

    public Paddle(int x, int y, int width, int speed, Color color) {
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.speed = speed;
        this.color = color;

    }

    public void paint(Graphics g) {

        g.setColor(color);
        g.fillRect(x, y, width, PADDLE_HEIGHT);

    }

    public void moveTowardsX(int moveToX) {

        // find the location of the center of the paddle
        int center = x + width / 2;

        if (Math.abs(center - moveToX) > speed) {

            if (center > moveToX) {
                x -= speed;
            }

            if (center < moveToX) {
                x += speed;
            }
        }

    }

    public void moveTowardsY(int moveToY) {

        // find the location of the center of the paddle
        int center = y + PADDLE_HEIGHT / 2;

        if (Math.abs(center - moveToY) > speed) {

            if (center > moveToY) {
                y -= speed;
            }

            if (center < moveToY) {
                y += speed;
            }
        }

    }

    // check if this paddle is colliding with the ball
    // @return true if colliding 
    public boolean checkCollision(Ball b) {
        
        int rightX = x + width;
        int bottomY = y + PADDLE_HEIGHT;

        if (b.getX() > x && b.getX() < rightX) {
            // ball is horizontally between the paddle
            if (b.getY() > (y - b.getSize()) && b.getY() < bottomY) {
                // ball is between top and bottom of paddle
                return true;
            }
        }

        // one of checks failed = ball has not collided
        return false;

    }
}