package adikshin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class StatsScreen {
    
    GameStats stats;
    
    public StatsScreen(GameStats stats){
        this.stats = stats;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        g.setColor(Color.green);
        String str = "STATS";
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        g.drawString(str, 512-(g.getFontMetrics().stringWidth(str)/2), 96);
        g.setColor(Color.yellow);
        g.drawLine(100, 120, 924, 120);
        g.drawLine(512, 120, 512, 476);
        g.setColor(Color.green);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        g.drawString("Jump Munnies", 100, 160);
        g.drawString("High Score", 100, 200);
        g.drawString("Rage Quits", 100, 240);
        g.drawString("Games Played", 100, 280);
        g.drawString("High Jumper?", 100, 320);
        g.drawString("Double Jumper?", 100, 360);
        g.drawString("Eternal Happiness?", 100, 400);
        g.drawString("Time Wasted", 100, 440);
        g.setColor(Color.white);
        g.drawString(String.valueOf(stats.jumps), 612, 160);
        g.drawString(String.valueOf(stats.highScore), 612, 200);
        g.drawString(String.valueOf(stats.gameQuits), 612, 240);
        g.drawString(String.valueOf(stats.gamesPlayed), 612, 280);
        g.drawString(String.valueOf(stats.hasJumpHeightUpgrade), 612, 320);
        g.drawString(String.valueOf(stats.hasJumpDoubleUpgrade), 612, 360);
        g.drawString(String.valueOf(stats.hasSmilyUpgrade), 612, 400);
        g.drawString(String.valueOf(stats.time) + " seconds", 612, 440);
        str = "►                      ◄";
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 526);
        str = "BACK";
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        g.setColor(Color.green);
        g.drawString(str, 512-g.getFontMetrics().stringWidth(str)/2, 526);
    }
    
}
