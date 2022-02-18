import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RaceTrack extends JPanel implements ActionListener, KeyListener {

    private ImageIcon redKart;
    private JLabel redKartLabel;

    private ImageIcon blueKart;
    private JLabel blueKartLabel;

    private Timer timer;

    public RaceTrack() {
        setLayout(null); // suppress panel layout features

        redKart = new ImageIcon(getClass().getResource("/kartPics/redKart4.png"));
        redKartLabel = new JLabel(redKart);
        redKartLabel.setBounds(375, 500, 50, 50); // start just behind start line - image is 50x50px
        add(redKartLabel);

        blueKart = new ImageIcon(getClass().getResource("/kartPics/blueKart4.png"));
        blueKartLabel = new JLabel(blueKart);
        blueKartLabel.setBounds(375, 550, 50, 50); // start just behind start line - image is 50x50px
        add(blueKartLabel);

        timer = new Timer(100, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

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

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
        }
    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}
