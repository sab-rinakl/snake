import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Fruit
{
    private int x, y;
    public Fruit()
    {
        x = (int)(Math.random()*1260)+25;
        y = (int)(Math.random()*700)+25;
    }

    public void draw(Graphics2D g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(x,y, 20, 20);
        g.setColor(Color.RED);
        g.fillOval(x,y, 20, 20);
    }

    public Rectangle getRect()
    {
        return new Rectangle(x, y, 20, 20);
    }

    public void spawn()
    {
        x = (int)(Math.random()*1300)+5;
        y = (int)(Math.random()*750)+5;
    }
}
