
/**
 * Created by dZen on 21.10.2016.
 */

import java.awt.*;

class Point {
    protected static int x, y;
    protected static final Color DEFAULT_COLOR = Color.black;
    protected static final Color FOOD_COLOR = Color.green;
    protected static final Color POISON_COLOR = Color.red;
    Color color = DEFAULT_COLOR;
//-----------------------------------------------------------------------------------------------------------------
    public Point(int x, int y) {
        this.setXY(x, y);
    }
//-----------------------------------------------------------------------------------------------------------------
    void paint(Graphics g,Color color) {
        g.setColor(color);
        g.fillOval(x * GameSnake.POINT_RADIUS, y * GameSnake.POINT_RADIUS, GameSnake.POINT_RADIUS, GameSnake.POINT_RADIUS);
    }

    int getX() { return x; }
    int getY() { return y; }

    void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

}