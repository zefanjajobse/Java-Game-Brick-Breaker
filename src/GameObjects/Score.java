package GameObjects;

import java.awt.*;

public class Score implements GameObject {
    private int currentScore;

    public Score() {
        currentScore = 0;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD, 25));
        g.drawString(""+currentScore, 590,30);
    }

    public void add(int amount) {
        currentScore+=amount;
    }

    public int getScore() {
        return currentScore;
    }
}
