package GameObjects.Types;

public final class Cordinates {
    private int x;
    private int y;

    public Cordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addToX(int x) {
        this.x += x;
    }

    public void addToY(int y) {
        this.y += y;
    }

    public void subFromX(int x) {
        this.x -= x;
    }

    public void subFromY(int y) {
        this.y -= y;
    }
}
