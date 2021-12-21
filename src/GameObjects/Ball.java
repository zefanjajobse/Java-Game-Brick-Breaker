package GameObjects;

import GameObjects.Types.Cordinates;

import java.awt.*;

public class Ball implements GameObject {
    private Cordinates position;
    private Cordinates direction;

    public Ball() {
        position = new Cordinates(120, 350);
        direction = new Cordinates(-1, -2);
    }

    public void stop() {
        this.direction = new Cordinates(0, 0);
    }

    public Cordinates getPosition() {
        return position;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.yellow);
        g.fillOval(position.getX(), position.getY(), 20, 20);
    }

    public Rectangle drawHitDetection() {
        return new Rectangle(position.getX(), position.getY(), 20, 20);
    }

    public void forceLeft() {
        direction.setX(-2);
    }

    public void forceRight() {
        direction.setX(direction.getX() + 1);
    }

    public void reverseXDir() {
        direction.setX(-direction.getX());
    }

    public void reverseYDir() {
        direction.setY(-direction.getY());
    }

    public void move() {
        position.addToX(direction.getX());
        position.addToY(direction.getY());

        // if it hits the edge of the screen
        if(position.getX() < 0)
        {
            this.reverseXDir();
        }
        if(position.getY() < 0)
        {
            this.reverseYDir();
        }
        if(position.getX() > 670)
        {
            this.reverseXDir();
        }
    }
}
