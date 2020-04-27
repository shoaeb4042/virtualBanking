package Shoaeb.user;

import com.thehowtotutorial.splashscreen.JSplash;
import java.awt.Color;
import java.io.File;
import java.net.URL;
import javax.swing.JOptionPane;
public class Splash {

    public static void main(String args[]) throws Exception {
      Splash();
      
     new Login().setVisible(true);
      
      
    }

    public static void Splash() throws InterruptedException {
        JSplash s;
        URL u = Splash.class.getResource("/newbg.png");
        s = new JSplash(u, true,
                true, false, null, null, Color.RED, Color.decode("#52a8eb"));

        s.splashOn();
        for (int i = 1; i <= 100; i++) {
            s.setProgress(i, i + "% LOADING...");
            Thread.sleep(40);
           
            }
            
        
       // Thread.sleep(1000);
        s.splashOff();
    }
}
