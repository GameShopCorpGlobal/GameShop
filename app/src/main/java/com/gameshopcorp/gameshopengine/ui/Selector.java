package com.gameshopcorp.gameshopengine.ui;

import com.gameshopcorp.gameshopengine.app.App;
import com.gameshopcorp.gameshopengine.app.AppSuperMesh;
import com.gameshopcorp.gameshopengine.graphics.SuperLine;
import com.gameshopcorp.gameshopengine.graphics.SuperMesh;
import com.gameshopcorp.gameshopengine.graphics.SuperSurface;
import com.jme3.collision.CollisionResults;
import com.jme3.input.TouchInput;
import com.jme3.input.controls.TouchListener;
import com.jme3.input.controls.TouchTrigger;
import com.jme3.input.event.TouchEvent;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

import java.util.ArrayList;

public class Selector implements TouchListener {

//    public Vector3f selectedVector;
//    public SuperLine selectedSuperLine;
//    public SuperSurface selectedSuperSurface;
//    public SuperMesh selectedSuperMesh;

    //public String selected = "NONE";// NONE, SUPERMESH, SUPERSURFACE, SUPERLINE, VECTOR3F

    public ArrayList<Geometry> selectors;
    public ArrayList<Geometry> selected;
    public ArrayList<Geometry> movers;

    public Geometry selectedMover;
    public Vector3f center;
    public Node selectorNode;

    public Node moveNode;
    public String moverDirection;
    public Vector3f moveSpeed;

    public ArrayList<Geometry> lastSelection;
    public Selector(){

        selectorNode = new Node("Selector");
        moveNode = new Node("Mover");
        // Set up touch input
        App.getInstance().app.getInputManager().addMapping("MyTouch", new TouchTrigger(TouchInput.ALL));
        App.getInstance().app.getInputManager().addListener(this, "MyTouch");

        selectors = new ArrayList<>();
        selected = new ArrayList<>();
        movers = new ArrayList<>();
        center = new Vector3f();
        moveSpeed = new Vector3f();
        lastSelection = new ArrayList<>();
    }

//    public SuperCube genSuperCube(){
//
//        ATMS atms = new ATMS("Selector", 256, 256);
//        atms.layer.drawCircle(128,128,256, new Vector4f(255,0,0,128));
//
//        SuperSquare top = new SuperSquare("Display", atms, new Node("UI"), 2, new Vector3f(-3,3,-3), new Vector3f(3,3,-3), new Vector3f(-3,3,3), new Vector3f(3,3,3), null );
//
//        SuperSquare bottom = new SuperSquare("Display", atms, new Node("UI"), 2, new Vector3f(-3,-3,-3), new Vector3f(3,-3,-3), new Vector3f(-3,-3,3), new Vector3f(3,-3,3), null );
//
//        SuperSquare front = new SuperSquare("Display", atms, new Node("UI"), 2, new Vector3f(-3,-3,3), new Vector3f(3,-3,3), new Vector3f(-3,3,3), new Vector3f(3,3,3), null );
//        //front.node.scale(-1,1,1);
//        SuperSquare back = new SuperSquare("Display", atms, new Node("UI"), 2, new Vector3f(-3,-3,-3), new Vector3f(3,-3,-3), new Vector3f(-3,3,-3), new Vector3f(3,3,-3), null );
//
//        SuperSquare left = new SuperSquare("Display", atms, new Node("UI"), 2, new Vector3f(-3,-3,-3), new Vector3f(-3,-3,3), new Vector3f(-3,3,-3), new Vector3f(-3,3,3), null );
//
//        SuperSquare right = new SuperSquare("Display", atms, new Node("UI"), 2, new Vector3f(3,-3,-3), new Vector3f(3,-3,3), new Vector3f(3,3,-3), new Vector3f(3,3,3), null );
//
//        SuperCube superCube = new SuperCube(top, bottom, front, back, left, right);
//
//        superCube.superMesh.node.scale(.33f);
//        return superCube;
//    }

