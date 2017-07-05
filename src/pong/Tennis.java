package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Tennis {
    
    public int x;
    public int y;
    public int width = 60;
    public int height = 10;
    
    public Tennis(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void render(Graphics g){
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
    }
    public int getWidth(){
        return width;
    }
    public void setX(int x){
        this.x = x;
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }
}
