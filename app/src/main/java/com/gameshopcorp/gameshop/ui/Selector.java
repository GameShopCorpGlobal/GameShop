package com.gameshopcorp.gameshop.ui;

import com.gameshopcorp.gameshop.app.App;
import com.gameshopcorp.gameshop.app.AppSuperMesh;
import com.gameshopcorp.gameshop.graphics.ATMS;
import com.gameshopcorp.gameshop.graphics.SuperLine;
import com.gameshopcorp.gameshop.graphics.SuperMesh;
import com.gameshopcorp.gameshop.graphics.SuperSurface;
import com.gameshopcorp.gameshop.supermesh.SuperCube;
import com.gameshopcorp.gameshop.supermesh.SuperSquare;
import com.jme3.input.TouchInput;
import com.jme3.input.controls.TouchListener;
import com.jme3.input.controls.TouchTrigger;
import com.jme3.input.event.TouchEvent;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

import java.util.ArrayList;
import java.util.HashMap;

public class Selector implements TouchListener {

//    public Vector3f selectedVector;
//    public SuperLine selectedSuperLine;
//    public SuperSurface selectedSuperSurface;
//    public SuperMesh selectedSuperMesh;

    //public String selected = "NONE";// NONE, SUPERMESH, SUPERSURFACE, SUPERLINE, VECTOR3F

    public ArrayList<Geometry> selectors;

    public Node selectorNode;
    public Selector(){

        selectorNode = new Node("Selector");
        // Set up touch input
        App.getInstance().app.getInputManager().addMapping("MyTouch", new TouchTrigger(TouchInput.ALL));
        App.getInstance().app.getInputManager().addListener(this, "MyTouch");

        selectors = new ArrayList<>();

    }

    public SuperCube genSuperCube(){

        ATMS atms = new ATMS("Selector", 256, 256);
        atms.layer.drawCircle(128,128,256, new Vector4f(255,0,0,128));

        SuperSquare top = new SuperSquare("Display", atms, new Node("UI"), 2, new Vector3f(-3,3,-3), new Vector3f(3,3,-3), new Vector3f(-3,3,3), new Vector3f(3,3,3), null );

        SuperSquare bottom = new SuperSquare("Display", atms, new Node("UI"), 2, new Vector3f(-3,-3,-3), new Vector3f(3,-3,-3), new Vector3f(-3,-3,3), new Vector3f(3,-3,3), null );

        SuperSquare front = new SuperSquare("Display", atms, new Node("UI"), 2, new Vector3f(-3,-3,3), new Vector3f(3,-3,3), new Vector3f(-3,3,3), new Vector3f(3,3,3), null );
        //front.node.scale(-1,1,1);
        SuperSquare back = new SuperSquare("Display", atms, new Node("UI"), 2, new Vector3f(-3,-3,-3), new Vector3f(3,-3,-3), new Vector3f(-3,3,-3), new Vector3f(3,3,-3), null );

        SuperSquare left = new SuperSquare("Display", atms, new Node("UI"), 2, new Vector3f(-3,-3,-3), new Vector3f(-3,-3,3), new Vector3f(-3,3,-3), new Vector3f(-3,3,3), null );

        SuperSquare right = new SuperSquare("Display", atms, new Node("UI"), 2, new Vector3f(3,-3,-3), new Vector3f(3,-3,3), new Vector3f(3,3,-3), new Vector3f(3,3,3), null );

        SuperCube superCube = new SuperCube(top, bottom, front, back, left, right);

        superCube.superMesh.node.scale(.33f);
        return superCube;
    }
    public void populateSelectors(){



            for (SuperMesh s: AppSuperMesh.getInstance().superMeshes.values()){

                for (SuperSurface ss: s.superMesh.values()){

                    for (SuperLine sl: ss.currencyLines){

                        for (Vector3f v: sl.points){

                            Box b = new Box(.1f, .1f, .1f);
                            Geometry geom = new Geometry("Box" + s + ss + sl + v, b);

                            Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                            mat.setColor("Color", ColorRGBA.Red);
                            geom.setMaterial(mat);
                            geom.setLocalTranslation(v);

                            App.getInstance().app.getRootNode().attachChild(geom);
                           // SuperCube superCube = genSuperCube();
                           // superCube.superMesh.node.setLocalTranslation(new Vector3f(v));
                           // selectors.add(superCube);

                        }
                    }
                }

            }



    }

    public void clearSelectors(){


        selectorNode.detachAllChildren();


    }

    public void evaluateClick(){

        
    }

    @Override
    public void onTouch(String name, TouchEvent event, float tpf) {
        if (name.equals("MyTouch")) {
            switch (event.getType()) {
                case DOWN:
                    // Handle touch down event
                    System.out.println("Touch Down at: " + event.getX() + ", " + event.getY());
                    // Example: Check if a game object was touched
                    // Vector2f touchPoint = new Vector2f(event.getX(), event.getY());
                    // CollisionResults results = new CollisionResults();
                    // Ray ray = cam.get:**WorldCoordinates**(touchPoint, 0f).clone();
                    // ... (rest of your picking logic)
                    break;
                case UP:
                    // Handle touch up event
                    System.out.println("Touch Up at: " + event.getX() + ", " + event.getY());
                    break;
                case MOVE:
                    // Handle touch move event
                    System.out.println("Touch Move to: " + event.getX() + ", " + event.getY());
                    // Example: Move an object based on touch movement
                    // float deltaX = event.getDeltaX();
                    // float deltaY = event.getDeltaY();
                    // myObject.move(deltaX * someSpeed, deltaY * someSpeed, 0);
                    break;
                case TAP:


                    // Handle a tap gesture
                    System.out.println("Tap detected at: " + event.getX() + ", " + event.getY());
                    break;
                case SCROLL:
                    // Handle a scroll gesture
                    System.out.println("Scroll detected. Scale Span: " + event.getScaleSpan() + ", Delta Scale Span: " + event.getDeltaScaleSpan());
                    break;
                // You can add more cases for other TouchEvent types (e.g., SCALE_START, SCALE_MOVE, SCALE_END)
            }
        }
    }
}
