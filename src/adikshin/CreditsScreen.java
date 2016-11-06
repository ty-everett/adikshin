package adikshin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class CreditsScreen {
    
    int selection;
    
    public CreditsScreen(){
        selection = 1;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        String str = "CREDITS";
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
        g.setColor(Color.green);
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 130);
        str = "BACK";
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 450);
        str = "Made By Ty Everett";
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 250);
        str = "Inspired By The Google Chrome Offline Screen";
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 300);
        str = "Dedicated to Skylar B.";
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 350);
        str = "More Info: http://tyweb.us.to/adikshin";
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 400);
        str = "►                      ◄";
        g.setColor(Color.white);
        int y = 0;
        if(selection == 1) y = 450;
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, y);
    }
    
}
