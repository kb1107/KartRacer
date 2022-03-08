import javax.swing.*;

public class Kart {
    private int player;
    private ImageIcon imageIcon;
    private double locationX; // x coordinate
    private double locationY; // y coordinate
    private double targetX; // target x coordinate
    private double targetY; // target y coordinate
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
            targetX = 375;
            locationX = 375;
            targetY = 550;
            locationY = 550;
            speed = 0;
        }
    }

    public void updateLocation() {
        // L - R
        if (direction == 4) {
            targetX = locationX + 2 * (speed / 10);
        }
        else if (direction == 3) {
            targetX = locationX + 2 * (speed / 10);
            targetY = locationY - 1 * (speed / 10);
        }
        else if (direction == 2) {
            targetX = locationX + 2 * (speed / 10);
            targetY = locationY - 2 * (speed / 10);
        }
        else if (direction == 1) {
            targetX = locationX + 1 * (speed / 10);
            targetY = locationY - 2 * (speed / 10);
        }
        else if (direction == 0) {
            targetY = locationY - 2 * (speed / 10);
        }
        else if (direction == 15) {
            targetX = locationX - 1 * (speed / 10);
            targetY = locationY - 2 * (speed / 10);
        }
        else if (direction == 14) {
            targetX = locationX - 2 * (speed / 10);
            targetY = locationY - 2 * (speed / 10);
        }
        else if (direction == 13) {
            targetX = locationX - 2 * (speed / 10);
            targetY = locationY - 1 * (speed / 10);
        }
        else if (direction == 12) {
            targetX = locationX - 2 * (speed / 10);
        }
        else if (direction == 11) {
            targetX = locationX - 2 * (speed / 10);
            targetY = locationY + 1 * (speed / 10);
        }
        else if (direction == 10) {
            targetX = locationX - 2 * (speed / 10);
            targetY = locationY + 2 * (speed / 10);
        }
        else if (direction == 9) {
            targetX = locationX - 1 * (speed / 10);
            targetY = locationY + 2 * (speed / 10);
        }
        else if (direction == 8) {
            targetY = locationY + 2 * (speed / 10);
        }
        else if (direction == 7) {
            targetX = locationX + 1 * (speed / 10);
            targetY = locationY + 2 * (speed / 10);
        }
        else if (direction == 6) {
            targetX = locationX + 2 * (speed / 10);
            targetY = locationY + 2 * (speed / 10);
        }
        else if (direction == 5) {
            targetX = locationX + 2 * (speed / 10);
            targetY = locationY + 1 * (speed / 10);
        }

        // Stop Kart leaving right side of track
        if (targetX > 750) {
            targetX = 750;
            speed = 0; // Scrub off all speed as kart has crashed
        }
        // Stop Kart leaving top of track
        if (targetY < 100) {
            targetY = 100;
            speed = 0;
        }
        // stop kart leaving left side of track
        if (targetX < 50) {
            targetX = 50;
            speed = 0;
        }
        // stop kart leaving bottom of track
        if (targetY > 550) {
            targetY = 550;
            speed = 0;
        }


        // Move kart
        if (locationX != targetX) {
            locationX = targetX;
        }
        if (locationY != targetY) {
            locationY = targetY;
        }

        System.out.println("Speed: " + speed); // FOR TESTING
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public double getLocationX() {
        return locationX;
    }

    public double getLocationY() {
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
        direction = newDirection;

        if (speed > 10) {
            speed -= 10; // if moving quicker than minimmum speed, scrub off some speed
        }

        if (player == 1) {
            imageIcon = new ImageIcon(getClass().getResource("/kartPics/redKart" + newDirection + ".png"));
        }
        else {
            imageIcon = new ImageIcon(getClass().getResource("/kartPics/blueKart" + newDirection + ".png"));

        }
    }
}
