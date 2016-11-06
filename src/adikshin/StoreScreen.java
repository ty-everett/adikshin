package adikshin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class StoreScreen {
    
    int choice;
    GameStats stats;
    
    public StoreScreen(GameStats stats){
        choice = 1;
        this.stats = stats;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        g.setColor(Color.green);
        String str = "STORE";
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        g.drawString(str, 512-(g.getFontMetrics().stringWidth(str)/2), 96);
        str = "You have " + stats.jumps + " Jump Munnies.";
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        g.setColor(Color.green);
        g.drawString(str, 10, 40);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
        if(stats.hasJumpHeightUpgrade == 1){
            g.setColor(Color.white);
        }else{
            g.setColor(Color.green);
        }
        str = "Jump Height Upgrade - $200";
        g.drawString(str, 512-(g.getFontMetrics().stringWidth(str)/2), 170);
        if(stats.hasJumpDoubleUpgrade == 1){
            g.setColor(Color.white);
        }else{
            g.setColor(Color.green);
        }
        str = "Double Jump Upgrade - $350";
        g.drawString(str, 512-(g.getFontMetrics().stringWidth(str)/2), 240);
        if(stats.hasSmilyUpgrade == 1){
            g.setColor(Color.white);
        }else{
            g.setColor(Color.green);
        }
        str = "☺☻☺☻☺☻☺☻☺☻ - $1500";
        g.setFont(new Font("Arial", Font.PLAIN, 48));
        g.drawString(str, 512-(g.getFontMetrics().stringWidth(str)/2), 310);
        str = "►                                                     ◄";
        int y = 0;
        if(choice == 1){
            y = 170;
        }else if(choice == 2){
            y = 240;
        }else if(choice == 3){
            y = 310;
        }else if(choice == 4){
            y = 450;
            str = "►                    ◄";
        }
        g.setColor(Color.white);
        g.drawString(str, 512-(g.getFontMetrics().stringWidth(str)/2), y);
        str = "BACK";
        g.setColor(Color.green);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
        g.drawString(str, 512-(g.getFontMetrics().stringWidth(str)/2), 450);
    }
    
    
}
