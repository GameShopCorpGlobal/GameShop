package com.gameshopcorp.gameshopengine.ui;

import com.gameshopcorp.gameshopengine.app.App;
import com.gameshopcorp.gameshopengine.graphics.SuperSurface;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;

import java.util.ArrayList;

public class GeometryMover extends Geometry implements Target {

    //selected Geometries;
    //Center
   // public ArrayList<ArrayGeometrySelector> selectors;
    //public Vector3f center;
    public String moveDirection;// up down left right front back

    public GeometryMover() {

    }

    @Override
    public void select() {

        Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        setMaterial(mat);
    }

    @Override
    public void deselect() {

        Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Red);
        setMaterial(mat);
    }
}
    /*
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
}

     */
