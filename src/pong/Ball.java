package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Ball {
    private int x, y;
    public int diam = 15;
    public Ball(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.drawOval(x, y, diam, diam);
        g.setColor(Color.red);
        g.fillOval(x, y, diam, diam);
    }
    
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, diam, diam);
    }
}
