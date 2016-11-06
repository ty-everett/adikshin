package adikshin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;


public class Level {
    
    LinkedList<Obsticle> o = new LinkedList<Obsticle>();
    Player p;
    int counter, score = 0;
    Random r = new Random();
    Game g;
    GameStats stats;
    
    public Level(Game g, GameStats stats){
        p = new Player(stats);
        this.g = g;
        this.stats = stats;
        for(int i = 0; i < 300; i++){
            o.add(new Obsticle(false));
        }
    }
    
    public void tick(){
        for(int i = 0; i < o.size(); i++){
            o.get(i).tick();
            if(o.get(i).getRectangle().x < -150) o.remove(o.get(i));
            if(o.get(i).getRectangle().intersects(p.getRectangle())){
                if(o.get(i).b == false){
                    g.state = 2;
                    g.dead.selection = 1;
                    Sound.play("explosion.wav");
                }
            }
        }
        if(counter == 0){
            o.add(new Obsticle());
            counter = r.nextInt(80)+40;
        }
        o.add(new Obsticle(true));
        o.add(new Obsticle(true));
        counter--;
        p.tick();
        if(counter % 3 == 0){
            score++;
        }
        if(score > this.g.stats.highScore){
            this.g.stats.highScore = score;
        }
    }
    
    public void render(Graphics g){
        g.setColor(new Color(80, 80, 80));
        g.drawLine(0, 300, 1024, 300);
        for(int i = 0; i < o.size(); i++){
            o.get(i).render(g);
        }
        p.render(g);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        g.setColor(Color.yellow);
        g.drawString("SCORE: " + score, 15, 35);
    }
    
    public void jump(){
        if(p.getY() >= 236){
            p.setVY(-18);
            Sound.play("jump.wav");
            g.stats.jumps++;
            p.jumps++;
        }else if(stats.hasJumpDoubleUpgrade == 1){
            if(p.jumps <= 1){
                p.setVY(-55);
                Sound.play("jump.wav");
                g.stats.jumps++;
                p.jumps++;
            }
        }
    }
    
    public int getScore(){
        return score;
    }
    
}
