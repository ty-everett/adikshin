package adikshin;

import com.sun.org.apache.bcel.internal.generic.F2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Player {
    
    int x, y, vy, w, h, jumps;
    GameStats stats;
    
    public Player(GameStats stats){
        x = 256;
        w = 26;
        h = 64;
        y = 1;
        this.stats = stats;
        jumps = 0;
    }
    
    public void tick(){
        y+=vy;
        if(y < 236){
            y+=7;
        }else{
            y=236;
            jumps = 0;
        }
        if(y < 120){
            if(stats.hasJumpHeightUpgrade == 0){
                if(jumps == 2 && stats.hasJumpDoubleUpgrade == 1){
                    if(y < 70){
                        vy=0;
                    }
                }else{
                    vy=0;
                }
            }else if(y < 105){
                if(jumps == 2 && stats.hasJumpDoubleUpgrade == 1){
                    if(y < 40){
                        vy=0;
                    }
                }else{
                    vy=0;
                }
            }
        }
    }
    
    public void render(Graphics g){
        g.setColor(new Color(195, 215, 160));
        g.fillRect(x, y, w, h);
        if(stats.hasSmilyUpgrade == 1){
            g.setFont(new Font("Arial", Font.PLAIN, 64));
            g.drawString("☻", x-16, y-4);
        }
    }
    
    public Rectangle getRectangle(){
        return new Rectangle(x, y, w, h);
    }
    
    public void setVY(int i){
        vy = i;
    }
    public int getY(){
        return y;
    }
    
}
