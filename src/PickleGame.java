import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class PickleGame extends JPanel implements MouseMotionListener{

    static final int WINDOW_WIDTH = 480, WINDOW_HEIGHT = 640;

    private Ball gameBall;

    private Paddle userPaddle, pcPaddle;

    private int userMouseX, userMouseY, userScore, pcScore, bounceCount;
    private Color ballColor = new Color(208, 223, 4);

    public PickleGame() {

        gameBall = new Ball(220, 320, 3, 3, 3, ballColor, 10);

        userPaddle = new Paddle(200, 610, 75, 3, Color.GREEN);
        pcPaddle = new Paddle(200, 10, 75, 3, Color.RED);
        bounceCount = 0;

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

        // update the score
        g.setColor(Color.WHITE);
        g.drawString("SCORE - User [" + userScore + "]  PC [" +  pcScore + "]", 170, 340);

    }

    public void gameLogic() {

        gameBall.bounceOffEdges(0, WINDOW_WIDTH);
        gameBall.moveBall();

        userPaddle.moveTowardsX(userMouseX);
        userPaddle.moveTowardsY(userMouseY);

        pcPaddle.moveTowardsX(gameBall.getX());

        if (userPaddle.checkCollision(gameBall)){
            gameBall.reverseY();
            bounceCount++;
        }
        if (pcPaddle.checkCollision(gameBall)){
            gameBall.reverseY();
            bounceCount++;
        }

        if (bounceCount == 3) {
            bounceCount = 0;
            gameBall.increaseSpeed();
        }

        if (gameBall.getY() < 0){
            userScore++;
            reset();
        }
        else if (gameBall.getY() > WINDOW_HEIGHT){
            pcScore++;
            reset();
        }

    }

    public void reset(){

        gameBall = new Ball(220, 320, 3, 3, 3, ballColor, 10);
        userPaddle = new Paddle(200, 610, 75, 3, Color.GREEN);
        pcPaddle = new Paddle(200, 10, 75, 3, Color.RED);
        bounceCount = 0;

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