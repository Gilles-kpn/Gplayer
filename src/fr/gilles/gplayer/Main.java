package fr.gilles.gplayer;


import javax.swing.*;

public class Main {
    public static  Frame f = new Frame();
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            javax.swing.UIManager.installLookAndFeel("SeaGlass", "com.seaglaslookandfeel.SeaGlassLookAndFeel");
            for(javax.swing.UIManager.LookAndFeelInfo f :javax.swing.UIManager.getInstalledLookAndFeels()){
                System.out.println("******************\nName: "+f.getName()+"\nClass: "+f.getClassName()+"\nGetClass: "+f.getClass());
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                f.setVisible(true);
            }
        });

    }
}
