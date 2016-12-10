
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dZen on 05.12.2016.
 */

class Food extends Point {
    Random random = new Random();
//-----------------------------------------------------------------------------------------------------------------
    public Food() {
        super(-1, -1);
    }
//-----------------------------------------------------------------------------------------------------------------
    void eat() {
        setXY(-1, -1);
    }
//-----------------------------------------------------------------------------------------------------------------
    boolean isEaten() {
        return this.getX() == -1;
    }
//-----------------------------------------------------------------------------------------------------------------
    void next(Snake snake) {
        int x, y;
        do {
            x = random.nextInt(GameSnake.FIELD_WIDTH);
            y = random.nextInt(GameSnake.FIELD_HEIGHT);
        } while (snake.isInsideSnake(x, y));
        this.setXY(x, y);
    }
}