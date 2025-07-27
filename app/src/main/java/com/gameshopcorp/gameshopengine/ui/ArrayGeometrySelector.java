package com.gameshopcorp.gameshopengine.ui;

import com.jme3.math.Vector3f;

import java.util.ArrayList;

public class ArrayGeometrySelector {

    public ArrayList<GeometrySelector> array;
    public ArrayGeometrySelector(){

        array = new ArrayList<>();

    }



    public void setSuperLines(Vector3f where){
        for (GeometrySelector gs: array){
            gs.setSuperLine(where);
        }
    }
}
