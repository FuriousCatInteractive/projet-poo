package Screens;

/**
 * Created by Corentin on 07/12/2014.
 */
public class MusicLoader extends Thread {

    /**
     * thread en parrélèle qui charge les musiques grosses
     * (qq mégas)
     */
    public void run(){
        System.out.println("début loadmusic");
        cScreen.musicBackground = cScreen.loadMusic("res/sound/theme-ssb.ogg" );
        cScreen.musicStage1=cScreen.loadMusic("res/sound/tower.ogg");
        cScreen.gameOver = cScreen.loadMusic("res/sound/Wha-Wha.ogg");
        cScreen.victory = cScreen.loadMusic("res/sound/FF7_victory.ogg");
        System.out.println("fin loadmusic");
    }
}
