package fr.gilles.gplayer;

public class Actualisation extends Thread {

    @Override
    public void run() {
        while(Main.f.isplaying()){
            try {
                Thread.sleep(1000);
                Main.f.actualiser();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
