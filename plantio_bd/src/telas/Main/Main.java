/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Main;

import java.io.File;
import java.text.ParseException;
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
    
    private static Clip clip;
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, InterruptedException, ParseException {
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
        //System.out.println(dao.LavouraDao.getCodigo("Lavourinha", 1.5));
        //System.out.println(dao.PlantaDao.getCodigo("Fumo", "Fumo mais ou menos Bom"));
        //System.out.println(dao.AplicacaoDao.getCodigo("1972-05-14", 17));
        //System.out.println(dao.DefensivoDao.getCodigo("Joaossaa", "Inseticida"));
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
        
        Thread.sleep(2000);
        while(true){
            playMusic();
            Thread.sleep(187000);
        }
    }
    
    public static void playMusic(){
        try {
            File yourFile = new File("music/song2.wav");
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;                                

            stream = AudioSystem.getAudioInputStream(yourFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            Main.clip = clip;
            Main.clip.start();
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-40.0f);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public static void stopMusic(){
        Main.clip.stop();
    }  
}
