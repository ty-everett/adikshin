package adikshin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class GameStats {
    
    int highScore,
            jumps,
            gamesPlayed,
            gameQuits,
            hasJumpHeightUpgrade,
            hasJumpDoubleUpgrade,
            time,
            hasSmilyUpgrade;
    
    public GameStats(){
        load();
    }
    
    public void load(){
        try{
            FileReader fr = new FileReader("adikshin.save");
            BufferedReader r = new BufferedReader(fr);
            highScore = Integer.parseInt(r.readLine());
            jumps = Integer.parseInt(r.readLine());
            gamesPlayed = Integer.parseInt(r.readLine());
            gameQuits = Integer.parseInt(r.readLine());
            hasJumpDoubleUpgrade = Integer.parseInt(r.readLine());
            hasJumpHeightUpgrade = Integer.parseInt(r.readLine());
            hasSmilyUpgrade = Integer.parseInt(r.readLine());
            time = Integer.parseInt(r.readLine());
            r.close();
        }catch(Exception e){
            highScore = 0;
            jumps = 0;
            gamesPlayed = 0;
            gameQuits = 0;
            hasJumpDoubleUpgrade = 0;
            hasJumpHeightUpgrade = 0;
            hasSmilyUpgrade = 0;
            time = 0;
            save();
        }
    }
    
    public void save(){
        try {
            FileWriter fw = new FileWriter("adikshin.save", false);
            BufferedWriter w = new BufferedWriter(fw);   
            w.write(String.valueOf(highScore));
            w.newLine();
            w.write(String.valueOf(jumps));
            w.newLine();
            w.write(String.valueOf(gamesPlayed));
            w.newLine();
            w.write(String.valueOf(gameQuits));
            w.newLine();
            w.write(String.valueOf(hasJumpDoubleUpgrade));
            w.newLine();
            w.write(String.valueOf(hasJumpHeightUpgrade));
            w.newLine();
            w.write(String.valueOf(hasSmilyUpgrade));
            w.newLine();
            w.write(String.valueOf(time));
            w.newLine();
            w.newLine();
            w.write("A little note to all you Tampering Monkeys from the game developer:");
            w.newLine();
            w.write("All you're gonna do is ruin the game by changing anything here...");
            w.newLine();
            w.write("but if you lose all your progress, not my problem lol. Happy Hacking!");
            w.close();
        } catch (IOException ex) {
        }
    }
    
}
