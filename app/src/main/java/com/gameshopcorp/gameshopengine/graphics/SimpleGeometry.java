package com.gameshopcorp.gameshopengine.graphics;

import com.jme3.scene.Geometry;

public class SimpleGeometry extends Geometry {

    public SuperSurface superSurface;
    public SimpleMesh simpleMesh;
    public SimpleGeometry(SuperSurface superSurface, SimpleMesh simpleMesh){

        this.superSurface = superSurface;
        this.simpleMesh = simpleMesh;
    }
}
