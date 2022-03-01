import javax.swing.*;

public class Kart {
    private ImageIcon imageIcon;
    private final int IMAGE_HEIGHT = 50; // Image set to 50 px high
    private final int IMAGE_WIDTH = 50; // Image set to 50 px wide
    private int locationX; // x coordinate
    private int locationY; // y coordinate
    private int speed; // current speed of kart

    public Kart(int player) {
        if (player == 1) {
            imageIcon = new ImageIcon(getClass().getResource("/kartPics/redKart4.png"));
            // set Kart on start line on creation
            locationX = 375;
            locationY = 500;
        }
        else {
            imageIcon = new ImageIcon(getClass().getResource("/kartPics/blueKart4.png"));
            // set kart on start line on creation
            locationX = 375;
            locationY = 550;
        }
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }
}
