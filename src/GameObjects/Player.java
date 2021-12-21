package GameObjects;

import GameObjects.Types.Cordinates;

import java.awt.*;

public class Player implements GameObject {
    private Cordinates position;

    public Player() {
        position = new Cordinates(310, 0);
    }

    public void moveRight() {
        // if it's not hitting the edge of the screen
        if(position.getX() >= 600) {
            position.setX(600);
        }
        else {
            position.addToX(20);
        }
    }

    public void moveLeft() {
        // if it's not hitting the edge of the screen
        if(position.getX() < 10)
        {
            position.setX(10);
        }
        else
        {
            position.subFromX(20);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.green);
        g.fillRect(position.getX(), 550, 100, 8);
    }

    public Rectangle drawHitDetection(String location) {
        if (location == "left") {
            return new Rectangle(position.getX(), 550, 30, 8);
        } else if (location == "right") {
            return new Rectangle(position.getX() + 70, 550, 30, 8);
        } else {
            return new Rectangle(position.getX(), 550, 100, 8);
        }
    }
}
