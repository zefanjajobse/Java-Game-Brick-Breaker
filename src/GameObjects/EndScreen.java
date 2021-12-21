package GameObjects;

import java.awt.*;

public class EndScreen implements GameObject {
    private String type;
    private int currentScore;

    public EndScreen(String type, int currentScore) {
        this.type = type;
        this.currentScore = currentScore;
    }

    @Override
    public void draw(Graphics2D g) {
        // only draw when game done
        if (type != "") {
            g.setColor(Color.RED);
            g.setFont(new Font("serif",Font.BOLD, 30));
            if (type == "won") {
                g.drawString("You Won", 260,300);
            } else {
                g.drawString("Game Over, Scores: "+currentScore, 190,300);
            }

            g.setColor(Color.RED);
            g.setFont(new Font("serif",Font.BOLD, 20));
            g.drawString("Press (Enter) to Restart", 230,350);
        }
    }
}
