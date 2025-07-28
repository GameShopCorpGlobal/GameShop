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

    /*
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
    public Node scaleNode;
    public Geometry scaler;

     */

    public ArrayList<ArrayGeometrySelector> geometrySelectors;
    public static ArrayList<ArrayGeometrySelector> selected;
    public static ArrayList<GeometryMover> geometryMovers;

    public static GeometryMover mover;
    public static GeometryScaler geometryScaler;
    public static Node moveNode;
    public static Node lastMoveNode;
    public static Vector3f center;
    public static Node geometrySelectorsNode;
    public Selector() {

        mover = new GeometryMover();
        geometrySelectorsNode = new Node("Geometry Selectors");
        moveNode = new Node("Move");
        lastMoveNode = new Node("LastMoveNode");
        selected = new ArrayList<>();
        geometrySelectors = new ArrayList<>();
        geometryMovers = new ArrayList<>();
        geometryScaler = new GeometryScaler();
        Box b = new Box(.1f, .1f, .1f);
        //gs.setName("Box" + sm + s + sl + v);
        geometryScaler.setMesh(b);
        geometryScaler.deselect();
        geometryScaler.setName("Scaler");
//        selectorNode = new Node("Selector");
//        moveNode = new Node("Mover");
//        scaleNode = new Node("Scaler");
        // Set up touch input
        App.getInstance().app.getInputManager().addMapping("MyTouch", new TouchTrigger(TouchInput.ALL));
        App.getInstance().app.getInputManager().addListener(this, "MyTouch");

        populateGeometrySelectors();



    }

    public void populateGeometrySelectors(){

//        ArrayGeometrySelector ags = new ArrayGeometrySelector();
//
//        geometrySelectors.add(ags);
        for (SuperMesh sm: AppSuperMesh.getInstance().superMeshes.values()){
            for (SuperSurface s: sm.superMesh.values()){
                byte row = 0;
                for (SuperLine sl: s.currencyLines){
                    byte column = 0;
                    for (Vector3f v: sl.points){
                        ArrayGeometrySelector ags = new ArrayGeometrySelector();
                        GeometrySelector gs = new GeometrySelector(s, row, column);
                        Box b = new Box(.1f, .1f, .1f);
                        gs.setName("Box" + sm + s + sl + v);
                        gs.setMesh(b);

                        gs.deselect();
                        gs.setLocalTranslation(v);


                        boolean hasDuplicate = false;
                      //  ags.array.add(gs);

                        ArrayGeometrySelector select = null;
                        for (ArrayGeometrySelector selector: geometrySelectors){
                            for (GeometrySelector g: selector.array){
                                if (g.getLocalTranslation().equals(gs.getLocalTranslation())){
                                    //selector.array.add(gs);
                                    select = selector;
                                    hasDuplicate = true;
                                }
                            }
                        }

                        if (!hasDuplicate){
                            ags.array.add(gs);
                            geometrySelectors.add(ags);
                            geometrySelectorsNode.attachChild(gs);
                        } else {
                            select.array.add(gs);

                        }

                        column++;
                       // geometrySelectors.add(ags);
                    }
                    row++;
                }

            }
        }

        //for (ArrayGeometrySelector ags: geometrySelectors){
          //  for (GeometrySelector gs: ags.array){
                App.getInstance().app.getRootNode().attachChild(geometrySelectorsNode);
           // }
        //}

        System.out.println("SIZE " + geometrySelectors.size());
      //  mergeGeometrySelectorArrays();


    }

    public void populateMovers(){

        center = new Vector3f();
        int d = 0;
        for (ArrayGeometrySelector ags: selected){
            center = center.add(ags.array.get(0).getLocalTranslation());
        d++;
        }
        if (d > 0) {
           center = center.divide(d);
        }
        moveNode.setLocalTranslation(center);
        if (geometryMovers.isEmpty()) {
            for (int i = 0; i < 6; i++) {
                GeometryMover geom = new GeometryMover();
                Box b = new Box(.1f, .1f, .1f);
                //gs.setName("Box" + sm + s + sl + v);
                geom.setMesh(b);
                geom.deselect();

                if (i == 0) { //up
                    //moverDirection = "up";
                    //geom.moveDirection = "up";
                    geom.setName("Mover" + "Up");
                    geom.setLocalTranslation((new Vector3f(0, .33f, 0f)));
                } else if (i == 1) { //down
                    //moverDirection = "down";
                    // geom.moveDirection = "up";
                    geom.setName("Mover" + "Down");
                    geom.setLocalTranslation((new Vector3f(0, -.33f, 0f)));
                } else if (i == 2) { //left
                    // moverDirection = "left";
                    geom.setName("Mover" + "Left");
                    geom.setLocalTranslation((new Vector3f(-.33f, 0, 0f)));

                } else if (i == 3) {
                    geom.setName("Mover" + "Right");
                    // moverDirection = "right";
                    geom.setLocalTranslation((new Vector3f(.33f, 0, 0f)));

                } else if (i == 4) {//front
                    //moverDirection = "front";
                    geom.setName("Mover" + "Front");
                    geom.setLocalTranslation((new Vector3f(0, 0, .33f)));

                } else if (i == 5) {
                    //moverDirection = "down";
                    geom.setName("Mover" + "Back");
                    geom.setLocalTranslation((new Vector3f(0, 0, -.33f)));

                }
                geometryMovers.add(geom);
                moveNode.attachChild(geom);
            }
        }
        geometrySelectorsNode.attachChild(moveNode);
        //App.getInstance().app.getRootNode().attachChild(moveNode);

    }

    public void makeScaler(){

        geometryScaler.setLocalTranslation(moveNode.getLocalTranslation().add(-1,1,-1));
       if(!App.getInstance().app.getRootNode().hasChild(geometryScaler)) {
           //App.getInstance().app.getRootNode().attachChild(geometryScaler);
           geometrySelectorsNode.attachChild(geometryScaler);
       }
    }
