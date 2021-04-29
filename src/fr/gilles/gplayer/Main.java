package fr.gilles.gplayer;


import javax.swing.*;

public class Main {
    public static  Frame f;
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        f = new Frame();
        if (args.length > 0) f.openFile(args[0]);
        f.setVisible(true);
    }
}
