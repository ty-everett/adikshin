package adikshin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class TitleScreen {
    
    int selection;
    Game g;
    
    public TitleScreen(Game g){
        selection = 1;
        this.g = g;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        String str = "ADIKSHIN!";
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
        g.setColor(Color.green);
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 130);
        str = "PLAY!";
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 250);
        str = "STORE!";
        g.setColor(Color.green);
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 300);
        str = "STATS!";
        g.setColor(Color.green);
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 350);
        str = "CREDITS!";
        g.setColor(Color.yellow);
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 400);
        str = "QUIT!";
        g.setColor(Color.red);
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 450);
        str = "►                      ◄";
        g.setColor(Color.white);
        int y = 0;
        if(selection == 1) y = 250;
        if(selection == 2) y = 300;
        if(selection == 3) y = 350;
        if(selection == 4) y = 400;
        if(selection == 5) y = 450;
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
