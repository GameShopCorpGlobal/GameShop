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
    public ArrayList<GeometryMover> geometryMovers;
    public GeometryScaler geometryScaler;
    public Selector() {

        geometrySelectors = new ArrayList<>();
        geometryMovers = new ArrayList<>();
//        selectorNode = new Node("Selector");
//        moveNode = new Node("Mover");
//        scaleNode = new Node("Scaler");
        // Set up touch input
        App.getInstance().app.getInputManager().addMapping("MyTouch", new TouchTrigger(TouchInput.ALL));
        App.getInstance().app.getInputManager().addListener(this, "MyTouch");

        populateGeometrySelectors();
//        selectors = new ArrayList<>();
//        selected = new ArrayList<>();
//        movers = new ArrayList<>();
//        center = new Vector3f();
//        moveSpeed = new Vector3f();
//        lastSelection = new ArrayList<>();
        //scaler = new ArrayList<>();


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

                        Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                        mat.setColor("Color", ColorRGBA.Red);
                        gs.setMaterial(mat);
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
                        } else {
                            select.array.add(gs);

                        }

                       // geometrySelectors.add(ags);
                    }
                }

            }
        }

        for (ArrayGeometrySelector ags: geometrySelectors){
            for (GeometrySelector gs: ags.array){
                App.getInstance().app.getRootNode().attachChild(gs);
            }
        }

        System.out.println("SIZE " + geometrySelectors.size());
      //  mergeGeometrySelectorArrays();


    }

    //public void mergeGeometrySelectorArrays(){

//        ArrayList<ArrayGeometrySelector> agsCopy = new ArrayList<ArrayGeometrySelector>(geometrySelectors);
//        System.out.println("Size " + geometrySelectors.size());
//        for (ArrayGeometrySelector ags: geometrySelectors){
//            ArrayGeometrySelector copy = new ArrayGeometrySelector();
////
//            for (ArrayGeometrySelector ags1: geometrySelectors) {
//
//                    boolean doBreak = false;
//                if (!ags.equals(ags1)){
//
//                    for (GeometrySelector gs : ags.array) {
//
//                        for (GeometrySelector gs1 : ags1.array) {
//
//                            if (!gs.equals(gs1)) {
//                                if (gs.getLocalTranslation().equals(gs1.getLocalTranslation())) {
//                                    copy.array.add(gs1);
//                                    //ags1.array.remove(gs1);
//                                    doBreak = true;
//                                    break;
//                                    // agsCopy.remove(ags1);
//                                }
//                            }
//                        }
//
//                    }
//                    //ags1.array.clear();
//                }
//
//
//            }
//            agsCopy.add(copy);
//        }
//        System.out.println("SIZE " + agsCopy.size());
//    }


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

    //public boolean scalerSelected = false;


    @Override
    public void onTouch(String name, TouchEvent event, float tpf) {
    /**
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
                        if (lastScalerLocation != null && scaleNode != null) {
                            if (scalerSelected) {
                                //if (center.distance(lastScalerLocation) < center.distance(scaleNode.getLocalTranslation())) {

                                moveAllSelectedPointsRelativeToCenter();
//                           }
//
//                           if (center.distance(lastScalerLocation) > center.distance(scaleNode.getLocalTranslation())) {
//
//                               moveAllSelectedPointsRelativeToCenter();
//                           }
                            }
                        }
                    }
                    resetMovers();


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
                        Geometry target = null;
                        for (int i = 0; i < results.size(); i++) {
                            String targetName = results.getCollision(i).getGeometry().getName();

                            if (!targetName.contains("Box") && !targetName.contains("Move") && !targetName.contains("Scale")) {
                                continue;
                            }
                            target = results.getCollision(i).getGeometry();
                            break;
                        }
                        if (target != null){
                            //forresults.getClosestCollision().getGeometry();
                            // Here comes the action:
                            if (target.getName().contains("Box")) {

                                Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                                mat.setColor("Color", ColorRGBA.Blue);
                                target.setMaterial(mat);
                                selected.add(target);
                                if (movers.isEmpty()) {
                                    populateMovers();
                                } else {
                                    adjustCenter();
                                    if (selected.size() > 1) {
                                        addScaler();
                                    }
                                }
                                //target.rotate(0, -5f, 0);
                            }

                        if (target.getName().contains("Move")) {

                            resetMovers();
                            resetScaler();
                            Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                            mat.setColor("Color", ColorRGBA.Blue);
                            target.setMaterial(mat);
                            //selected.add(target);
                            selectedMover = target;
                            if (target.getName().contains("Up")) {
                                moverDirection = "up";
                            }
                            if (target.getName().contains("Down")) {
                                moverDirection = "down";
                            }
                            if (target.getName().contains("Left")) {
                                moverDirection = "left";
                            }
                            if (target.getName().contains("Right")) {
                                moverDirection = "right";
                            }
                            if (target.getName().contains("Front")) {
                                moverDirection = "front";
                            }
                            if (target.getName().contains("Back")) {
                                moverDirection = "back";
                            }
                        }
                        if (target.getName().contains("Scale")) {
                            //resetScaler();
                            resetMovers();
                            Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                            mat.setColor("Color", ColorRGBA.Green);
                            scaler.setMaterial(mat);
                            scalerSelected = true;
                            System.out.println("SELECTED SCALE");
                        }
                    }
                    }

                    // Handle a tap gesture
                    System.out.println("Tap detected at: " + event.getX() + ", " + event.getY());
                    break;
                case SCROLL:
                    if (scalerSelected){

                        Vector3f movePercentage = new Vector3f();
                        if (event.getDeltaX() > 0){
                            if (scaleNode.getLocalTranslation().x > center.x){
                                movePercentage.setX(-0.01f);
                            } else if (scaleNode.getLocalTranslation().x < center.x)  {
                                movePercentage.setX(0.01f);
                            }

                            if (scaleNode.getLocalTranslation().y > center.y){
                                movePercentage.setY(-0.01f);
                            } else if (scaleNode.getLocalTranslation().y < center.y)  {
                                movePercentage.setY(0.01f);
                            }

                            if (scaleNode.getLocalTranslation().z > center.z){
                                movePercentage.setZ(-0.01f);
                            } else if (scaleNode.getLocalTranslation().z < center.z)  {
                                movePercentage.setZ(0.01f);
                            }


//                           moveScaler()
                            // moveAllSelectedPointsRelativeToCenter(true);
                        } else {
                            if (scaleNode.getLocalTranslation().x > center.x){
                                movePercentage.setX(0.01f);
                            } else if (scaleNode.getLocalTranslation().x < center.x)  {
                                movePercentage.setX(-0.01f);
                            }

                            if (scaleNode.getLocalTranslation().y > center.y){
                                movePercentage.setY(0.01f);

                            } else if (scaleNode.getLocalTranslation().y < center.y)  {
                                movePercentage.setY(-0.01f);

                            }

                            if (scaleNode.getLocalTranslation().z > center.z){
                                movePercentage.setZ(0.01f);

                            } else if (scaleNode.getLocalTranslation().z < center.z)  {
                                movePercentage.setZ(-0.01f);

                            }
                            //moveAllSelectedPointsRelativeToCenter(false);
                        }
                        moveScaler(movePercentage);
                    }
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
     */
}
}
