package com.gameshopcorp.gameshopengine.niftygui;
/**
 *
 * @author gameshopengine
 */
import com.jme3.app.SimpleApplication;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

/**
 * A ScreenController for the "start" screen defined in
 * "Interfaces/Nifty/HelloJme.xml", which is used in the TestAppStates and
 * TestNiftyGui applications.
 */
public class MyScreenController implements ScreenController {

    final private SimpleApplication application;

    public Screen screen;
    public Nifty nifty;
    /**
     * Instantiate a ScreenController for the specified Application.
     *
     * @param app the Application
     */
    public MyScreenController(SimpleApplication app) {
        this.application = app;
    }

    /**
     * Nifty invokes this method when the screen gets enabled for the first
     * time.
     *
     * @param nifty (not null)
     * @param screen (not null)
     */
    @Override
    public void bind(Nifty nifty, Screen screen) {
        System.out.println("bind(" + screen.getScreenId() + ")");
        this.nifty = nifty;
        this.screen = screen;
    }

    /**
     * Nifty invokes this method each time the screen starts up.
     */
    @Override
    public void onStartScreen() {
        System.out.println("onStartScreen");
    }

    /**
     * Nifty invokes this method each time the screen shuts down.
     */
    @Override
    public void onEndScreen() {
        System.out.println("onEndScreen");
    }

    /**
     * Stop the Application. Nifty invokes this method (via reflection) after
     * the user clicks on the flashing orange panel.
     */
    public void quit() {
        System.out.println("Quit");
        application.stop();
    }

    public void focus(){

        System.out.println("removed");
        //App.getInstance().app.getGuiViewPort().removeProcessor(App.getInstance().app.niftyDisplay);
//        Element myElement = screen.findElementById("panel-empty");
//        if (myElement != null) {
//            myElement.setFocus();
//        }

    }
}
