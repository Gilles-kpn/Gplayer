package fr.gilles.gplayer;

import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Panel extends JPanel {
    private String filename ;
    private  EmbeddedMediaPlayerComponent mediaPlayerComponent;
    private boolean Displaying = false, loaded = false;
    private ArrayList<String> cache = new ArrayList<String>();
    private static final String[] ext = {"mp4","mkv","avi"};
    public Panel(){
        mediaPlayerComponent  = new EmbeddedMediaPlayerComponent(){
            public void playing(MediaPlayer mediaPlayer) {
                super.playing(mediaPlayer);
                Main.f.actualiser();
            }
            public void finished(MediaPlayer mediaPlayer) {
                Displaying =false;
                loaded = false;

            }
            public void error(MediaPlayer mediaPlayer) {
                JOptionPane.showMessageDialog(this,"Failed to load Media");
            }

        };
        mediaPlayerComponent.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout());
        this.add(mediaPlayerComponent,BorderLayout.CENTER);
    }
    public Component getVideoSurface(){
        return this.mediaPlayerComponent.videoSurfaceComponent();
    }
    private void videoInFolder() {
        String d = this.filename.substring(0,this.filename.lastIndexOf(File.separator));
        File f = new File(d);
        if(f.isDirectory()) {
            for(File fi : Objects.requireNonNull(f.listFiles())) {
                for(String str : ext) {
                    if(fi.getAbsolutePath().substring(fi.getAbsolutePath().lastIndexOf(".")+1).equals(str)) {
                        cache.add(fi.getAbsolutePath());
                    }
                }

            }
        }
    }
    public boolean setFilename(String s) {
        //verification de l'extension
        boolean find = false;
        for(String str : ext ){
            if(s.substring(s.lastIndexOf(".")+1).equalsIgnoreCase(str)){
                this.filename = s;
                uploadVideoFile();
                playVideo();
                loaded = true;
                find = true;
                break;

            }
        }
        if(!find){
           //print an error
            JOptionPane.showMessageDialog(this,"Error invalid file");
            return false;
        }else{
            return true;
        }

    }
    public String getFilename(){
        return this.filename;
    }
    private void uploadVideoFile(){
        mediaPlayerComponent.mediaPlayer().media().startPaused(this.filename);
        videoInFolder();
        repaint();
    }
    public void playVideo(){
        mediaPlayerComponent.mediaPlayer().controls().play();
        Displaying = true;
    }
    public void pause(){
        mediaPlayerComponent.mediaPlayer().controls().pause();
        Displaying = false;
    }
    public boolean isDisplaying(){
        return  this.Displaying;
    }
    public boolean isLoaded(){
        return this.loaded;
    }
    public String getVideoDuration(){
        int h =(int) mediaPlayerComponent.mediaPlayer().status().length()/3600000;
        int m = (int) ((mediaPlayerComponent.mediaPlayer().status().length()%3600000)/60000);
        int sec = (int) ((mediaPlayerComponent.mediaPlayer().status().length()%3600000)%60000)/1000;
        return h+"h"+m+"min"+sec+"s";
    }
    public void accelerer(){
        mediaPlayerComponent.mediaPlayer().controls().skipTime(15000);
    }
    public void decelerer(){
        mediaPlayerComponent.mediaPlayer().controls().setPosition(mediaPlayerComponent.mediaPlayer().status().time() - 15000);
    }
    public String getNow(){
        int h =(int) mediaPlayerComponent.mediaPlayer().status().time()/3600000;
        int m = (int) ((mediaPlayerComponent.mediaPlayer().status().time()%3600000)/60000);
        int sec = (int) ((mediaPlayerComponent.mediaPlayer().status().time()%3600000)%60000)/1000;
        return h+"h"+m+"min"+sec+"s";
    }
    public float progress(){

        return (float)(mediaPlayerComponent.mediaPlayer().status().time()*100/mediaPlayerComponent.mediaPlayer().status().length());

    }
    public void setVolume(int a){
        mediaPlayerComponent.mediaPlayer().audio().setVolume(a);
    }
    public void applyNext(){
        if(isLoaded()){
            if(cache.indexOf(filename) == cache.size()) {
                this.filename = cache.get(0);
            }else {
                this.filename =cache.get(cache.indexOf(filename)+1);
            }
            setFilename(filename);
        }


    }
    public void applyPrev(){
        if (isLoaded()) {
            if(cache.indexOf(filename) == 0) {
                this.filename = cache.get(cache.size()-1);
            }else {
                this.filename =cache.get(cache.indexOf(filename)-1);
            }
            setFilename(filename);
        }

    }
    public void gotoPercent(float percent){
        if (isLoaded()){
            mediaPlayerComponent.mediaPlayer().controls().setPosition(percent);
        }

    }
}
