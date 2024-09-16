import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Main{

    static JFrame f = new JFrame("Pickle");
    
    public static void main(String[] args) {

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        f.setSize(480, 700);

        PickleGame game = new PickleGame();

        f.add(game);

        // show window
        f.setVisible(true);

        Timer timer = new Timer(33, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

                game.repaint();
                game.gameLogic();

            }

        });

        timer.start();

    }
}