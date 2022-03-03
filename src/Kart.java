import javax.swing.*;

public class Kart {
    private int player;
    private ImageIcon imageIcon;
    private int locationX; // x coordinate
    private int locationY; // y coordinate
    private int targetX; // target x coordinate
    private int targetY; // target y coordinate
    private int speed; // current speed of kart: 0 - 100;
    private int direction;

    public Kart(int player) {
        if (player == 1) {
            this.player = player;
            direction = 4; // ensure kart is facing the right way at start
            imageIcon = new ImageIcon(getClass().getResource("/kartPics/redKart" + direction + ".png"));
            // set Kart on start line on creation
            targetX = 375;
            locationX = 375;
            targetY = 500;
            locationY = 500;
            speed = 0; // ensure kart is stationary at the start

        }
        else {
            this.player = player;
            direction = 4;
            imageIcon = new ImageIcon(getClass().getResource("/kartPics/blueKart" + direction + ".png"));
            // set kart on start line on creation
            locationX = 375;
            locationY = 550;
            speed = 0;
        }
    }

    public void updateLocation() {
        // L - R
        if (direction == 4) {
            targetX = locationX + (speed / 10);
            System.out.println("Speed: " + speed);
        }
        else if (direction == 0) {
            targetY = locationY - (speed / 10);
        }
        else if (direction == 12) {
            targetX = locationX - (speed / 10);
        }
        else if (direction == 8) {
            targetY = locationY + (speed / 10);
        }

        if (locationX != targetX) {
            locationX = targetX;
        }
        if (locationY != targetY) {
            locationY = targetY;
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

    public void updateDirection(int newDirection, int player) {
        speed = 0; // kill speed when turning direction
        direction = newDirection;

        if (player == 1) {
            imageIcon = new ImageIcon(getClass().getResource("/kartPics/redKart" + newDirection + ".png"));
        }
        else {
            imageIcon = new ImageIcon(getClass().getResource("/kartPics/blueKart" + newDirection + ".png"));

        }
    }
}
