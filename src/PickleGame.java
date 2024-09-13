import javax.swing.*;
import java.awt.*;

public class PickleGame extends JPanel {

    static final int WINDOW_WIDTH = 480, WINDOW_HEIGHT = 640;

    private Ball gameBall;

    public PickleGame() {
        Color ballColor = new Color(208, 223, 4);

        gameBall = new Ball(220, 320, 3, 3, 3, ballColor, 10);

    }
    
    public void paintComponent(Graphics g) {

        // background color
        Color courtColor = new Color(52, 84, 161);
        g.setColor(courtColor);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        gameBall.paint(g);

    }

}