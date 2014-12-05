package InputGameLoop;

import Screens.GameLoop;
import Tools.KeyboardActions;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;

import static Graphics.EntityTexture.*;
import static Graphics.EntityTexture.JUMP;

/**
 * Created by Corentin on 05/12/2014.
 */
public class InputMananger extends Thread {

    private RenderWindow App;

    public InputMananger(RenderWindow App){
        this.App = App;
    }

    public void run() {
       GameLoop.returnValue =  eventManager(App);
        //System.out.println("ret="+GameLoop.returnValue);
    }

    public int eventManager(RenderWindow App) {
        //Verifying events
        for (Event event : App.pollEvents()) {
            // Window closed
            if (event.type == Event.Type.CLOSED) {

                return GameLoop.retourne(GameLoop.exit);
            }
            int returnValueKeyboard = keyboardManager(event, App);
            if (returnValueKeyboard <= 50)
                return returnValueKeyboard;
        }

        //si on ne quitte pa s cet écran
        return 100;
    }


    public int keyboardManager(Event event, RenderWindow App) {

        //Sprite mario =  (Sprite)screenObject.get(screenObject.size()-1);
        //Key pressed

        //TODO fichier de config xml pour binder les touches du clavier

        if (event.type == Event.Type.KEY_PRESSED) {
            event.asKeyEvent();

            if (KeyboardActions.quitKeyPressed()) {
               return GameLoop.retourne(GameLoop.mainMenu);
            }

            if ((KeyboardActions.isAttacking())) {
                GameLoop.p1.PLayerShoot();
            }
            else if (KeyboardActions.isJumping()) {
                GameLoop.p1.PLayerJump();
            }
            if ((KeyboardActions.isMovingLeft())) {
                System.out.println("test gauche");
                GameLoop.p1.PLayerWalk(LEFT);
            }
            else if ((KeyboardActions.isMovingRight())) {
                GameLoop.p1.PLayerWalk(RIGHT);
            }

            if (Keyboard.isKeyPressed(Keyboard.Key.RETURN)) {
            }
        }

        else if(event.type == Event.Type.KEY_RELEASED) {
            org.jsfml.window.event.KeyEvent keyev =  event.asKeyEvent();// == Keyboard.Key.SPACE;


            if ( (keyev.key == Keyboard.Key.LEFT || keyev.key == Keyboard.Key.RIGHT) ) {
                // System.out.println("-------------->jey left relachée");
                GameLoop.p1.PlayerIdle();
            }


        }
        //si on ne quitte pas cet écran
        return 100;
    }


}