    public void populateMovers(){

        adjustCenter();
        Box b = new Box(.1f, .1f, .1f);
        for (int i = 0; i < 6; i++) {
            Geometry geom = new Geometry("Mover", b);

            Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
            mat.setColor("Color", ColorRGBA.Red);
            geom.setMaterial(mat);
            if (i == 0) { //up
                //moverDirection = "up";
                geom.setName("Mover" + "Up");
                geom.setLocalTranslation((new Vector3f(0,.33f, 0f)));
            } else if (i == 1){ //down
                //moverDirection = "down";
                geom.setName("Mover" + "Down");
                geom.setLocalTranslation( (new Vector3f(0,-.33f, 0f)));
            } else if (i == 2){ //left
               // moverDirection = "left";
                geom.setName("Mover" + "Left");
                geom.setLocalTranslation((new Vector3f(-.33f,0, 0f)));

            }else if (i == 3){
                geom.setName("Mover" + "Right");
               // moverDirection = "right";
                geom.setLocalTranslation( (new Vector3f(.33f,0, 0f)));

            }else if (i == 4){//front
                //moverDirection = "front";
                geom.setName("Mover" + "Front");
                geom.setLocalTranslation( (new Vector3f(0,0, .33f)));

            }else if (i == 5){
                //moverDirection = "down";
                geom.setName("Mover" + "Back");
                geom.setLocalTranslation( (new Vector3f(0,0, -.33f)));

            }
            movers.add(geom);
            moveNode.attachChild(geom);
        }
        App.getInstance().app.getRootNode().attachChild(moveNode);
    }


    public void moveAllSelectedPoints() {
        lastSelection.clear();
        lastSelection.addAll(selected);
        for (SuperMesh s : AppSuperMesh.getInstance().superMeshes.values()) {

            for (SuperSurface ss : s.superMesh.values()) {
                byte y = 0;
                for (SuperLine sl : ss.currencyLines) {

                    byte x = 0;
                    for (Vector3f v : sl.points) {

                        for (int g = 0; g < lastSelection.size(); g++) {
                            if (lastSelection.get(g).getLocalTranslation().equals(v)) {
                                ss.moveSuperLine(y, x, moveSpeed);
                                // selected.get(g).move(moveSpeed);
                            }
                            //if (g.getLocalTranslation().distance(v) < 0.05f) {
                            // ss.moveSuperLine((byte)y, (byte) x, new Vector3f(0f, .01f, 0f));
                            //g.move(0f, .01f, 0f);
                            // ss.updateSimpleMeshes();

                            //    }
                        }
                        x++;
                    }
                    y++;
                }
                //  ss.updateSimpleMeshes();
            }

        }

        //if (lastSelection.size() < selected.size()) {

        //}

//        for (SuperMesh s: AppSuperMesh.getInstance().superMeshes.values()){
//
//            for (SuperSurface ss: s.superMesh.values()){
//                byte y = 0;
//                for (SuperLine sl: ss.currencyLines){
//
//                    byte x = 0;
//                    for (Vector3f v: sl.points){

                        for (int g = 0; g < lastSelection.size(); g++) {
                            if (lastSelection.get(g).getLocalTranslation().equals(selected.get(g).getLocalTranslation())){
                                //ss.moveSuperLine(y,x, moveSpeed);
                                selected.get(g).move(moveSpeed);
                            }
                        }
                            //if (g.getLocalTranslation().distance(v) < 0.05f) {
                            // ss.moveSuperLine((byte)y, (byte) x, new Vector3f(0f, .01f, 0f));
                            //g.move(0f, .01f, 0f);
                            // ss.updateSimpleMeshes();


                       // }
//                        }
//                        x++;
//                    }
//                    y++;
//                }
//                //  ss.updateSimpleMeshes();
//            }

      //  }



        //lastSelection.clear();
        moveSpeed = new Vector3f();
    }
    public void move(String direction){


//        for (Geometry g: selected){
//            moveNode.attachChild(g);
//        }
        if (direction.equals("up")){
            moveSpeed = moveSpeed.add(new Vector3f(0, .01f, 0));
            moveNode.move(0,.01f,0f);

        } else if (direction.equals("down")){

            moveSpeed = moveSpeed.add(new Vector3f(0, -.01f, 0));
            moveNode.move(0,-.01f,0f);
        } else if (direction.equals("left")){
            moveSpeed = moveSpeed.add(new Vector3f(-.01f, 0f, 0f));
            moveNode.move(-.01f,0f,0f);
        } else if (direction.equals("right")){
            moveSpeed = moveSpeed.add(new Vector3f(.01f, 0f, 0f));
            moveNode.move(.01f,0f,0f);
        } else if (direction.equals("front")){
            moveSpeed = moveSpeed.add(new Vector3f(0, 0f, .01f));
            moveNode.move(0,0f,.01f);
        } else if (direction.equals("back")){
            moveSpeed = moveSpeed.add(new Vector3f(0, 0, -.01f));
            moveNode.move(0,0f,-.01f);
        }




//        for (Geometry g: selected){
//            moveNode.detachChild(g);
//        }

        //}


    }

