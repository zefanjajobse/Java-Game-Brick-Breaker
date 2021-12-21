package GameObjects;

import java.awt.*;

public class Border implements GameObject {
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);
    }
}
