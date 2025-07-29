package com.gameshopcorp.gameshopengine;

import com.gameshopcorp.gameshopengine.app.App;
import com.gameshopcorp.gameshopengine.app.AppSuperMesh;
import com.gameshopcorp.gameshopengine.gameshopui.Omni;
import com.gameshopcorp.gameshopengine.gameshopui.Screen;
import com.gameshopcorp.gameshopengine.gameshopui.ScreenContainer;
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
    //public Screen uiScreen;
    public ScreenContainer screenContainer;
    public Vector2f radius;
    public Vector4f paintColor;
    //public float radius;
    @Override
    public void simpleInitApp() {
        this.setDisplayFps(false);
        this.setDisplayStatView(false);
        App.getInstance().app = this;

        flyCam.setEnabled(true);

        getViewPort().setBackgroundColor(ColorRGBA.White);

        screenContainer = new ScreenContainer();
        screenContainer.selectedScreen = "uiScreen";

        //radius = 10f;

        ATMS atmsTop = new ATMS("BlueBox", 256, 256);
        atmsTop.layer.drawCircle(128,128,256, new Vector4f(0,0,255,128));
        ATMS atmsBottom = new ATMS("BlueBox", 256, 256);
        atmsBottom.layer.drawCircle(128,128,256, new Vector4f(0,0,255,128));
        ATMS atmsFront = new ATMS("BlueBox", 256, 256);
        atmsFront.layer.drawCircle(128,128,256, new Vector4f(0,0,255,128));
        ATMS atmsBack = new ATMS("BlueBox", 256, 256);
        atmsBack.layer.drawCircle(128,128,256, new Vector4f(0,0,255,128));
        ATMS atmsLeft = new ATMS("BlueBox", 256, 256);
        atmsLeft.layer.drawCircle(128,128,256, new Vector4f(0,0,255,128));
        ATMS atmsRight = new ATMS("BlueBox", 256, 256);
        atmsRight.layer.drawCircle(128,128,256, new Vector4f(0,0,255,128));

        Texture2D tex = (Texture2D) assetManager.loadTexture("Textures/Rune.jpeg");


        SuperSquare top = new SuperSquare("Display", atmsTop, new Node("UI"), 8, new Vector3f(-3,3,-3), new Vector3f(3,3,-3), new Vector3f(-3,3,3), new Vector3f(3,3,3), null );

        SuperSquare bottom = new SuperSquare("Display", atmsBottom, new Node("UI"), 8, new Vector3f(-3,-3,-3), new Vector3f(3,-3,-3), new Vector3f(-3,-3,3), new Vector3f(3,-3,3), null );

        SuperSquare front = new SuperSquare("Display", atmsFront, new Node("UI"), 8, new Vector3f(-3,-3,3), new Vector3f(3,-3,3), new Vector3f(-3,3,3), new Vector3f(3,3,3), null );

        SuperSquare back = new SuperSquare("Display", atmsBack, new Node("UI"), 8, new Vector3f(-3,-3,-3), new Vector3f(3,-3,-3), new Vector3f(-3,3,-3), new Vector3f(3,3,-3), null );

        SuperSquare left = new SuperSquare("Display", atmsLeft, new Node("UI"), 8, new Vector3f(-3,-3,-3), new Vector3f(-3,-3,3), new Vector3f(-3,3,-3), new Vector3f(-3,3,3), null );

        SuperSquare right = new SuperSquare("Display", atmsRight, new Node("UI"), 8, new Vector3f(3,-3,-3), new Vector3f(3,-3,3), new Vector3f(3,3,-3), new Vector3f(3,3,3), null );

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

        Screen uiScreen = new Screen(){
            @Override
            public void onDraw() {
                super.onDraw();
                selector.showSelectors();
            }
        };
        Screen uiScreenATMS = new Screen(){
            @Override
            public void onDraw() {
                super.onDraw();
                selector.hideSelectors();
            }
        };

        Omni omniReset = new Omni("Reset", atmsButton, new Vector2f(), new Vector2f(250, 100)){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
//                selector.resetSelectors();
//                selector.clearMovers();
                selector.resetSelectors();
            }
        };

        Omni omniClear = new Omni("Hide", atmsButton, new Vector2f(250,0), new Vector2f(500, 100)){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
//                selector.clearSelectors();
//                selector.hideMovers();
                selector.hideSelectors();
            }
        };

        Omni omniShow = new Omni("Show", atmsButton, new Vector2f(500,0), new Vector2f(750, 100)){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
//                selector.showSelectors();
//                selector.showMovers();
                selector.showSelectors();
            }
        };

        Omni omniMode = new Omni("Mode: ", atmsLabel, new Vector2f(0, this.settings.getHeight() - 50), new Vector2f(150, this.settings.getHeight())){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
            }
        };

        Omni omniMesh = new Omni("Mesh", atmsButton, new Vector2f(150, this.settings.getHeight() - 50), new Vector2f(300, this.settings.getHeight())){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
                screenContainer.changeScreen("uiScreen");
            }
        };

        Omni omniATMS = new Omni("ATMS", atmsButton, new Vector2f(300, this.settings.getHeight() - 50), new Vector2f(450, this.settings.getHeight())){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
                screenContainer.changeScreen("uiScreenATMS");
            }
        };

        Omni omniSuperMesh = new Omni("SuperMesh: ", atmsLabel, new Vector2f(0, this.settings.getHeight() - 100), new Vector2f(150, this.settings.getHeight() - 50)){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
            }
        };

        ArrayList<Omni> superMeshContainer = new ArrayList<>();
        float f = 150f;
        for (String s: AppSuperMesh.getInstance().superMeshes.keySet()){
            Omni superMesh = new Omni(s, atmsLabel, new Vector2f(0, this.settings.getHeight() - f), new Vector2f(150, this.settings.getHeight() - (f - 50))){

                @Override
                public void onClick(Vector2f position) {
                    super.onClick(position);
                    System.out.println("SUPERMESH CLICKED");
                }
            };
            superMeshContainer.add(superMesh);
            f += 50f;
        }

        paintColor = new Vector4f(0,0,255,128);

        ATMS atmsPaint = new ATMS("ATMSPaint", 128,128);
        atmsPaint.layer.drawCircle(64,64,128, new Vector4f(255,255,255,255));
        atmsPaint.layer.drawCircle(64,64,64, paintColor);

        ATMS atmsSliderRed = new ATMS("ATMSPaint", 255,100);
        atmsSliderRed.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(128,128,128,255));
        atmsSliderRed.layer.drawCircle((int) paintColor.x, 47, (short)25, new Vector4f(0,0,255,255));

        ATMS atmsSliderGreen = new ATMS("ATMSPaint", 255,100);
        atmsSliderGreen.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(128,128,128,255));
        atmsSliderGreen.layer.drawCircle((int) paintColor.y, 47, (short)25, new Vector4f(0,0,255,255));


        ATMS atmsSliderBlue = new ATMS("ATMSPaint", 255,100);
        atmsSliderBlue.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(128,128,128,255));
        atmsSliderBlue.layer.drawCircle((int) paintColor.z, 47, (short)25, new Vector4f(0,0,255,255));

        ATMS atmsSliderAlpha = new ATMS("ATMSPaint", 255,100);
        atmsSliderAlpha.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(128,128,128,255));
        atmsSliderAlpha.layer.drawCircle((int) paintColor.w, 47, (short)25, new Vector4f(0,0,255,255));

        radius = new Vector2f(10f, 0f);
        ATMS atmsSliderRadius = new ATMS("ATMSPaint", 255,100);
        atmsSliderRadius.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(128,128,128,255));
        atmsSliderRadius.layer.drawCircle((int) radius.x, 47, (short)25, new Vector4f(0,0,255,255));

        /// ATMS Screen
        Omni omniPaint = new Omni("", atmsPaint, new Vector2f(this.settings.getWidth() - 200, this.settings.getHeight() - 200), new Vector2f(this.settings.getWidth(), this.settings.getHeight())){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
            }
        };

        Omni omniRed = new Omni("Red: " + paintColor.x, atmsLabel, new Vector2f(this.settings.getWidth() - 200, this.settings.getHeight() - 250), new Vector2f(this.settings.getWidth() - 100, this.settings.getHeight() - 200)){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
            }
        };

        Omni omniSliderRed = new Omni("", atmsSliderRed, new Vector2f(this.settings.getWidth() - 400, this.settings.getHeight() - 300), new Vector2f(this.settings.getWidth(), this.settings.getHeight() - 250)){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                float colorLocation = ((position.x - start.x)/400f) * 255f;
                paintColor.setX(colorLocation);
                omniRed.text = "Red: " + paintColor.x;
                omniRed.drawText();
                atmsPaint.layer.drawCircle(64,64,64, paintColor);
                omniPaint.draw();
                atmsSliderRed.layer.drawCircle(64,64,400, new Vector4f());
                atmsSliderRed.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(128,128,128,255));
                atmsSliderRed.layer.drawCircle((int) paintColor.x, 47, (short)25, new Vector4f(0,0,255,255));
                draw();
                System.out.println("OMNI CLICKED");
            }
        };





