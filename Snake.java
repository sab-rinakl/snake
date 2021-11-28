import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Snake extends JFrame implements Runnable, KeyListener
{
    Container con = getContentPane();
    Thread t = new Thread(this);
    Fruit fruit;
    ArrayList <Segment> snake = new ArrayList<Segment>();
    public Snake()
    {
        con.setLayout(new FlowLayout());
        fruit = new Fruit();
        snake.add(new Segment());
        addKeyListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.start();
    }

    public void run()
    {
        try{
            while(true)
            {
                t.sleep(60); // time between frames
                snake.get(0).move(); 
                snake.get(0).offscreen();
                if(fruit.getRect().intersects(snake.get(0).getRect())) // eat fruit
                {
                    snake.add(new Segment());
                    snake.get(snake.size()-1).setX(snake.get(snake.size()-2).getrX());
                    snake.get(snake.size()-1).setY(snake.get(snake.size()-2).getrY());
                    fruit.spawn();
                }
                for (int a = 1; a < snake.size(); a++) // collision
                {
                    if (snake.get(0).getRect().intersects(snake.get(a).getRect()))
                    {
                        System.exit(0);
                    }
                }
                if (snake.size()>1) //move
                {
                    for (int a = 1; a < snake.size(); a++)
                    {
                        snake.get(a).move2();
                        snake.get(a).setX(snake.get(a-1).getrX());
                        snake.get(a).setY(snake.get(a-1).getrY());
                    }
                }
                repaint();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void paint(Graphics gr)
    {
        Image i=createImage(getSize().width, getSize().height);
        Graphics2D g = (Graphics2D)i.getGraphics();
        g.fillRect(0,0, getSize().width, getSize().height );
        fruit.draw(g);
        for(Segment d: snake)
        {
            d.draw(g);
        }
        g.dispose();
        gr.drawImage(i, 0, 0, this);
    }

    public static void main(String[] args)
    {
        Snake frame = new Snake();
        frame.setSize(1320, 768); // determines size of screen
        frame.setVisible(true);
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void keyReleased(KeyEvent k) // use arrow keys to move
    {
        if(k.getKeyCode() == 37)
        {
            snake.get(0).left();
        }
        if(k.getKeyCode() == 38)
        {
            snake.get(0).up();
        }
        if(k.getKeyCode() == 39)
        {
            snake.get(0).right();
        }
        if(k.getKeyCode() == 40)
        {
            snake.get(0).down();
        }
    }

    public void keyPressed(KeyEvent k)
    {
    }

    public void keyTyped(KeyEvent k)
    {
    }
}
