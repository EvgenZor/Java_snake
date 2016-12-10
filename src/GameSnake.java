
/**
 * Created by dZen on 21.10.2016.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameSnake extends JFrame{
//--------------------------------Исполняемый класс---------------------------------------------------------------------
    public static void main(String[] args) {
                new GameSnake();
    }
//----------------------------------------------------------------------------------------------------------------------
    protected static final String TITLE_OF_PROGRAM = "Classic Game Snake";
    protected static final String GAME_OVER_MSG = "GAME OVER";
    protected static final int POINT_RADIUS = 20; // in pix
    protected static final int FIELD_WIDTH = 30; // in point
    protected static final int FIELD_HEIGHT = 20;
    protected static final int FIELD_DX = 6;
    protected static final int FIELD_DY = 28;
    protected static final int START_LOCATION = 200;
    protected static final int START_SNAKE_SIZE = 6;
    protected static  final int START_SNAKE_X = 10;
    protected static final int START_SNAKE_Y = 10;
    protected static final int SHOW_DELAY = 1050;
    protected static final int LEFT = 37;
    protected static final int UP = 38;
    protected static final int RIGHT = 39;
    protected static final int DOWN = 40;
    protected static final int START_DIRECTION = RIGHT;
    Snake snake;
    Food food;
    //Poison poison;
    Canvas canvasPanel;
    protected static boolean gameOver = false;

 //--------------------------------Отрисовка окна---------------------------------------------------------------------
 private GameSnake() {
     setTitle(TITLE_OF_PROGRAM + " : " + START_SNAKE_SIZE);
     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     setSize(FIELD_WIDTH * POINT_RADIUS + FIELD_DX, FIELD_HEIGHT * POINT_RADIUS + FIELD_DY);
     setLocation(START_LOCATION, START_LOCATION);
     setResizable(false);
     canvasPanel = new Canvas();
     canvasPanel.setBackground(Color.white);
     getContentPane().add(BorderLayout.CENTER, canvasPanel);
     addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
             snake.setDirection(e.getKeyCode());
         }
     });
     setAlwaysOnTop(true);
     setVisible(true);
     snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, START_DIRECTION);
     food = new Food();
     while (!gameOver) {
         snake.move(food,this);
         if (food.isEaten()) {
             food.next(snake);
         }
         canvasPanel.repaint();
         try {
             Thread.sleep(SHOW_DELAY);
         } catch (InterruptedException e) { e.printStackTrace(); }
     }
 }
    //----------------------------Отрисовка окна-------------------------------------------------------------------------
public class Canvas extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        snake.paint(g, Point.DEFAULT_COLOR);
//        food.paint(g, Point.DEFAULT_COLOR);
        if (gameOver) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics fm = g.getFontMetrics();
            g.drawString(GAME_OVER_MSG, (FIELD_WIDTH * POINT_RADIUS + FIELD_DX - fm.stringWidth(GAME_OVER_MSG))/2,
                    (FIELD_HEIGHT * POINT_RADIUS + FIELD_DY)/2);
        }
    }
}
}