//        Omni omniRedPlus = new Omni(" + " , atmsButton, new Vector2f(this.settings.getWidth() - 100, this.settings.getHeight() - 300), new Vector2f(this.settings.getWidth() - 50, this.settings.getHeight() - 200)){
//
//            @Override
//            public void onClick() {
//                super.onClick();
//                paintColor.setX(paintColor.getX() + 1);
//                omniRed.text = "Red: " + paintColor.x;
//                omniRed.drawText();
//                atmsPaint.layer.drawCircle(64,64,64, paintColor);
//                omniPaint.draw();
//                System.out.println("OMNI CLICKED");
//            }
//        };
//
//        Omni omniRedMinus = new Omni(" - ", atmsButton, new Vector2f(this.settings.getWidth() - 50, this.settings.getHeight() - 300), new Vector2f(this.settings.getWidth(), this.settings.getHeight() - 200)){
//
//            @Override
//            public void onClick() {
//                super.onClick();
//                System.out.println("OMNI CLICKED");
//            }
//        };

        Omni omniGreen = new Omni("Green: " + paintColor.y, atmsLabel, new Vector2f(this.settings.getWidth() - 200, this.settings.getHeight() - 350), new Vector2f(this.settings.getWidth() - 100, this.settings.getHeight() - 300)){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);

                System.out.println("OMNI CLICKED");
            }
        };

        Omni omniSliderGreen = new Omni("", atmsSliderGreen, new Vector2f(this.settings.getWidth() - 400, this.settings.getHeight() - 400), new Vector2f(this.settings.getWidth(), this.settings.getHeight() - 350)){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                float colorLocation = ((position.x - start.x)/400f) * 255f;
                paintColor.setY(colorLocation);
                omniGreen.text = "Green: " + paintColor.y;
                omniGreen.drawText();
                atmsPaint.layer.drawCircle(64,64,64, paintColor);
                omniPaint.draw();
                atmsSliderGreen.layer.drawCircle(64,64,400, new Vector4f());
                atmsSliderGreen.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(128,128,128,255));
                atmsSliderGreen.layer.drawCircle((int) paintColor.y, 47, (short)25, new Vector4f(0,0,255,255));
                draw();
                System.out.println("OMNI CLICKED");
            }
        };

