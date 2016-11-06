package adikshin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Obsticle {
    
    int x, y, w, h;
    boolean b;
    
    public Obsticle(){
        Random r = new Random();
        w = r.nextInt(5) + 26;
        h = w;
        x = 1025;
        y = 300-h;
        b = false;
    }
    public Obsticle(boolean b){
        Random r = new Random();
        if(b){
            x = 1025;
            y = r.nextInt(576);
             w = r.nextInt(3) + 1;
            h = r.nextInt(3) + 1;
            this.b = true;
        }else{
            x = r.nextInt(1024);
            y = r.nextInt(576);
             w = r.nextInt(3) + 1;
            h = r.nextInt(3) + 1;
            this.b = true;
        }
    }
    
    public void tick(){
        x-=7;
        if(b == true){
            x+=2;
        }
    }
    
    public void render(Graphics g){
        if(b){
            g.setColor(new Color(190, 190, 170));
        }else{
            g.setColor(new Color(150, 150, 180));
        }
        g.fillRect(x, y, w, h);
    }
    
    public Rectangle getRectangle(){
        return new Rectangle(x, y, w, h);
    }
    
}