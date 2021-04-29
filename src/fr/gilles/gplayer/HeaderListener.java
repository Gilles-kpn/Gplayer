package fr.gilles.gplayer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HeaderListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        switch (((javax.swing.JMenu) mouseEvent.getSource()).getName()) {
            case "file" -> {
                FileAction();
            }
            case "video" -> {
                VideoAction();
            }
            case "audio" -> {
                AudioAction();
            }
            case "look" -> {
                LookAction();
            }
            case "settings" -> {
                SettingsAction();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
    private void FileAction(){

    }
    private void VideoAction(){

    }
    private void AudioAction(){

    }
    private void LookAction(){

    }
    private void  SettingsAction(){

    }


}
