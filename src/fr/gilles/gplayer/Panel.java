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
    private boolean isplaying = false, loaded = false;
    private ArrayList<String> cache = new ArrayList<String>();


    private static final String[] ext = {"mp4","mkv","avi"};
    public Panel(){
        mediaPlayerComponent  = new EmbeddedMediaPlayerComponent(){
            public void playing(MediaPlayer mediaPlayer) {
                super.playing(mediaPlayer);
                Main.f.Actualiser();
            }
            public void finished(MediaPlayer mediaPlayer) {
                isplaying =false;
                loaded = false;

            }
            public void error(MediaPlayer mediaPlayer) {
                JOptionPane.showMessageDialog(this,"Failed to load Media");
            }

        };
        mediaPlayerComponent.setBackground(Color.BLACK);

        this.setLayout(new BorderLayout());
        this.add(mediaPlayerComponent);


    }
    public void paintComponent(Graphics g){
        mediaPlayerComponent.setSize(new Dimension(this.getWidth(),this.getHeight()));
        mediaPlayerComponent.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
        mediaPlayerComponent.videoSurfaceComponent().setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
        mediaPlayerComponent.videoSurfaceComponent().setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));

    }

    private void imginfolder() {
        String d = this.filename.substring(0,this.filename.lastIndexOf("/"));
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


    public boolean setFilename(String s)
    {
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
        imginfolder();
        repaint();
    }
    public void playVideo(){
        mediaPlayerComponent.mediaPlayer().controls().play();

        isplaying = true;
    }

    public void pause(){
        mediaPlayerComponent.mediaPlayer().controls().pause();
        isplaying = false;
    }
    public boolean isIsplaying(){
        return  this.isplaying;
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
        if(cache.indexOf(filename) == cache.size()) {
            this.filename = cache.get(0);
        }else {
            this.filename =cache.get(cache.indexOf(filename)+1);
        }
        setFilename(filename);

    }
    public void applyPrev(){
        if(cache.indexOf(filename) == 0) {
            this.filename = cache.get(cache.size()-1);
        }else {
            this.filename =cache.get(cache.indexOf(filename)-1);
        }
        setFilename(filename);
    }

}
