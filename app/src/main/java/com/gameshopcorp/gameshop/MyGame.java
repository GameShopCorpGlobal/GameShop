package com.gameshopcorp.gameshop;

import com.gameshopcorp.gameshop.app.App;
import com.gameshopcorp.gameshop.character.basic.Player;
import com.gameshopcorp.gameshop.niftygui.StartScreenController;
import com.jme3.app.SimpleApplication;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector4f;
import com.jme3.niftygui.NiftyJmeDisplay;

import de.lessvoid.nifty.Nifty;

public final class MyGame extends SimpleApplication {


    private Nifty nifty;


    @Override
    public void simpleInitApp() {
        App.getInstance().app = this;

        flyCam.setEnabled(true);

        getViewPort().setBackgroundColor(ColorRGBA.White);
        Player player = new Player();
        NiftyJmeDisplay niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(
                assetManager,
                inputManager,
                audioRenderer,
                guiViewPort);
        nifty = niftyDisplay.getNifty();
        StartScreenController startScreen = new StartScreenController(this);
        nifty.fromXml("Interface/Nifty/HelloGameShop.xml", "start", startScreen);

        // attach the nifty display to the gui view port as a processor
        guiViewPort.addProcessor(niftyDisplay);

        // disable the fly cam
        flyCam.setEnabled(false);
        flyCam.setDragToRotate(true);
        inputManager.setCursorVisible(true);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }


}
