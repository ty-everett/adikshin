package adikshin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class PausedScreen {
    
    int selection;
    
    public PausedScreen(){
        selection = 1;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        String str = "GAME PAUSED!";
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
        g.setColor(Color.green);
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 130);
        str = "RESUME!";
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 250);
        str = "QUIT!";
        g.setColor(Color.red);
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 300);
        str = "►                      ◄";
        g.setColor(Color.white);
        int y = 0;
        if(selection == 1) y = 250;
        if(selection == 2) y = 300;
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, y);
    }
    
    public void setSelection(int i){
        selection = i;
    }
    
    public int getSelection(){
        return selection;
    }
    
}
