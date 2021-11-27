import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Segment
{
    private int x, y, xV, yV, rX, rY;
    public Segment()
    {
        xV = 0;
        yV = 0;
        x = 400;
        y = 400;
    }

    public void offscreen()
    {
        if (x<0 || x>1300 || y<0 || y>748)
        {
            System.exit(0);
        }
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int a)
    {
        x = a;
    }

    public void setY(int a)
    {
        y = a;
    }

    public int getrX()
    {
        return rX;
    }

    public int getrY()
    {
        return rY;
    }

    public void draw(Graphics2D g)
    {
        g.setColor(Color.YELLOW);
        g.fillRect(x,y, 20, 20);
        g.setColor(Color.GREEN);
        g.fillOval(x,y, 20, 20);
    }

    public Rectangle getRect()
    {
        return new Rectangle(x, y, 20, 20);
    }

    public void move()
    {
        rX= x;
        rY = y;
        x += xV;
        y += yV;
    }
    
    public void move2()
    {
        rX = x;
        rY = y;
    }

    public void left()
    {
        xV = -20;
        yV = 0;
    }

    public void right()
    {
        xV = 20;
        yV = 0;
    }

    public void up()
    {
        xV = 0;
        yV = -20;
    }

    public void down()
    {
        xV = 0;
        yV = 20;
    }
}