    public void clearMovers(){
        movers.clear();
        moveNode.detachAllChildren();
    }

    public void showMovers(){
        App.getInstance().app.getRootNode().attachChild(moveNode);
    }

    public void hideMovers(){
        //movers.clear();
        App.getInstance().app.getRootNode().detachChild(moveNode);
    }

    public void resetMovers(){

        for (Geometry g: movers){
            Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
            mat.setColor("Color", ColorRGBA.Red);
            g.setMaterial(mat);
        }
    }

    public void adjustCenter(){

        center = new Vector3f();
        if (!selected.isEmpty()){

            int i = 0;
            for (Geometry g: selected) {
                if (i == 0) {
                    center = g.getLocalTranslation();
                } else {
                    center = center.add(g.getLocalTranslation());
                }
                System.out.println("G" + g.getLocalTranslation());
                i++;
            }
            center =  center.divide(selected.size());


        } else {
            center = new Vector3f();
        }

        moveNode.setLocalTranslation(center);
        System.out.println("SIZE" + selected.size());
        System.out.println("Center" + center);
       // System.out.println );
        //moveNode.setLocalTranslation(center);
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

                            boolean added = false;
                            for (Geometry g: selectors){

                                if (g.getLocalTranslation().equals(v)){
                                    added = true;
                                    break;
                                }
                            }


                            if (!added) {
                               selectorNode.attachChild(geom);
                               selectors.add(geom);
                            }

                           // SuperCube superCube = genSuperCube();
                           // superCube.superMesh.node.setLocalTranslation(new Vector3f(v));
                           // selectors.add(superCube);

                        }
                    }
                }

            }
           showSelectors();

    }

    public void showSelectors(){
        App.getInstance().app.getRootNode().attachChild(selectorNode);
        System.out.println("Selectors Size: " + selectors.size());

    }

    public void resetSelectors(){

        Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Red);

        for (Geometry g: selectors){
            g.setMaterial(mat);
        }
        selected.clear();
    }
    public void clearSelectors(){


        App.getInstance().app.getRootNode().detachChild(selectorNode);


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
//                    for (SuperMesh s: AppSuperMesh.getInstance().superMeshes.values()){
//                        s.update();
//                    }
                    if (!movers.isEmpty()) {
                        moveAllSelectedPoints();
                    }
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

                    // Reset results list.
                    CollisionResults results = new CollisionResults();
                    // Convert screen click to 3d position
                    Vector2f click2d = App.getInstance().app.getInputManager().getCursorPosition();
                    App.getInstance().app.uiScreen.click(click2d);

                    Vector3f click3d = App.getInstance().app.getCamera().getWorldCoordinates(new Vector2f(click2d.x, click2d.y), 0f).clone();
                    Vector3f dir = App.getInstance().app.getCamera().getWorldCoordinates(new Vector2f(click2d.x, click2d.y), 1f).subtractLocal(click3d).normalizeLocal();
                    // Aim the ray from the clicked spot forwards.
                    Ray ray = new Ray(click3d, dir);
                    // Collect intersections between ray and all nodes in results list.
                    App.getInstance().app.getRootNode().collideWith(ray, results);
                    // (Print the results so we see what is going on:)
                    for (int i = 0; i < results.size(); i++) {
                        // (For each "hit", we know distance, impact point, geometry.)
                        float dist = results.getCollision(i).getDistance();
                        Vector3f pt = results.getCollision(i).getContactPoint();
                        String target = results.getCollision(i).getGeometry().getName();
//                        if (results.getCollision(i).getGeometry().getName().contains("Box")){
//                            selected.add(results.getCollision(i).getGeometry())
//                        }
                        System.out.println("Selection #" + i + ": " + target + " at " + pt + ", " + dist + " WU away.");
                    }
                    // Use the results -- we rotate the selected geometry.
                    if (results.size() > 0) {
                        // The closest result is the target that the player picked:
                        Geometry target = results.getClosestCollision().getGeometry();
                        // Here comes the action:
                        if (target.getName().contains("Box")) {

                            Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                            mat.setColor("Color", ColorRGBA.Blue);
                            target.setMaterial(mat);
                            selected.add(target);
                            if (movers.isEmpty()){
                                populateMovers();
                            } else {
                                adjustCenter();
                            }
                            //target.rotate(0, -5f, 0);
                        }

                        if (target.getName().contains("Move")){

                            resetMovers();
                            Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                            mat.setColor("Color", ColorRGBA.Blue);
                            target.setMaterial(mat);
                            //selected.add(target);
                            selectedMover = target;
                            if (target.getName().contains("Up")){
                                moverDirection = "up";
                            }
                            if (target.getName().contains("Down")){
                                moverDirection = "down";
                            }
                            if (target.getName().contains("Left")){
                                moverDirection = "left";
                            }
                            if (target.getName().contains("Right")){
                                moverDirection = "right";
                            }
                            if (target.getName().contains("Front")){
                                moverDirection = "front";
                            }
                            if (target.getName().contains("Back")){
                                moverDirection = "back";
                            }
                        }
                    }

                    // Handle a tap gesture
                    System.out.println("Tap detected at: " + event.getX() + ", " + event.getY());
                    break;
                case SCROLL:
                    if (selectedMover != null){
                        if (moverDirection.equals("up")){
                            if (event.getDeltaY() > 0f){
                                move("up");
                            } else if (event.getDeltaY() < 0f){
                                move("down");
                            }
                        }
                        if (moverDirection.equals("down")){
                            if (event.getDeltaY() > 0f){
                                move("up");
                            } else if (event.getDeltaY() < 0f){
                                move("down");
                            }
                        }
                        if (moverDirection.equals("front")){
                            if (event.getDeltaX() < 0f){
                                move("back");
                            } else if (event.getDeltaX() > 0f){
                                move("front");
                            }
                        }
                        if (moverDirection.equals("back")){
                            if (event.getDeltaX() < 0f){
                                move("back");
                            } else if (event.getDeltaX() > 0f){
                                move("front");
                            }
                        }
                        if (moverDirection.equals("left")){
                            if (event.getDeltaX() > 0f){
                                move("right");
                            } else if (event.getDeltaX() < 0f){
                                move("left");
                            }
                        }
                        if (moverDirection.equals("right")){
                            if (event.getDeltaX() > 0f){
                                move("right");
                            } else if (event.getDeltaX() < 0f){
                                move("left");
                            }
                        }
                    }


                    // Handle a scroll gesture
                    System.out.println("Scroll detected. Scale Span: " + event.getScaleSpan() + ", Delta Scale Span: " + event.getDeltaScaleSpan());
                    break;
                // You can add more cases for other TouchEvent types (e.g., SCALE_START, SCALE_MOVE, SCALE_END)
            }
        }
    }
}
