package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pong extends JPanel{

    private int ballX = 50, ballY = 100;
    private int tennisX = 20, tennisY = 330;
    private int tennis2X = 30, tennis2Y = 20; 
    Tennis tennis;
    Tennis tennis2;
    Ball ball;
    Game game;
    int moveX = 1;
    int moveY = 1;
    
    public boolean running = true;
    
    public Pong(Game games){
        
        tennis = new Tennis(tennisX, tennisY);
        tennis2 = new Tennis(tennis2X, tennis2Y);
        
        ball = new Ball(ballX, ballY);
        game = games;
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //tennis1
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    tennisX += 5;                    
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    tennisX -= 5;
                }
                if(tennisX <= 0){
                    tennisX = 0;
                }
                if(tennisX >= getWidth() - tennis.getWidth()){
                    tennisX = getWidth() - tennis.getWidth();
                }
                
                //tennis2
                if(e.getKeyCode() == KeyEvent.VK_D){
                    tennis2X += 5;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    tennis2X -=5;
                }
                if(tennis2X <= 0){
                    tennis2X = 0;
                }
                if(tennis2X >= getWidth() - tennis2.getWidth()){
                    tennis2X = getWidth() - tennis2.getWidth();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        setFocusable(true);
    }
    
    public void update(){
 
       if(ball.getX() <= 0){
           moveX = 1;
       }
       if(ball.getX() >= getWidth() - ball.diam){
           moveX = -1;
       }
       if(ball.getY() <= 0){
           running = false;
           moveY = 0;
           game.setTitle("Pong, Player 1 Won ");
           ballX = 50;
           ballY = 100;
       }
       if(ball.getY() >= getHeight()){
           running = false;
           moveY = 0; //TODO have to change
           game.setTitle("Pong, Player 2 Won ");
           ballX = 50;
           ballY = 100;
       }
       boolean col1 = collision1();
       if(col1){          
           if(moveX == -1){
               moveX = -1;
           } 
           else{
               moveX = 1;
           }
           moveY = -1;
       }
       boolean col2 = collision2();
       if(col2){
           if(moveX == 1){
               moveX = 1;
           }
           else{
               moveX = -1;
           }
           moveY = 1;
       }
       
       ballX += moveX;
       ballY += moveY;
       
       ball.setXY(ballX, ballY);
       tennis.setX(tennisX);
       tennis2.setX(tennis2X);
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ball.render(g);
        tennis.render(g);
        tennis2.render(g);
        if(running == false){
            g.setColor(Color.BLUE);
            g.drawString("GAME OVER", getWidth()/2 - 20, getHeight()/2);
        }
    }
    
    public boolean collision1(){
        return tennis.getBounds().intersects(ball.getBounds());
    }
    public boolean collision2(){
        return tennis2.getBounds().intersects(ball.getBounds());
    }
    
    
}