//        Omni omniGreenPlus = new Omni(" + " , atmsButton, new Vector2f(this.settings.getWidth() - 100, this.settings.getHeight() - 400), new Vector2f(this.settings.getWidth() - 50, this.settings.getHeight() - 300)){
//
//            @Override
//            public void onClick() {
//                super.onClick();
//                System.out.println("OMNI CLICKED");
//            }
//        };
//
//        Omni omniGreenMinus = new Omni(" - ", atmsButton, new Vector2f(this.settings.getWidth() - 50, this.settings.getHeight() - 400), new Vector2f(this.settings.getWidth(), this.settings.getHeight() - 300)){
//
//            @Override
//            public void onClick() {
//                super.onClick();
//                System.out.println("OMNI CLICKED");
//            }
//        };

        Omni omniBlue = new Omni("Blue: " + paintColor.z, atmsLabel, new Vector2f(this.settings.getWidth() - 200, this.settings.getHeight() - 450), new Vector2f(this.settings.getWidth() - 100, this.settings.getHeight() - 400)){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
            }
        };

        Omni omniSliderBlue = new Omni("", atmsSliderBlue, new Vector2f(this.settings.getWidth() - 400, this.settings.getHeight() - 500), new Vector2f(this.settings.getWidth() , this.settings.getHeight() - 450)){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                float colorLocation = ((position.x - start.x)/400f) * 255f;
                paintColor.setZ(colorLocation);
                omniBlue.text = "Blue: " + paintColor.z;
                omniBlue.drawText();
                atmsPaint.layer.drawCircle(64,64,64, paintColor);
                omniPaint.draw();
                atmsSliderBlue.layer.drawCircle(64,64,400, new Vector4f());
                atmsSliderBlue.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(128,128,128,255));
                atmsSliderBlue.layer.drawCircle((int) paintColor.z, 47, (short)25, new Vector4f(0,0,255,255));
                draw();
                System.out.println("OMNI CLICKED");
            }
        };
