package adikshin;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;


public class Window {
    
    JFrame f;
    
    public Window(Game g){
        f = new JFrame("ADIKSHIN");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setMinimumSize(new Dimension(1024, 576));
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setLocationRelativeTo(null);
        f.add(g);
       // too hacky right now... 
       // GraphicsDevice device = f.getGraphicsConfiguration().getDevice();
       // device.setFullScreenWindow(f);
        f.setVisible(true);
    }
    
    public JFrame getWindow(){
        return f;
    }
    
}
