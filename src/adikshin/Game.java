package adikshin;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.JSONFunctions;


public class Game extends Canvas implements KeyListener {
    
    Window w;
    BufferedImage i;
    int state = 0;
    TitleScreen title;
    Level level;
    DeadScreen dead;
    CreditsScreen credits;
    PausedScreen paused;
    GameStats stats;
    StoreScreen store;
    StatsScreen statsScreen;
    int FPS, TPS, counter;
    
    public Game(){
        title = new TitleScreen(this);
        dead = new DeadScreen(this);
        credits = new CreditsScreen();
        paused = new PausedScreen();
        stats = new GameStats();
        stats.save();
        store = new StoreScreen(stats);
        statsScreen = new StatsScreen(stats);
        level = new Level(this, stats);
        addKeyListener(this);
        requestFocus();
        i = new BufferedImage(1024, 576, BufferedImage.TYPE_INT_RGB);
        w = new Window(this);
        counter = 0;
        long lastTime = System.nanoTime();
       final double amountOfTicks = 60.0;
       double ns = 1000000000 / amountOfTicks;
       int delta = 0;
       int updates = 0;
       int frames = 0;
       long timer = System.currentTimeMillis();
       long now;
       while(true) {
           tick();
           render();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
       }
    }
    
    public void tick(){
        if(state == 0){
            title.tick();
        }else if(state == 1){
            level.tick();
        }else if(state == 2){
            dead.tick();
        }else if(state == 3){
            credits.tick();
        }else if(state == 4){
            paused.tick();
        }else if(state == 5){
            store.tick();
        }else if(state == 6){
            statsScreen.tick();
        }
        counter++;
        if(counter % 60 == 0){
            stats.time++;
        }
        if(counter >= 240){
            counter = 0;
            stats.save();
        }
    }
    
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g0 = bs.getDrawGraphics();
        Graphics g = i.getGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 1024, 576);
        
        if(state == 0){
            title.render(g);
        }else if(state == 1){
            level.render(g);
        }else if(state == 2){
            dead.render(g);
        }else if(state == 3){
            credits.render(g);
        }else if(state == 4){
            paused.render(g);
        }else if(state == 5){
            store.render(g);
        }else if(state == 6){
            statsScreen.render(g);
        }
        
        g0.drawImage(i, 0, 0, w.getWindow().getWidth(), w.getWindow().getHeight(), null);
        g0.dispose();
        g.dispose();;
        bs.show();
    }
    
    public static void main(String[] args){
        new Game();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(state == 0){
            if(ke.getKeyCode() == KeyEvent.VK_UP){
                title.setSelection(title.getSelection() - 1);
                if(title.getSelection() < 1){
                    title.setSelection(5);
                }
                Sound.play("move.wav");
            }
            if(ke.getKeyCode() == KeyEvent.VK_DOWN){
                title.setSelection(title.getSelection() + 1);
                if(title.getSelection() > 5){
                    title.setSelection(1);
                }
                Sound.play("move.wav");
            }
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                if(title.getSelection() == 1){
                    state = 1;
                }
                if(title.getSelection() == 4){
                    state = 3;
                }
                if(title.getSelection() == 5){
                    stats.gameQuits++;
                    stats.save();
                    System.exit(0);
                }
                if(title.getSelection() == 2){
                    state = 5;
                }
                if(title.getSelection() == 3){
                    state = 6;
                }
                Sound.play("pick.wav");
            }
        }else if(state == 3){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                state = 0;
                Sound.play("pick.wav");
            }
        }else if(state == 1){
            if(ke.getKeyCode()==KeyEvent.VK_ESCAPE){
                state = 4;
                Sound.play("move.wav");
            }
            if(ke.getKeyCode()==KeyEvent.VK_SPACE || ke.getKeyCode()==KeyEvent.VK_W || ke.getKeyCode() == KeyEvent.VK_UP){
                level.jump();
            }
        }else if(state == 4){
            if(ke.getKeyCode() == KeyEvent.VK_UP){
                paused.setSelection(paused.getSelection() - 1);
                if(paused.getSelection() < 1){
                    paused.setSelection(2);
                }
                Sound.play("move.wav");
            }
            if(ke.getKeyCode() == KeyEvent.VK_DOWN){
                paused.setSelection(paused.getSelection() + 1);
                if(paused.getSelection() > 2){
                    paused.setSelection(1);
                }
                Sound.play("move.wav");
            }
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                if(paused.getSelection() == 1){
                    state = 1;
                }
                if(paused.getSelection() == 2){
                    reset(0);
                }
                Sound.play("pick.wav");
            }
            if(ke.getKeyCode()==KeyEvent.VK_ESCAPE){
                state = 1;
                Sound.play("move.wav");
            }
        }else if(state == 2){
            if(ke.getKeyCode() == KeyEvent.VK_UP){
                dead.setSelection(dead.getSelection() - 1);
                if(dead.getSelection() < 1){
                    dead.setSelection(1);
                }
                Sound.play("move.wav");
            }
            if(ke.getKeyCode() == KeyEvent.VK_DOWN){
                dead.setSelection(dead.getSelection() + 1);
                if(dead.getSelection() > 2){
                    dead.setSelection(1);
                }
                Sound.play("move.wav");
            }
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                if(dead.getSelection() == 1){
                    stats.gamesPlayed++;
                    reset(1);
                }
                if(dead.getSelection() == 2){
                    reset(0);
                }
                Sound.play("pick.wav");
            }
        }else if(state == 6){
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                state = 0;
                Sound.play("pick.wav");
            }
        }else if(state == 5){
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                switch (store.choice){
                    case 1:
                        if(stats.jumps >= 200){
                            if(stats.hasJumpHeightUpgrade == 0){
                                Sound.play("powerup.wav");
                                stats.jumps-=200;
                                stats.hasJumpHeightUpgrade = 1;
                            }
                        }
                        break;
                    case 2:
                        if(stats.jumps >= 350){
                            if(stats.hasJumpDoubleUpgrade == 0){
                                Sound.play("powerup.wav");
                                stats.jumps-=350;
                                stats.hasJumpDoubleUpgrade = 1;
                            }
                        }
                        break;
                    case 3:
                        if(stats.jumps >= 1400){
                            if(stats.hasSmilyUpgrade == 0){
                                Sound.play("powerup.wav");
                                stats.jumps-=1400;
                                stats.hasSmilyUpgrade = 1;
                            }
                        }
                        break;
                    case 4:
                        state = 0;
                        Sound.play("pick.wav");
                        break;
                    default:
                        break;
                }
            }
            if(ke.getKeyCode() == KeyEvent.VK_UP){
                Sound.play("move.wav");
                store.choice--;
                if(store.choice < 1) store.choice = 4;
            }
            if(ke.getKeyCode() == KeyEvent.VK_DOWN){
                Sound.play("move.wav");
                store.choice++;
                if(store.choice > 4) store.choice = 1;
            } 
        }
    }
    
    public void reset(int i){
        level.o.clear();
        level.score = 0;
        state = i;
        level.p.y = 0;
        level.p.vy = 0;
        for(int ii = 0; ii < 300; ii++){
            level.o.add(new Obsticle(false));
        }
    }
    
    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
    public int getState(){
        return state;
    }
    
}
