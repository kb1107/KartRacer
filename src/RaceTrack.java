import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RaceTrack extends JPanel implements ActionListener, KeyListener {

    private Kart redKart;
    private JLabel redKartLabel;

    private Kart blueKart;
    private JLabel blueKartLabel;

    private Timer timer;

    public RaceTrack() {
        setLayout(null); // suppress panel layout features



        redKart = new Kart(1);
        redKartLabel = new JLabel(redKart.getImageIcon());
        redKartLabel.setBounds(redKart.getLocationX(), redKart.getLocationY(), 50, 50); // start just behind start line - image is 50x50px
        add(redKartLabel);

        blueKart = new Kart(2);
        blueKartLabel = new JLabel(blueKart.getImageIcon());
        blueKartLabel.setBounds(blueKart.getLocationX(), blueKart.getLocationY(), 50, 50); // start just behind start line - image is 50x50px
        add(blueKartLabel);

        timer = new Timer(50, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        // Draw track
        Color c1 = Color.green;
        g.setColor( c1 );
        g.fillRect( 150, 200, 550, 300 ); // grass
        Color c2 = Color.black;
        g.setColor( c2 );
        g.drawRect( 50, 100, 750, 500 ); // outer edge
        g.drawRect( 150, 200, 550, 300 ); // inner edge
        Color c3 = Color.yellow;
        g.setColor( c3 );
        g.drawRect( 100, 150, 650, 400 ); // mid-lane marker
        Color c4 = Color.white;
        g.setColor( c4 );
        g.drawLine( 425, 500, 425, 600 ); // start line

        // Update redKart position
        //redKart.updateLocation();

        //Update blueKart position
        //blueKart.updateLocation();

        // Draw karts
        redKartLabel.setIcon(redKart.getImageIcon());
        redKartLabel.setBounds(redKart.getLocationX(), redKart.getLocationY(), 50, 50);
        blueKartLabel.setBounds(blueKart.getLocationX(), blueKart.getLocationY(), 50, 50);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int direction = redKart.getDirection();

        if (key == KeyEvent.VK_RIGHT) {
            System.out.println("key pressed: RIGHT"); // FOR TESTING
            // L - R
            if (direction == 4) {
                redKart.updateSpeed(10); // accelerate
                redKart.updateLocation();
            }
            else if (direction == 12) {
                redKart.updateSpeed(-10); // brake
            }
            else if (direction == 15) {
                redKart.updateDirection(0);
            }
            else if (direction > 12 || direction < 4) {
                redKart.updateDirection(direction + 1);
            }
            else if (direction < 12 && direction > 4) {
                redKart.updateDirection(direction - 1);
            }
//            if (redKart.getDirection() == 8) {
//                redKart.updateDirection(7);
//            }
//            else if (redKart.getDirection() == 7) {
//                redKart.updateDirection(6);
//            }
//            else if (redKart.getDirection() == 6) {
//                redKart.updateDirection(5);
//            }
//            else if (redKart.getDirection() == 5) {
//                redKart.updateDirection(4);
//            }
        }

        if (key == KeyEvent.VK_UP) {
            System.out.println("key pressed: UP"); //FOR TESTING
            if (direction == 0) {
                redKart.updateSpeed(10); // accelerate
                redKart.updateLocation();
            }
            else if (direction == 8) {
                redKart.updateSpeed(-10); // brake
            }
            else if (direction == 15) {
                redKart.updateDirection(0);
            }
            else if (direction > 8 && direction < 15) {
                redKart.updateDirection(direction + 1);
            }
            else if (direction < 8 && direction > 0) {
                redKart.updateDirection(direction - 1);
            }
//            else if (redKart.getDirection() == 4) {
//                redKart.updateDirection(3);
//            }
//            else if (redKart.getDirection() == 3) {
//                redKart.updateDirection(2);
//            }
//            else if (redKart.getDirection() == 2) {
//                redKart.updateDirection(1);
//            }
//            else if (redKart.getDirection() == 1) {
//                redKart.updateDirection(0);
//            }

        }

        if (key == KeyEvent.VK_LEFT) {
            System.out.println("key pressed: LEFT"); //FOR TESTING
            if (direction == 12) {
                redKart.updateSpeed(10); // accelerate
                redKart.updateLocation();
            }
            else if (direction == 4) {
                redKart.updateSpeed(-10); // brake
            }
            else if (direction == 0) {
                redKart.updateDirection(15);
            }
            else if (direction > 12 || direction < 4) {
                redKart.updateDirection(direction - 1);
            }
            else if (direction < 12 && direction > 4) {
                redKart.updateDirection(direction + 1);
            }
//            if (redKart.getDirection() == 0) {
//                redKart.updateDirection(15);
//            }
//            else if (redKart.getDirection() == 15) {
//                redKart.updateDirection(14);
//            }
//            else if (redKart.getDirection() == 14) {
//                redKart.updateDirection(13);
//            }
//            else if (redKart.getDirection() == 13) {
//                redKart.updateDirection(12);
//            }

        }

        if (key == KeyEvent.VK_DOWN) {
            System.out.println("key pressed: DOWN"); //FOR TESTING
            if (direction == 8) {
                redKart.updateSpeed(10); // accelerate
                redKart.updateLocation();
            }
            else if (direction == 0) {
                redKart.updateSpeed(-10); // brake
            }
            else if (direction > 0 && direction < 8) {
                redKart.updateDirection(direction + 1);
            }
            else if (direction > 8) {
                redKart.updateDirection(direction - 1);
            }
//            if (redKart.getDirection() == 12) {
//                redKart.updateDirection(11);
//            }
//            else if (redKart.getDirection() == 11) {
//                redKart.updateDirection(10);
//            }
//            else if (redKart.getDirection() == 10) {
//                redKart.updateDirection(9);
//            }
//            else if (redKart.getDirection() == 9) {
//                redKart.updateDirection(8);
//            }

        }

    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }
}
