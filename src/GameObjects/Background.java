package GameObjects;

import java.awt.*;

public class Background implements GameObject {
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);
    }
}
