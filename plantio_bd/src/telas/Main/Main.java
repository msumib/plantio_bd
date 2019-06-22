/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import splash.Splash;

/**
 *
 * @author itzfeltrin
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
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
        
    }
}
