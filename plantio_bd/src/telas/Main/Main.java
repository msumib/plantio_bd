/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Main;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import splash.Splash;

/**
 *
 * @author itzfeltrin
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, InterruptedException {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to cross-platform
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                // not worth my time
            }
        }
        Splash sp = new Splash();
        sp.setLocationRelativeTo(null);
        sp.setVisible(true);
        Home h = new Home();        
        try {
            for(int i = 0; i <= 100; i++){
                Thread.sleep(30);
                sp.poeTexto(Integer.toString(i));
                sp.poeValor(i);
                if(i == 100){
                    sp.setVisible(false);
                    h.setVisible(true);
                }
            }
        }        
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        while(true){
            playMusic("music\\\\song2.wav");
            Thread.sleep(187000);
        }
        
    }
    
    public static void playMusic(String filepath){
        try {
            File yourFile = new File(filepath);
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;                                

            stream = AudioSystem.getAudioInputStream(yourFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-50.0f);
            clip.start();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
