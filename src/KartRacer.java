import javax.swing.*;
import java.awt.*;

public class KartRacer extends JFrame {
    private RaceTrack rt;

    public KartRacer() {
        setTitle("Gran Turismo 8");
        setBounds(100, 100, 850, 650);  // Set window size to 850x650 pixels
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(null);  // suppress default layout

        rt = new RaceTrack();
        rt.setBounds(0,0,850,650);  // Location within JFrame
        rt.addKeyListener(rt);
        rt.setFocusable(true); // Allows it to respond to focus related events

        cp.add(rt);
    }

    public static void main(String[] args) {
        KartRacer kartRacer = new KartRacer();
        kartRacer.setVisible(true);
    }
}
