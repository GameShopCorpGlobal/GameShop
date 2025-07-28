package com.gameshopcorp.gameshopengine.ui;

import com.gameshopcorp.gameshopengine.app.App;
import com.gameshopcorp.gameshopengine.graphics.SuperSurface;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;

import java.util.ArrayList;

public class GeometryScaler extends Geometry implements Target {

    public ArrayList<GeometrySelector> selectors;

    public boolean selected;
    public GeometryScaler() {

    }

    @Override
    public void select() {
        selected = true;
        Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Green);
        setMaterial(mat);
    }

    @Override
    public void deselect() {
        selected = false;
        Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Orange);
        setMaterial(mat);
    }
}
    /*
    public void addScaler(){

        if (scaler != null){
            //scaler = null;
            App.getInstance().app.getRootNode().detachChild(scaleNode);
        }
        scalerSelected = false;
        Box b = new Box(.1f, .1f, .1f);

        Geometry geom = new Geometry("Scaler", b);

        Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Orange);
        geom.setMaterial(mat);
        scaler = geom;
        scaleNode.setLocalTranslation(center);
        scaleNode.attachChild(scaler);
        scaleNode.move(-1,1,-1);
        App.getInstance().app.getRootNode().attachChild(scaleNode);
    }

    public void resetScaler(){
        Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Orange);
        scaler.setMaterial(mat);
        scalerSelected = false;
    }

    public void moveAllSelectedPointsRelativeToCenter(){




        for (Geometry g: selected){
            // Vector3f totalPercentage = new Vector3f(((center.add(-1,1,-1).subtract(center.add(scaleNode.getLocalTranslation())))));

            Vector3f startingPoint = center.add(-1,1,-1);
            Vector3f totalPercentage = new Vector3f((startingPoint).subtract((scaleNode.getLocalTranslation())));

            totalPercentage = totalPercentage.mult(1,-1,1);
            System.out.println("TOTAL PERCENTAGE " + totalPercentage);

//                Vector3f distanceFromCenter = g.getLocalTranslatinslation().add(center);
            Vector3f total = new Vector3f(g.getLocalTranslation().subtract(center)).mult(totalPercentage);
            // totalPercentage = totalPercentage.mult(-1);
            g.move(total);
        }

        for (SuperMesh s : AppSuperMesh.getInstance().superMeshes.values()) {

            for (SuperSurface ss : s.superMesh.values()) {
                byte y = 0;
                for (SuperLine sl : ss.currencyLines) {

                    byte x = 0;
                    for (Vector3f v : sl.points) {

                        for (int g = 0; g < lastSelection.size(); g++) {
                            if (lastSelection.get(g).getLocalTranslation().equals(v)) {
                                ss.setSuperLine(y, x, selected.get(g).getLocalTranslation());
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

    }

    Vector3f lastScalerLocation;
    Vector3f scaleMovePercentage;
    public void moveScaler(Vector3f percentage){
        lastSelection.clear();
        lastSelection.addAll(selected);
        lastScalerLocation = new Vector3f(-1,1,-1);
        scaleMovePercentage = new Vector3f(percentage);
        scaleNode.move(percentage);

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


}

     */
