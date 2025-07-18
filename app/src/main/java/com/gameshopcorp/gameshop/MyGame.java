package com.gameshopcorp.gameshop;

import com.gameshopcorp.gameshop.app.App;
import com.gameshopcorp.gameshop.character.basic.Player;
import com.gameshopcorp.gameshop.graphics.ATMS;
import com.gameshopcorp.gameshop.niftygui.MyScreenController;
import com.gameshopcorp.gameshop.niftygui.MyScreenController;
import com.gameshopcorp.gameshop.supermesh.SuperCube;
import com.gameshopcorp.gameshop.supermesh.SuperSquare;
import com.jme3.app.SimpleApplication;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.texture.FrameBuffer;
import com.jme3.texture.Image;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture2D;
import com.jme3.renderer.Camera;

import de.lessvoid.nifty.Nifty;

public final class MyGame extends SimpleApplication {


    private Nifty nifty;


    @Override
    public void simpleInitApp() {
        App.getInstance().app = this;

        flyCam.setEnabled(true);

        getViewPort().setBackgroundColor(ColorRGBA.White);

        ATMS atms = new ATMS("Rune", 256, 256);

        Texture2D tex = (Texture2D) assetManager.loadTexture("Textures/Rune.jpeg");


        SuperSquare top = new SuperSquare("Display", atms, new Node("UI"), 7, new Vector3f(-3,3,-3), new Vector3f(3,3,-3), new Vector3f(-3,3,3), new Vector3f(3,3,3), tex );

        SuperSquare bottom = new SuperSquare("Display", atms, new Node("UI"), 7, new Vector3f(-3,-3,-3), new Vector3f(3,-3,-3), new Vector3f(-3,-3,3), new Vector3f(3,-3,3), tex );

        SuperSquare front = new SuperSquare("Display", atms, new Node("UI"), 7, new Vector3f(-3,-3,3), new Vector3f(3,-3,3), new Vector3f(-3,3,3), new Vector3f(3,3,3), tex );
        //front.node.scale(-1,1,1);
        SuperSquare back = new SuperSquare("Display", atms, new Node("UI"), 7, new Vector3f(-3,-3,-3), new Vector3f(3,-3,-3), new Vector3f(-3,3,-3), new Vector3f(3,3,-3), tex );

        SuperSquare left = new SuperSquare("Display", atms, new Node("UI"), 7, new Vector3f(-3,-3,-3), new Vector3f(-3,-3,3), new Vector3f(-3,3,-3), new Vector3f(-3,3,3), tex );

        SuperSquare right = new SuperSquare("Display", atms, new Node("UI"), 7, new Vector3f(3,-3,-3), new Vector3f(3,-3,3), new Vector3f(3,3,-3), new Vector3f(3,3,3), tex );

        SuperCube superCube = new SuperCube(top, bottom, front, back, left, right);


        //Player player = new Player();

        //ViewPort niftyView = renderManager.createPreView("NiftyView", new Camera(1024, 768));

//        NiftyJmeDisplay niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(
//                assetManager,
//                inputManager,
//                audioRenderer,
//                guiViewPort);
//        nifty = niftyDisplay.getNifty();
//        MyScreenController startScreen = new MyScreenController(this);
//        nifty.fromXml("Interface/Nifty/HelloGameShop.xml", "start", startScreen);
//
//        this.guiViewPort.addProcessor(niftyDisplay);
//        /** Prepare a framebuffer for the texture niftytex */
//        niftyView.addProcessor(niftyDisplay);
//        Texture2D depthTex = new Texture2D(1024, 768, Image.Format.Depth);
//        FrameBuffer fb = new FrameBuffer(1024, 768, 1);
//        fb.setDepthTarget(FrameBuffer.FrameBufferTarget.newTarget(depthTex));
//
//        //fb.setDepthBuffer(Format.Depth);
//        //Texture2D niftytex = new Texture2D(1024, 768, Format.RGB8);
//
//        ATMS atms = new ATMS("Nifty", 1024, 768);
//        atms.layer.drawCircle(0,0,2000,new Vector4f(0,0,0,255));
//        Texture2D tex = new Texture2D(atms.makeATMS());
//
//        tex.setMinFilter(Texture.MinFilter.Trilinear);
//        tex.setMagFilter(Texture.MagFilter.Bilinear);
//
//        fb.addColorTarget(FrameBuffer.FrameBufferTarget.newTarget(tex));
//
//
//        niftyView.setClearFlags(true, true, true);
//        niftyView.setOutputFrameBuffer(fb);
//
//        SuperSquare superSquare = new SuperSquare("Display", atms, new Node("UI"), 4, new Vector3f(-3,-3,0), new Vector3f(3,-3,0), new Vector3f(-3,3,0), new Vector3f(3,3,0), tex );
//        //superSquare.node.rotate(0,180,75);
//        this.rootNode.attachChild(superSquare.node);


        // disable the fly cam
      //  flyCam.setEnabled(false);
        //flyCam.setDragToRotate(true);
        inputManager.setCursorVisible(true);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }


}
