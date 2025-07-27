package com.gameshopcorp.gameshopengine.terrain.grass;

import com.gameshopcorp.gameshopengine.graphics.SuperLine;
import com.gameshopcorp.gameshopengine.graphics.SuperMesh;
import com.jme3.math.Vector3f;

public class Grass {

    SuperMesh superMesh;
    public Grass(){

        int numPoints = 2;
        SuperLine superLine = new SuperLine(new Vector3f[]{new Vector3f(0,0,0), new Vector3f(.66f, 0, 0),new Vector3f(1.33f,0,0), new Vector3f(2f, 0, 0)}, numPoints);
        SuperLine superLine1 = new SuperLine(new Vector3f[]{new Vector3f(0,.33f,0), new Vector3f(.66f, .33f, 0),new Vector3f(1.33f,.33f,0), new Vector3f(2f, .33f, 0)}, numPoints);
        SuperLine superLine2 = new SuperLine(new Vector3f[]{new Vector3f(0,.66f,0), new Vector3f(.66f, .66f, 0),new Vector3f(1.33f,.66f,0), new Vector3f(2f, .66f, 0)}, numPoints);
        SuperLine superLine3 = new SuperLine(new Vector3f[]{new Vector3f(0,1f,0), new Vector3f(.66f, 1f, 0),new Vector3f(1.33f,1f,0), new Vector3f(2f, 1f, 0)}, numPoints);
        

    }
}
