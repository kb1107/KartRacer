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

    private JLabel crashLabel;
    private JLabel winnerLabel;
    private JButton playAgainButton;

    private Timer timer;

    public RaceTrack() {
        setLayout(null); // suppress panel layout features

        redKart = new Kart(1);
        redKartLabel = new JLabel(redKart.getImageIcon());
        redKartLabel.setBounds((int)redKart.getLocationX(), (int)redKart.getLocationY(), 50, 50); // start just behind start line - image is 50x50px
        add(redKartLabel);

        blueKart = new Kart(2);
        blueKartLabel = new JLabel(blueKart.getImageIcon());
        blueKartLabel.setBounds((int)blueKart.getLocationX(), (int)blueKart.getLocationY(), 50, 50); // start just behind start line - image is 50x50px
        add(blueKartLabel);

        crashLabel = new JLabel("CRASH!!!  GAME OVER");
        crashLabel.setBounds(200, 250, 400, 50);

        winnerLabel = new JLabel();
        winnerLabel.setBounds(200, 250, 400, 50);

        playAgainButton = new JButton("Play Again");
        playAgainButton.setBounds(200, 300, 150, 50);
        playAgainButton.addActionListener(this);

        timer = new Timer(25, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        // Draw track
        Color c2 = Color.black;
        g.setColor( c2 );
        g.fillRect( 50, 100, 750, 500 ); // outer edge
        g.drawRect( 150, 200, 550, 300 ); // inner edge
        Color c1 = Color.green;
        g.setColor( c1 );
        g.fillRect( 150, 200, 550, 300 ); // grass

        Color c3 = Color.yellow;
        g.setColor( c3 );
        g.drawRect( 100, 150, 650, 400 ); // mid-lane marker
        //g.fillRect(425,101,10, 99); // half-lap marker
        Color c4 = Color.white;
        g.setColor( c4 );
        //g.drawLine( 425, 500, 425, 600 ); // start line
        g.fillRect(425, 501, 10, 99); // start/finish line


        // Draw karts
        redKartLabel.setIcon(redKart.getImageIcon());
        redKartLabel.setBounds((int)redKart.getLocationX(), (int)redKart.getLocationY(), 50, 50);

        blueKartLabel.setIcon(blueKart.getImageIcon());
        blueKartLabel.setBounds((int)blueKart.getLocationX(), (int)blueKart.getLocationY(), 50, 50);

        // Draw player 1 game information
        g.drawString("Player 1:", 155, 215);
        g.drawString("Speed: " + redKart.getSpeed(), 155, 235);
        g.drawString("Laps: " + redKart.getLapsLeft(), 155, 255);
        // FOR TESTING
        g.drawString("Half lap flag: " + redKart.getHalfLapFlag(), 155, 275);

        // Draw player 2 game information
        g.drawString("Player 2:", 620, 215);
        g.drawString("Speed: " + blueKart.getSpeed(), 620, 235);
        g.drawString("Laps: " + blueKart.getLapsLeft(), 620, 255);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            redKart.updateLocation();
            blueKart.updateLocation();
            redKart.checkLapCounter();
            blueKart.checkLapCounter();

            if (!checkKartCollisions()) {
                add(crashLabel);
                add(playAgainButton);
                timer.stop();
            }

            if (redKart.getLapsLeft() == 0) {
                winnerLabel.setText("Player 1 wins!");
                add(winnerLabel);
                add(playAgainButton);
                timer.stop();
            }

            if (blueKart.getLapsLeft() == 0) {
                winnerLabel.setText("Player 2 wins!");
                add(winnerLabel);
                add(playAgainButton);
                timer.stop();
            }

            repaint();
        }

        if (e.getSource() == playAgainButton) {
            redKart = new Kart(1);
            blueKart = new Kart(2);
            remove(winnerLabel);
            remove(playAgainButton);
            remove(crashLabel);

            timer.start();
        }

        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            int direction = redKart.getDirection();

            // L - R
            if (direction == 4) {
                redKart.updateSpeed(10); // accelerate
            }
            else if (direction == 12) {
                redKart.updateSpeed(-10); // brake
            }
            else if (direction == 15) {
                redKart.updateDirection(0, 1);
            }
            else if (direction > 12 || direction < 4) {
                redKart.updateDirection(direction + 1, 1);
            }
            else if (direction < 12 && direction > 4) {
                redKart.updateDirection(direction - 1, 1);
            }
        }

        if (key == KeyEvent.VK_UP) {
            int direction = redKart.getDirection();

            if (direction == 0) {
                redKart.updateSpeed(10); // accelerate
            }
            else if (direction == 8) {
                redKart.updateSpeed(-10); // brake
            }
            else if (direction == 15) {
                redKart.updateDirection(0, 1);
            }
            else if (direction > 8 && direction < 15) {
                redKart.updateDirection(direction + 1, 1);
            }
            else if (direction < 8 && direction > 0) {
                redKart.updateDirection(direction - 1, 1);
            }
        }

        if (key == KeyEvent.VK_LEFT) {
            int direction = redKart.getDirection();

            if (direction == 12) {
                redKart.updateSpeed(10); // accelerate
            }
            else if (direction == 4) {
                redKart.updateSpeed(-10); // brake
            }
            else if (direction == 0) {
                redKart.updateDirection(15, 1);
            }
            else if (direction > 12 || direction < 4) {
                redKart.updateDirection(direction - 1, 1);
            }
            else if (direction < 12 && direction > 4) {
                redKart.updateDirection(direction + 1, 1);
            }
        }

        if (key == KeyEvent.VK_DOWN) {
            int direction = redKart.getDirection();

            if (direction == 8) {
                redKart.updateSpeed(10); // accelerate
            }
            else if (direction == 0) {
                redKart.updateSpeed(-10); // brake
            }
            else if (direction > 0 && direction < 8) {
                redKart.updateDirection(direction + 1, 1);
            }
            else if (direction > 8) {
                redKart.updateDirection(direction - 1, 1);
            }
        }

        if (key == KeyEvent.VK_D) {
            int direction = blueKart.getDirection();

            // L - R
            if (direction == 4) {
                blueKart.updateSpeed(10); // accelerate
            }
            else if (direction == 12) {
                blueKart.updateSpeed(-10); // brake
            }
            else if (direction == 15) {
                blueKart.updateDirection(0, 2);
            }
            else if (direction > 12 || direction < 4) {
                blueKart.updateDirection(direction + 1, 2);
            }
            else if (direction < 12 && direction > 4) {
                blueKart.updateDirection(direction - 1, 2);
            }
        }

        if (key == KeyEvent.VK_W) {
            int direction = blueKart.getDirection();

            if (direction == 0) {
                blueKart.updateSpeed(10); // accelerate
            }
            else if (direction == 8) {
                blueKart.updateSpeed(-10); // brake
            }
            else if (direction == 15) {
                blueKart.updateDirection(0, 2);
            }
            else if (direction > 8 && direction < 15) {
                blueKart.updateDirection(direction + 1, 2);
            }
            else if (direction < 8 && direction > 0) {
                blueKart.updateDirection(direction - 1, 2);
            }
        }

        if (key == KeyEvent.VK_A) {
            int direction = blueKart.getDirection();

            if (direction == 12) {
                blueKart.updateSpeed(10); // accelerate
            }
            else if (direction == 4) {
                blueKart.updateSpeed(-10); // brake
            }
            else if (direction == 0) {
                blueKart.updateDirection(15, 2);
            }
            else if (direction > 12 || direction < 4) {
                blueKart.updateDirection(direction - 1, 2);
            }
            else if (direction < 12 && direction > 4) {
                blueKart.updateDirection(direction + 1, 2);
            }
        }

        if (key == KeyEvent.VK_S) {
            int direction = blueKart.getDirection();

            if (direction == 8) {
                blueKart.updateSpeed(10); // accelerate
            }
            else if (direction == 0) {
                blueKart.updateSpeed(-10); // brake
            }
            else if (direction > 0 && direction < 8) {
                blueKart.updateDirection(direction + 1, 2);
            }
            else if (direction > 8) {
                blueKart.updateDirection(direction - 1, 2);
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public boolean checkKartCollisions() {
        int redX = (int)redKart.getLocationX();
        int redY = (int)redKart.getLocationY();
        int blueX = (int)blueKart.getLocationX();
        int blueY = (int)blueKart.getLocationY();

        if ((blueX < redX + 40) && (blueX > redX - 40) && (blueY < redY + 40) && (blueY > redY - 40)) {
            System.out.println("CRASH"); // FOR TESTING
            // Scrub off all speed
            redKart.updateSpeed(-100);
            blueKart.updateSpeed(-100);
            return false;
        }

        return true;
    }
}
