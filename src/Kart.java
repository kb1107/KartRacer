import javax.swing.*;

public class Kart {
    private ImageIcon imageIcon;
    //private final int IMAGE_HEIGHT = 50; // Image set to 50 px high
    //private final int IMAGE_WIDTH = 50; // Image set to 50 px wide
    private int locationX; // x coordinate
    private int locationY; // y coordinate
    private int speed; // current speed of kart: 0 - 100;
    private int direction;

    public Kart(int player) {
        if (player == 1) {
            imageIcon = new ImageIcon(getClass().getResource("/kartPics/redKart4.png"));
            // set Kart on start line on creation
            locationX = 375;
            locationY = 500;
            speed = 0; // ensure kart is stationary at the start
            direction = 4; // ensure kart is facing the right way at start
        }
        else {
            imageIcon = new ImageIcon(getClass().getResource("/kartPics/blueKart4.png"));
            // set kart on start line on creation
            locationX = 375;
            locationY = 550;
        }
    }

    public void updateLocation() {
        // L - R
        if (direction == 4) {
            locationX += 2 * speed;
        }
        if (direction == 0) {
            locationY -= 2 * speed;
        }
        if (direction == 12) {
            locationX -= 2 * speed;
        }
        if (direction == 8) {
            locationY += 2 * speed;
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

    public int getDirection() {
        return direction;
    }

    public void updateSpeed(int dspeed) {
        speed += dspeed;
        if (speed > 100) {
            speed = 100;
        }
        else if (speed < 0){
            speed = 0;
        }
    }

    public void updateDirection(int newDirection) {
        speed = 0; // kill speed when turning direction
        direction = newDirection;
        imageIcon = new ImageIcon(getClass().getResource("/kartPics/redKart" + direction + ".png"));
    }
}
