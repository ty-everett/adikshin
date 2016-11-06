package adikshin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class DeadScreen {
    
    int selection;
    Game g;
    
    public DeadScreen(Game g){
        selection = 1;
        this.g = g;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        String str = "DED";
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 250));
        g.setColor(Color.green);
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 250);
        str = "SCORE: " + this.g.level.score;
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        g.setColor(Color.yellow);
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 350);
        str = "HIGHSCORE: " + this.g.stats.highScore;
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 400);
        str = "RESTART!";
        g.setColor(Color.GREEN);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 450);
        str = "QUIT!";
        g.setColor(Color.red);
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 500);
        str = "►                      ◄";
        g.setColor(Color.white);
        int y = 0;
        if(selection == 1) y = 450;
        if(selection == 2) y = 500;
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, y);
    }
    
    public int getSelection(){
        return selection;
    }
    
    public void setSelection(int i){
        selection = i;
    }
    
}
