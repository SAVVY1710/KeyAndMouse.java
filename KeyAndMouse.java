/*
Sai Avula
7.25.24
KeyAndMouse.java
Use keyboard listener
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyAndMouse
{
    JFrame frame;
    DrawingPanel canvas;
    public static void main (String[] args)
    {
        KeyAndMouse kt = new KeyAndMouse();
        kt.Run();
    } // end main

    public void Run() 
    {
        frame = new JFrame("KeyTimer");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new DrawingPanel();
        frame.getContentPane().add(canvas);

        frame.setVisible(true);
    }
}

class DrawingPanel extends JPanel implements KeyListener 
{
    private int ballX, ballY;
    private int carX, carY, ballcolor, carspeed, ballspeed, car2X, car2Y;
    private boolean ballMoveIt;  // starts and stops ball movement
    private boolean carMoveIt, car2MoveIt;  // starts and stops car movement
    private Timer balltimer, cartimer, car2timer;

    public DrawingPanel() {
        ballX = 200;
        ballY = 10;

        carX = 10;
        carY = 400;
        car2X = 10;
        car2Y = 400;
        carspeed = 1;
        ballspeed = 1;
        ballMoveIt = carMoveIt = car2MoveIt = true;
        addKeyListener(this);
        // create timer for animation of ball
        BallMover ballmover = new BallMover();
        balltimer = new Timer(5, ballmover);
        balltimer.start();
        // Format --> timer = new Timer( millisDelay, listener );
        CarMover carmover = new CarMover();
        cartimer = new Timer(10, carmover);
        cartimer.start();
        Car2Mover car2mover = new Car2Mover();
        car2timer = new Timer(10, car2mover);
        car2timer.start();
    }
}