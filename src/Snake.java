
/**
 * Created by dZen on 21.10.2016.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Snake {
    ArrayList<Point> snake ;
    int direction;
//-----------------------------------------------------------------------------------------------------------------
    public Snake(int x, int y, int length, int direction) {
        snake = new ArrayList<Point>(GameSnake.START_SNAKE_SIZE);

        for (int i = 0; i < length; i++) {
            Point point = new Point(x-i, y);
            snake.add(point);
        }
        this.direction = direction;
    }
//-----------------------------------------------------------------------------------------------------------------
    boolean isInsideSnake(int x, int y) {
        for (Point point : snake) {
            if ((point.getX() == x) && (point.getY() == y)) {
                return true;
            }
        }
        return false;
    }
//-----------------------------------------------------------------------------------------------------------------
    boolean isFood(Point food) {
        return ((snake.get(0).getX() == food.getX()) && (snake.get(0).getY() == food.getY()));
    }
//-----------------------------------------------------------------------------------------------------------------
    void move(Food food, JFrame frame) {
        int x = snake.get(0).getX();
        int y = snake.get(0).getY();
        if (direction == GameSnake.LEFT) { x--; }
        if (direction == GameSnake.RIGHT) { x++; }
        if (direction == GameSnake.UP) { y--; }
        if (direction == GameSnake.DOWN) { y++; }
        if (x > GameSnake.FIELD_WIDTH - 1) { x = 0; }
        if (x < 0) { x = GameSnake.FIELD_WIDTH - 1; }
        if (y > GameSnake.FIELD_HEIGHT - 1) { y = 0; }
        if (y < 0) { y = GameSnake.FIELD_HEIGHT - 1; }
//        GameSnake.gameOver = isInsideSnake(x, y); // check for acrooss itselves
        snake.add(0, new Point(x, y));
//        if (isFood(food)) {
//            food.eat();
//            frame.setTitle(GameSnake.TITLE_OF_PROGRAM + " : " + snake.size());
//        } else {
//            snake.remove(snake.size() - 1);
//        }
    }
//-----------------------------------------------------------------------------------------------------------------
    void setDirection(int direction) {
        if ((direction >= GameSnake.LEFT) && (direction <= GameSnake.DOWN)) {
            if (Math.abs(this.direction - direction) != 2) {
                this.direction = direction;
            }
        }
    }
//-----------------------------------------------------------------------------------------------------------------
    void paint(Graphics g, Color color) {
        for (int i = 0 ; i < snake.size() ; i++) {
            snake.get(i).paint(g,color);
        }
    }
}