//        Omni omniBluePlus = new Omni(" + " , atmsButton, new Vector2f(this.settings.getWidth() - 100, this.settings.getHeight() - 500), new Vector2f(this.settings.getWidth() - 50, this.settings.getHeight() - 400)){
//
//            @Override
//            public void onClick() {
//                super.onClick();
//                System.out.println("OMNI CLICKED");
//            }
//        };
//
//        Omni omniBlueMinus = new Omni(" - ", atmsButton, new Vector2f(this.settings.getWidth() - 50, this.settings.getHeight() - 500), new Vector2f(this.settings.getWidth(), this.settings.getHeight() - 400)){
//
//            @Override
//            public void onClick() {
//                super.onClick();
//                System.out.println("OMNI CLICKED");
//            }
//        };

        Omni omniAlpha = new Omni("Alpha: " + paintColor.w, atmsLabel, new Vector2f(this.settings.getWidth() - 200, this.settings.getHeight() - 550), new Vector2f(this.settings.getWidth() - 100, this.settings.getHeight() - 500)){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);

                System.out.println("OMNI CLICKED");
            }
        };

        Omni omniSliderAlpha = new Omni("", atmsSliderAlpha, new Vector2f(this.settings.getWidth() - 400, this.settings.getHeight() - 600), new Vector2f(this.settings.getWidth(), this.settings.getHeight() - 550)){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                float colorLocation = ((position.x - start.x)/400f) * 255f;
                paintColor.setW(colorLocation);
                omniAlpha.text = "Alpha: " + paintColor.w;
                omniAlpha.drawText();
                atmsPaint.layer.drawCircle(64,64,64, paintColor);
                omniPaint.draw();
                atmsSliderAlpha.layer.drawCircle(64,64,400, new Vector4f());
                atmsSliderAlpha.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(128,128,128,255));
                atmsSliderAlpha.layer.drawCircle((int) paintColor.w, 47, (short)25, new Vector4f(0,0,255,255));
                draw();
                System.out.println("OMNI CLICKED");
            }
        };

        Omni omniRadius = new Omni("Radius: " + radius.x, atmsLabel, new Vector2f(this.settings.getWidth() - 200, this.settings.getHeight() - 650), new Vector2f(this.settings.getWidth(), this.settings.getHeight() - 600)){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);

                System.out.println("OMNI CLICKED");
            }
        };

        Omni omniSliderRadius = new Omni("", atmsSliderRadius, new Vector2f(this.settings.getWidth() - 400, this.settings.getHeight() - 700), new Vector2f(this.settings.getWidth(), this.settings.getHeight() - 650)){

            @Override
            public void onClick(Vector2f position) {
                super.onClick(position);
                float colorLocation = ((position.x - start.x)/400f) * 255f;
                radius.setX(colorLocation);
                omniRadius.text = "Radius: " + radius.x;
                omniRadius.drawText();
                //atmsPaint.layer.drawCircle(64,64,64, paintColor);
                //omniPaint.draw();
                atmsSliderRadius.layer.drawCircle(64,64,400, new Vector4f());
                atmsSliderRadius.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(128,128,128,255));
                atmsSliderRadius.layer.drawCircle((int) radius.x, 47, (short)25, new Vector4f(0,0,255,255));
                draw();
                System.out.println("OMNI CLICKED");
            }
        };
//
//        Omni omniAlphaPlus = new Omni(" + " , atmsButton, new Vector2f(this.settings.getWidth() - 100, this.settings.getHeight() - 600), new Vector2f(this.settings.getWidth() - 50, this.settings.getHeight() - 500)){
//
//            @Override
//            public void onClick() {
//                super.onClick();
//                System.out.println("OMNI CLICKED");
//            }
//        };
//
//        Omni omniAlphaMinus = new Omni(" - ", atmsButton, new Vector2f(this.settings.getWidth() - 50, this.settings.getHeight() - 600), new Vector2f(this.settings.getWidth(), this.settings.getHeight() - 500)){
//
//            @Override
//            public void onClick() {
//                super.onClick();
//                System.out.println("OMNI CLICKED");
//            }
//        };

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

        uiScreenATMS.omnis.add(omniMode);
        uiScreenATMS.omnis.add(omniMesh);
        uiScreenATMS.omnis.add(omniATMS);
        uiScreenATMS.omnis.add(omniPaint);

        uiScreenATMS.omnis.add(omniRed);
        uiScreenATMS.omnis.add(omniGreen);
        uiScreenATMS.omnis.add(omniBlue);
        uiScreenATMS.omnis.add(omniAlpha);
        uiScreenATMS.omnis.add(omniRadius);

        uiScreenATMS.omnis.add(omniSliderRed);
        uiScreenATMS.omnis.add(omniSliderGreen);
        uiScreenATMS.omnis.add(omniSliderBlue);
        uiScreenATMS.omnis.add(omniSliderAlpha);
        uiScreenATMS.omnis.add(omniSliderRadius);
//        uiScreenATMS.omnis.add(omniRedPlus);
//        uiScreenATMS.omnis.add(omniGreenPlus);
//        uiScreenATMS.omnis.add(omniBluePlus);
//        uiScreenATMS.omnis.add(omniAlphaPlus);
//
//        uiScreenATMS.omnis.add(omniRedMinus);
//        uiScreenATMS.omnis.add(omniGreenMinus);
//        uiScreenATMS.omnis.add(omniBlueMinus);
//        uiScreenATMS.omnis.add(omniAlphaMinus);

        screenContainer.screens.put("uiScreen", uiScreen);
        screenContainer.screens.put("uiScreenATMS", uiScreenATMS);
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
