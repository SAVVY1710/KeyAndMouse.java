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
    class BallMover implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // ball XY location
            ballY += ballspeed;
            if (ballY > 470) {
                ballY = 10;
                ballX = (int)(Math.random() * 470) + 1;
            }
            repaint();
            grabFocus();
        }
    } // end BallMover

    class CarMover implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // car XY location
            carX+= carspeed;
            if (carX > 490 ) carX = 0;
            repaint();
            grabFocus();
        }
    } // end CarMover

    class Car2Mover implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // car XY location
            car2X += -1*carspeed;
            if(car2X < 0)car2X = 490;
            repaint();
            grabFocus();
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.gray);

        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.BOLD, 30));
        g.drawString("Press number for ball", 20, 50);
        g.drawString("Press vowel for orange car", 20, 100);
        g.drawString("Press key from bottom row for blue car", 20, 150);

        //g.drawString ("Press mouse on the panel.  To increase the font size, press the UP arrow.  ", 50, 300);
        //g.drawString("To make the screen darker, click the box labelled darker", 50, 400);
        //g.drawString("To make the screen brighter, click the box labelled brighter" , 50, 500);
        //g.drawString("To make the screen darker, click the box labelled darker", 50, 600);

        // paint ball
        if(ballcolor == 0 || ballcolor%2 == 0)g.setColor(Color.pink);
        else if(ballcolor%2 == 1)g.setColor(Color.green);

        g.fillOval(ballX, ballY, 30, 30);

        // paint car
        g.setColor(Color.orange);
        g.fillOval(carX+2, carY, 20, 20); // back wheel
        g.fillOval(carX+40, carY, 20, 20); // front wheel
        g.fillRect(carX, carY-20, 60, 20); // car body
        g.fillRect(carX+10, carY-35, 40, 15); // car top

        // paint car
        g.setColor(Color.blue);
        g.fillOval(car2X+2, car2Y, 20, 20); // back wheel
        g.fillOval(car2X+40, car2Y, 20, 20); // front wheel
        g.fillRect(car2X, car2Y-20, 60, 20); // car body
        g.fillRect(car2X+10, car2Y-35, 40, 15); // car top
    } // end paintComponent

    //This method is triggered when the key is typed
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        switch (c)
        {
            case ' ':
                if (carMoveIt) cartimer.stop();
                else cartimer.start();
                carMoveIt = ! carMoveIt;
                break;
            case 'a':
                if (carMoveIt) cartimer.stop();
                else cartimer.start();
                carMoveIt = ! carMoveIt;
                break;
            case 'e':
                if (carMoveIt) cartimer.stop();
                else cartimer.start();
                carMoveIt = ! carMoveIt;
                break;
                case 'i':
                if (carMoveIt) cartimer.stop();
                else cartimer.start();
                carMoveIt = ! carMoveIt;
                break;
            case 'o':
                if (carMoveIt) cartimer.stop();
                else cartimer.start();
                carMoveIt = ! carMoveIt;
                break;
            case 'u':
                if (carMoveIt) cartimer.stop();
                else cartimer.start();
                carMoveIt = ! carMoveIt;
                break;
            case '1':
                if (ballMoveIt) balltimer.stop();
                else balltimer.start();
                ballMoveIt = ! ballMoveIt;
                break;
            case '2':
                if (ballMoveIt) balltimer.stop();
                else balltimer.start();
                ballMoveIt = ! ballMoveIt;
                break;
            case '3':
                if (ballMoveIt) balltimer.stop();
                else balltimer.start();
                ballMoveIt = ! ballMoveIt;
                break;
            case '4':
                if (ballMoveIt) balltimer.stop();
                else balltimer.start();
                ballMoveIt = ! ballMoveIt;
                break;
            case '5':
                if (ballMoveIt) balltimer.stop();
                else balltimer.start();
                ballMoveIt = ! ballMoveIt;
                break;
            case '6':
                if (ballMoveIt) balltimer.stop();
                else balltimer.start();
                ballMoveIt = ! ballMoveIt;
                break;
            case '7':
                if (ballMoveIt) balltimer.stop();
                else balltimer.start();
                ballMoveIt = ! ballMoveIt;
                break;
            case '8':
                if (ballMoveIt) balltimer.stop();
                else balltimer.start();
                ballMoveIt = ! ballMoveIt;
                break;
        }
    } // end keyPressed

    //This method is triggered when the key is Pressed
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();//up is 38
        if(keyCode == 16) ballcolor++;
        if(keyCode == 38) carspeed++;
        if(keyCode == 40 && carspeed>=2) carspeed--;
        if(keyCode == 39) ballspeed++;
        if(keyCode == 37 && ballspeed>=2) ballspeed--;


    }

    //This method is triggered when the key is Released
    public void keyReleased(KeyEvent e)
    {

    }
}