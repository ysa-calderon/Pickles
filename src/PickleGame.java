import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class PickleGame extends JPanel implements MouseMotionListener{

    static final int WINDOW_WIDTH = 480, WINDOW_HEIGHT = 640;

    private Ball gameBall;

    private Paddle userPaddle, pcPaddle;
    
    private int userMouseX;
    private int userMouseY;

    public PickleGame() {
        Color ballColor = new Color(208, 223, 4);

        gameBall = new Ball(220, 320, 3, 3, 3, ballColor, 10);

        userPaddle = new Paddle(200, 610, 75, 3, Color.GREEN);
        pcPaddle = new Paddle(200, 10, 75, 3, Color.RED);

        userMouseX = 0;
        userMouseY = 0;
        addMouseMotionListener(this);
    }
    
    public void paintComponent(Graphics g) {

        // background color
        Color courtColor = new Color(52, 84, 161);
        g.setColor(courtColor);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        // make the ball
        gameBall.paint(g);

        // paint the paddles
        userPaddle.paint(g);
        pcPaddle.paint(g);

    }

    public void gameLogic() {

        gameBall.bounceOffEdges(0, WINDOW_WIDTH);
        gameBall.moveBall();

        userPaddle.moveTowardsX(userMouseX);
        userPaddle.moveTowardsY(userMouseY);

        pcPaddle.moveTowardsX(gameBall.getX());

        if (userPaddle.checkCollision(gameBall)){
            gameBall.reverseY();
        }
        if (pcPaddle.checkCollision(gameBall)){
            gameBall.reverseY();
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
        userMouseX = e.getX();
        userMouseY = e.getY();

    }

}