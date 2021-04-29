package fr.gilles.gplayer;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author gilles
 *
 */
public class Frame extends javax.swing.JFrame implements java.awt.event.MouseListener {

    private java.awt.Label End;
    private java.awt.Label Now;
    private javax.swing.JProgressBar PlayProgress;
    private Panel PlayView;
    private Actualisation act = new Actualisation();
    private javax.swing.JSlider Volume;

    // End of variables declaration
    public Frame() {
        initComponents();
        this.setMinimumSize(new Dimension(800,600));
        this.setFocusable(true);
        this.requestFocus();
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                requestFocus();
            }
        });
        this.setIconImage(new ImageIcon(getClass().getResource("/Icones/title.png")).getImage());
        this.addKeyListener(new java.awt.event.KeyListener(){

            @Override
            public void keyTyped(KeyEvent key) {
                /*
                System.out.println(key.getSource());
                System.out.println(key.getKeyChar());
                */

                switch(key.getKeyChar()){
                    case ' ' -> setTooglePlay();
                    case 'p'->applyPrev();
                    case 'n' -> applyNext();
                    default -> throw new IllegalStateException("Unexpected value: " + key.getKeyCode());
                }


            }

            @Override
            public void keyPressed(KeyEvent key) {

            }

            @Override
            public void keyReleased(KeyEvent key) {

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        PlayView = new Panel();
        JPanel controlPlayPanel = new JPanel();
        Button play = new Button();
        Button prev = new Button();
        Button next = new Button();
        JPanel progressPanel = new JPanel();
        PlayProgress = new javax.swing.JProgressBar();
        End = new java.awt.Label();
        Now = new java.awt.Label();
        Button resize = new Button();
        Button playList = new Button();
        Button random = new Button();
        Button boucle = new Button();
        JMenu file = new JMenu();
        JMenu video = new JMenu();
        /**
         * Creates new form Frame
         */
        // Variables declaration - do not modify
        JMenu audio = new JMenu();
        JMenu look = new JMenu();
        JMenu settings = new JMenu();

        JLabel jLabel1 = new JLabel();
        jLabel1.setText("volume");

        //Volume
        Volume = new JSlider();
        Volume.setEnabled(false);
        Volume.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                PlayView.setVolume(Volume.getValue()*2);
            }
        });

        //**********************************************
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gplayer");

        PlayView.setMinimumSize(new Dimension(400,300));
        javax.swing.GroupLayout Play_progressLayout = new javax.swing.GroupLayout(PlayView);
        PlayView.setLayout(Play_progressLayout);
        Play_progressLayout.setHorizontalGroup(
                Play_progressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        Play_progressLayout.setVerticalGroup(
                Play_progressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 451, Short.MAX_VALUE)
        );

        play.setLabel("Play");
        play.addMouseListener(this);


        prev.setLabel("Prev");
        prev.addMouseListener(this);
        prev.setMinimumSize(new java.awt.Dimension(37, 23));

        next.setLabel("Next");
        next.addMouseListener(this);
        next.setMinimumSize(new java.awt.Dimension(37, 23));
        next.setPreferredSize(new java.awt.Dimension(37, 23));

        End.setText("--");
        End.setFont(new Font("Dialog",9,9));
        Now.setText("--");
        Now.setFont(new Font("Dialog",9,9));
        resize.setLabel("Resize");
        resize.addMouseListener(this);

        playList.setLabel("PlayList");
        playList.addMouseListener(this);

        random.setLabel("Random");

        boucle.setLabel("Boucle");
        boucle.addMouseListener(this);

        //Progress bar
        PlayProgress.setMinimum(0);
        PlayProgress.setIndeterminate(false);
        PlayProgress.setMaximum(100);
        PlayProgress.setValue(0);
        PlayProgress.setStringPainted(true);
        PlayProgress.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        PlayProgress.addMouseListener(this);


        javax.swing.GroupLayout ProgressPanelLayout = new javax.swing.GroupLayout(progressPanel);
        progressPanel.setLayout(ProgressPanelLayout);
        ProgressPanelLayout.setHorizontalGroup(
                ProgressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ProgressPanelLayout.createSequentialGroup()
                                .addGroup(ProgressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ProgressPanelLayout.createSequentialGroup()
                                                .addComponent(Now, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PlayProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(6, 6, 6)
                                                .addComponent(End, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(ProgressPanelLayout.createSequentialGroup()
                                                .addComponent(resize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(playList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(random, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(boucle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(Volume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        ProgressPanelLayout.setVerticalGroup(
                ProgressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ProgressPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(ProgressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Now, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(End, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PlayProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ProgressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(resize, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                        .addComponent(playList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(random, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(boucle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProgressPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(ProgressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Volume, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );

        javax.swing.GroupLayout ControlPlayPanelLayout = new javax.swing.GroupLayout(controlPlayPanel);
        controlPlayPanel.setLayout(ControlPlayPanelLayout);
        ControlPlayPanelLayout.setHorizontalGroup(
                ControlPlayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ControlPlayPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ControlPlayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(ControlPlayPanelLayout.createSequentialGroup()
                                                .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        ControlPlayPanelLayout.setVerticalGroup(
                ControlPlayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ControlPlayPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(play, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ControlPlayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(prev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(ControlPlayPanelLayout.createSequentialGroup()
                                .addComponent(progressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        //define the menuBar
        setJMenuBar(new JMenuBar());

        //init menu
        file.setText("File");
        JMenuItem open = new JMenuItem("Open Video");
        open.setName("open");
        open.addMouseListener(this);
        file.getPopupMenu().add(open);

        JMenuItem quit = new JMenuItem("Quitter");
        quit.addActionListener((e)->{
            System.exit(0);
        });
        file.getPopupMenu().add(quit);

        video.setText("Video");
        JMenuItem captureImage = new JMenuItem("Capture Picture");
        captureImage.setName("capturePicture");
        captureImage.addMouseListener(this);
        video.getPopupMenu().add(captureImage);

        audio.setText("Audio");
        JMenuItem audioTrack = new JMenuItem("Audio track");
        audioTrack.setName("audiotrack");
        audioTrack.addMouseListener(this);
        audio.getPopupMenu().add(audioTrack);
        audio.getPopupMenu().addSeparator();

        JMenuItem audioincrease = new JMenuItem("Increase audio");
        audioincrease.setName("audioincrease");
        audioincrease.addMouseListener(this);
        audio.getPopupMenu().add(audioincrease);

        JMenuItem audiodecrease = new JMenuItem("Decrease audio");
        audiodecrease.setName("audiodecrease");
        audiodecrease.addMouseListener(this);
        audio.getPopupMenu().add(audiodecrease);

        JMenuItem audiomute = new JMenuItem("Mute ");
        audiomute.setName("mute");
        audiomute.addMouseListener(this);
        audio.getPopupMenu().add(audiomute);

        look.setText("View");
        for (var f : UIManager.getInstalledLookAndFeels()){
            JMenuItem temp = new JMenuItem(f.getClassName());
            temp.setName("Look");
            temp.addMouseListener(this);
            look.getPopupMenu().add(temp);
        }

        settings.setText("Settings");

        //adding Menu
        getJMenuBar().add(file);
        getJMenuBar().add(video);
        getJMenuBar().add(audio);
        getJMenuBar().add(look);
        getJMenuBar().add(settings);
        add(PlayView.getVideoSurface(),BorderLayout.CENTER);
        add(controlPlayPanel,BorderLayout.SOUTH);
        pack();
    }// </editor-fold>


    /**
     * Action when play button click
     */
    private void setTooglePlay(){
        if(!PlayView.isLoaded()){
            openVideoSelectDialog();
        }else if(PlayView.isDisplaying()){
            PlayView.pause();
        }else if(PlayView.isLoaded() && !PlayView.isDisplaying()){
            PlayView.playVideo();
            act = new Actualisation();
            act.start();
        }
    }

    /**
     *
     * @param s string openFile
     */
    public void openFile(String s){
        if(PlayView.setFilename(s)){
            this.setTitle(s.substring(s.lastIndexOf(".")+1));
            initLecture();
        }
    }

    private void openVideoSelectDialog(){
        javax.swing.JFileChooser choose = new javax.swing.JFileChooser() ;
        SwingUtilities.updateComponentTreeUI(choose);
        int returnval = choose.showOpenDialog(this);
        if(returnval == JFileChooser.APPROVE_OPTION){
            if(choose.getSelectedFile().isFile() && choose.getSelectedFile().canRead()){
                openFile(choose.getSelectedFile().getAbsolutePath());
            }else{
                javax.swing.JOptionPane.showMessageDialog(this,"Cannot read this File");
            }
        }
    }
    /** Change title **/
    private void changeTitleName(){
    this.setTitle(PlayView.getFilename());
    }
    /** Return true if video is playing **/
    public boolean isplaying(){
        return PlayView.isDisplaying();
    }

    /**
     * Apply Next
     */
    private void applyNext(){
        PlayView.applyNext();
        changeTitleName();
    }

    /**
     * Prev in lecture
     */
    private void applyPrev(){
        PlayView.applyPrev();
        changeTitleName();
    }

    /**
     *Init Lecture component progress
     */
    private void initLecture(){
        this.End.setText(PlayView.getVideoDuration());
        Volume.setEnabled(true);
        actualiser();
        act.start();
    }

    /**Actualise video progress info **/
    public void actualiser(){
        this.Now.setText(String.valueOf(PlayView.getNow()));
        this.End.setText(PlayView.getVideoDuration());
        PlayProgress.setValue((int)PlayView.progress());
    }

    /**
     *Reset component after lecture finish
     */
    private void reset(){
        Now.setText("--");
        Volume.setEnabled(false);
        try {
            act.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Events

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getSource());
        if (e.getSource().getClass().getName().equalsIgnoreCase("java.awt.Button"))
        switch(( (java.awt.Button)e.getSource()).getLabel()){
            case "Play"->{
                setTooglePlay();
            }
            case "Prev"->{
                applyPrev();
            }
            case "Next"->{
                applyNext();
            }
        }
        else if (e.getSource().getClass().getName().equalsIgnoreCase("javax.swing.JProgressBar")){
            JProgressBar tmp = ((JProgressBar)e.getSource());
            PlayView.gotoPercent((float) (e.getPoint().x*1.0/tmp.getWidth()));
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().getClass().getName().equalsIgnoreCase("javax.swing.JMenuItem"))
        switch (((JMenuItem)e.getSource()).getName()){
            case "open"->{
                openVideoSelectDialog();
            }
            case "Look"->{

            }
        }
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






}
