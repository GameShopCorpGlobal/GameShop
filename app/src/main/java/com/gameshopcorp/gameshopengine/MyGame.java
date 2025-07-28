package com.gameshopcorp.gameshopengine;

import com.gameshopcorp.gameshopengine.app.App;
import com.gameshopcorp.gameshopengine.app.AppSuperMesh;
import com.gameshopcorp.gameshopengine.gameshopui.Omni;
import com.gameshopcorp.gameshopengine.gameshopui.Screen;
import com.gameshopcorp.gameshopengine.graphics.ATMS;
import com.gameshopcorp.gameshopengine.supermesh.SuperCube;
import com.gameshopcorp.gameshopengine.supermesh.SuperSquare;
import com.gameshopcorp.gameshopengine.ui.Selector;
import com.jme3.app.SimpleApplication;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.scene.Node;
import com.jme3.texture.Texture2D;

import java.util.ArrayList;

import de.lessvoid.nifty.Nifty;

public final class MyGame extends SimpleApplication {


    public Nifty nifty;
    public NiftyJmeDisplay niftyDisplay;
    public Screen uiScreen;

    @Override
    public void simpleInitApp() {
       // this.setDisplayFps(false);
       // this.setDisplayStatView(false);
        App.getInstance().app = this;

        flyCam.setEnabled(true);

        getViewPort().setBackgroundColor(ColorRGBA.White);


        ATMS atms = new ATMS("BlueBox", 256, 256);
        atms.layer.drawCircle(128,128,256, new Vector4f(0,0,255,128));
        Texture2D tex = (Texture2D) assetManager.loadTexture("Textures/Rune.jpeg");


        SuperSquare top = new SuperSquare("Display", atms, new Node("UI"), 7, new Vector3f(-3,3,-3), new Vector3f(3,3,-3), new Vector3f(-3,3,3), new Vector3f(3,3,3), null );

        SuperSquare bottom = new SuperSquare("Display", atms, new Node("UI"), 7, new Vector3f(-3,-3,-3), new Vector3f(3,-3,-3), new Vector3f(-3,-3,3), new Vector3f(3,-3,3), null );

        SuperSquare front = new SuperSquare("Display", atms, new Node("UI"), 7, new Vector3f(-3,-3,3), new Vector3f(3,-3,3), new Vector3f(-3,3,3), new Vector3f(3,3,3), null );

        SuperSquare back = new SuperSquare("Display", atms, new Node("UI"), 7, new Vector3f(-3,-3,-3), new Vector3f(3,-3,-3), new Vector3f(-3,3,-3), new Vector3f(3,3,-3), null );

        SuperSquare left = new SuperSquare("Display", atms, new Node("UI"), 7, new Vector3f(-3,-3,-3), new Vector3f(-3,-3,3), new Vector3f(-3,3,-3), new Vector3f(-3,3,3), null );

        SuperSquare right = new SuperSquare("Display", atms, new Node("UI"), 7, new Vector3f(3,-3,-3), new Vector3f(3,-3,3), new Vector3f(3,3,-3), new Vector3f(3,3,3), null );

        SuperCube superCube = new SuperCube(top, bottom, front, back, left, right);

        AppSuperMesh.getInstance().superMeshes.put("SuperCube", superCube.superMesh);


        Selector selector = new Selector();
        //selector.populateSelectors();
        //Node uiNode = new Node("UI Node");
      //  SuperSquare ui = new SuperSquare("UI", atms, uiNode, 2, new Vector3f(-1,-1,0), new Vector3f(1,-1,0), new Vector3f(-1,1,0), new Vector3f(1,1,0), tex );
//
//        SimpleMeshUI smUI = new SimpleMeshUI(new Vector3f[]{
//                new Vector3f(-1,-1,0),
//                new Vector3f(-1,1,0),
//                new Vector3f(1,-1,0),
//                new Vector3f(1,1,0)
//
//        },
//                new Vector2f[]{
//                        new Vector2f(-1,-1),
//                        new Vector2f(-1,1),
//                        new Vector2f(1,-1),
//                        new Vector2f(1,1)
//                }, new Texture2D(atms.makeATMS()), uiNode);

//        Picture pic = new Picture("UI");
//        pic.setTexture(assetManager, tex, true);
//        pic.setWidth(settings.getWidth());
//        pic.setHeight(settings.getHeight());
//        pic.setPosition(0, 0);
//        guiNode.attachChild(pic);

       // Alphabet alphabet = new Alphabet('A');
       // alphabet.parser();

        ATMS atmsButton = new ATMS("ATMSButton", 100,100);
        atmsButton.layer.drawCircle(50,50,100,new Vector4f(20,20,20,200));

        ATMS atmsLabel = new ATMS("ATMSLabel", 100, 100);
        atmsLabel.layer.drawCircle(50,50,100,new Vector4f(150,150,150,200));


//        ATMS containerATMS = new ATMS("ATMSContainer", 100,100);
//        containerATMS.layer.drawCircle(50,50,20,new Vector4f(0,0,255,200));

        uiScreen = new Screen();
        Omni omniReset = new Omni("Reset", atmsButton, new Vector2f(), new Vector2f(250, 100)){

            @Override
            public void onClick() {
                super.onClick();
                System.out.println("OMNI CLICKED");
//                selector.resetSelectors();
//                selector.clearMovers();
            }
        };

        Omni omniClear = new Omni("Hide", atmsButton, new Vector2f(250,0), new Vector2f(500, 100)){

            @Override
            public void onClick() {
                super.onClick();
                System.out.println("OMNI CLICKED");
//                selector.clearSelectors();
//                selector.hideMovers();
            }
        };

        Omni omniShow = new Omni("Show", atmsButton, new Vector2f(500,0), new Vector2f(750, 100)){

            @Override
            public void onClick() {
                super.onClick();
                System.out.println("OMNI CLICKED");
//                selector.showSelectors();
//                selector.showMovers();
            }
        };

        Omni omniMode = new Omni("Mode: ", atmsLabel, new Vector2f(0, this.settings.getHeight() - 50), new Vector2f(150, this.settings.getHeight())){

            @Override
            public void onClick() {
                super.onClick();
                System.out.println("OMNI CLICKED");
            }
        };

        Omni omniMesh = new Omni("Mesh", atmsButton, new Vector2f(150, this.settings.getHeight() - 50), new Vector2f(300, this.settings.getHeight())){

            @Override
            public void onClick() {
                super.onClick();
                System.out.println("OMNI CLICKED");
            }
        };

        Omni omniATMS = new Omni("ATMS", atmsButton, new Vector2f(300, this.settings.getHeight() - 50), new Vector2f(450, this.settings.getHeight())){

            @Override
            public void onClick() {
                super.onClick();
                System.out.println("OMNI CLICKED");
            }
        };

        Omni omniSuperMesh = new Omni("SuperMesh: ", atmsLabel, new Vector2f(0, this.settings.getHeight() - 100), new Vector2f(150, this.settings.getHeight() - 50)){

            @Override
            public void onClick() {
                super.onClick();
                System.out.println("OMNI CLICKED");
            }
        };

        ArrayList<Omni> superMeshContainer = new ArrayList<>();
        float f = 150f;
        for (String s: AppSuperMesh.getInstance().superMeshes.keySet()){
            Omni superMesh = new Omni(s, atmsLabel, new Vector2f(0, this.settings.getHeight() - f), new Vector2f(150, this.settings.getHeight() - (f - 50))){

                @Override
                public void onClick() {
                    super.onClick();
                    System.out.println("SUPERMESH CLICKED");
                }
            };
            superMeshContainer.add(superMesh);
            f += 50f;
        }

//        Omni omniContainer = new Omni("Hi", containerATMS, new Vector2f(100,0), new Vector2f(250, 50)){
//
//            @Override
//            public void onClick() {
//                super.onClick();
//                System.out.println("OMNI Container CLICKED");
//            }
//        };

        //uiScreen.omnis.add(omniContainer);
        uiScreen.omnis.add(omniMode);
        uiScreen.omnis.add(omniMesh);
        uiScreen.omnis.add(omniATMS);
        uiScreen.omnis.add(omniReset);
        uiScreen.omnis.add(omniClear);
        uiScreen.omnis.add(omniShow);
        uiScreen.omnis.add(omniSuperMesh);
        uiScreen.omnis.addAll(superMeshContainer);
        uiScreen.draw();
        //Player player = new Player();

        //ViewPort niftyView = renderManager.createPreView("NiftyView", new Camera(1024, 768));


//         niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(
//                assetManager,
//                inputManager,
//                audioRenderer,
//                guiViewPort);
//        nifty = niftyDisplay.getNifty();
//        MyScreenController startScreen = new MyScreenController(this);
//        nifty.fromXml("Interface/Nifty/HelloGameShop.xml", "start", startScreen);
////
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