//        for ()

    public void hideSelectors(){
        //clearMovers();
        App.getInstance().app.getRootNode().detachChild(geometrySelectorsNode);
    }

    public void showSelectors(){
        App.getInstance().app.getRootNode().attachChild(geometrySelectorsNode);

    }
    public void clearMovers(){

        resetMovers();

            geometrySelectorsNode.detachChild(moveNode);
            //geometryMovers.clear();
       // }
    }

    public void resetMovers(){
        for (GeometryMover g: geometryMovers) {
            g.deselect();
        }
        mover.deselect();

    }

    public void hideScaler(){
        geometrySelectorsNode.detachChild(geometryScaler);
    }

    public void showScaler(){
        geometrySelectorsNode.attachChild(geometryScaler);
    }


    public void resetSelectors(){

        hideScaler();
        clearMovers();
        for (ArrayGeometrySelector ags: selected){
            for (GeometrySelector gs: ags.array){
                gs.deselect();
            }
        }
        selected.clear();
    }


    public void addSelectors(GeometrySelector add){

        for (ArrayGeometrySelector ags: geometrySelectors){
            if (ags.array.contains(add)){
                selected.add(ags);
            }
        }
        //System.out.println("Selected " + selected.size());
    }

    public void moveAllSelectedPoints(){

        for (ArrayGeometrySelector ags: selected){
            ags.setGeometrySelectors(ags.array.get(0).getLocalTranslation().add(moveNode.getLocalTranslation().subtract(lastMoveNode.getLocalTranslation())));
        }

    }

    public void moveAllSelectedPointsRelativeToCenter(){

        Vector3f startingPoint = moveNode.getLocalTranslation().add(-1,1,-1);
        if (startingPoint.distance(geometryScaler.getLocalTranslation()) > 0.01f) {
            Vector3f totalPercentage = new Vector3f((startingPoint).subtract((geometryScaler.getLocalTranslation())));
            //Vector3f totalPercentage = new Vector3f((center.add(geometryScaler.getLocalTranslation()).divide(((center.add(-1,1,-1))))));

            totalPercentage = totalPercentage.mult(1, -1, 1);

            System.out.println("TOTAL PERCENTAGE " + totalPercentage);
            for (ArrayGeometrySelector ags : selected) {
                //ags.setGeometrySelectors();


//                Vector3f distanceFromCenter = g.getLocalTranslatinslation().add(center);
                Vector3f total = new Vector3f(ags.array.get(0).getLocalTranslation().subtract(moveNode.getLocalTranslation())).mult(totalPercentage);
                // totalPercentage = totalPercentage.mult(-1);
              //  total = new Vector3f(total.x, total.y, total.z * -1f);
                //ags.setGeometrySelectors(ags.array.get(0).getLocalTranslation().add(total));

                ags.move(total);
            }
        }
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
//                    if (!movers.isEmpty()) {
                    if (geometryScaler.selected){
                        moveAllSelectedPointsRelativeToCenter();
                        moveAllSelectedPoints();
                        geometryScaler.deselect();
                    }
                    if (mover.selected) {
                        moveAllSelectedPoints();
                        if (selected.size() > 1) {
                            makeScaler();
                        }
                    }
                    lastMoveNode.setLocalTranslation(moveNode.getLocalTranslation());




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
                        Target target = null;

                        for (int i = 0; i < results.size(); i++) {
                            String targetName = results.getCollision(i).getGeometry().getName();

                            if (!targetName.contains("Box") && !targetName.contains("Move") && !targetName.contains("Scale")) {
                                continue;
                            }
                            if (targetName.contains("Box")) {
                                target = (GeometrySelector) results.getCollision(i).getGeometry();
                            }
                            if (targetName.contains("Move")) {
                                target = (GeometryMover) results.getCollision(i).getGeometry();
                            }
                            if (targetName.contains("Scale")) {
                                target = (GeometryScaler) results.getCollision(i).getGeometry();
                            }
                            break;
                        }
                        if (target != null){
                            //forresults.getClosestCollision().getGeometry();
                            // Here comes the action:
                            if (target.getName().contains("Box")) {

                                 target.select();
                                if (target instanceof GeometrySelector) {
                                    addSelectors((GeometrySelector) target);
                                }
                                 //if (geometryMovers.isEmpty()){
                                clearMovers();
                                populateMovers();
                                if (selected.size() > 1) {
                                    makeScaler();
                                }


                            }

                        if (target.getName().contains("Move")) {

                            geometryScaler.deselect();
                            resetMovers();
                            target.select();
                            if (target instanceof GeometryMover) {
                                mover = (GeometryMover) target;
                            }

                        }
                        if (target.getName().contains("Scale")) {
                            resetMovers();
                            mover.deselect();
                            target.select();

                        }
                    }
                    }

                    // Handle a tap gesture
                    System.out.println("Tap detected at: " + event.getX() + ", " + event.getY());
                    break;
                case SCROLL:
                    if (geometryScaler.selected){
                        if (event.getDeltaX() > 0){
                            geometryScaler.move(0.01f, -0.01f, 0.01f);
                        }
                        if (event.getDeltaX() < 0){
                            geometryScaler.move(-0.01f, 0.01f, -0.01f);

                        }
                    }
                    if (mover.selected){
                           if (mover.getName().contains("Up")){
                            if (event.getDeltaX() > 0){
                                moveNode.move(0,0.01f,0);
                            }
                            if (event.getDeltaX() < 0){
                                moveNode.move(0,-0.01f,0);
                            }
                        }
                        if (mover.getName().contains("Down")){
                            if (event.getDeltaX() > 0){
                                moveNode.move(0,0.01f,0);
                            }
                            if (event.getDeltaX() < 0){
                                moveNode.move(0,-0.01f,0);
                            }
                        }
                        if (mover.getName().contains("Left")){
                            if (event.getDeltaX() > 0){
                                moveNode.move(0.01f,0 ,0);
                            }
                            if (event.getDeltaX() < 0){
                                moveNode.move(-0.01f,0,0);
                            }
                        }
                        if (mover.getName().contains("Right")){
                            if (event.getDeltaX() > 0){
                                moveNode.move(0.01f,0 ,0);
                            }
                            if (event.getDeltaX() < 0){
                                moveNode.move(-0.01f,0,0);
                            }
                        }
                        if (mover.getName().contains("Front")){
                            if (event.getDeltaX() > 0){
                                moveNode.move(0,0 ,0.01f);
                            }
                            if (event.getDeltaX() < 0){
                                moveNode.move(0,0,-0.01f);
                            }
                        }
                        if (mover.getName().contains("Back")){
                            if (event.getDeltaX() > 0){
                                moveNode.move(0,0 ,0.01f);
                            }
                            if (event.getDeltaX() < 0){
                                moveNode.move(0,0,-0.01f);
                            }
                        }
                    }
        }
    }

}
}

