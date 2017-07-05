package pong;

import javax.swing.JFrame;


public class Game extends JFrame{
    static Pong pong;
    
    public Game(){
        setTitle("Pong");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        pong = new Pong(this);
        add(pong);
        setVisible(true);
        
    }
    public static void main(String[] args) throws InterruptedException {
            
        new Game();
        
        while(pong.running){      
            pong.update();           
            pong.repaint();
            Thread.sleep(10);
        }
        
    }
}
