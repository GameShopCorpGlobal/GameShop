package com.gameshopcorp.gameshopengine.ui;

import com.gameshopcorp.gameshopengine.app.App;
import com.gameshopcorp.gameshopengine.graphics.SuperSurface;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;

public class GeometrySelector extends Geometry implements Target {


    public SuperSurface superSurface;
    byte row;
    byte column;
    public GeometrySelector(SuperSurface superSurface, byte row, byte column) {

        this.superSurface = superSurface;
        this.row = row;
        this.column = column;
    }

    public void moveSuperLine(Vector3f where){

        superSurface.moveSuperLine(row, column, where);
    }

    public void setSuperLine(Vector3f where){
        superSurface.setSuperLine(row, column, where);

    }

    public void select(){
        Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        setMaterial(mat);
    }

    public void deselect(){
        Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Red);
        setMaterial(mat);
    }
}
    /*
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
}
*/