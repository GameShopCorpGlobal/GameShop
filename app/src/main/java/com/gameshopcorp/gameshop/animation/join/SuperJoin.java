package com.gameshopcorp.gameshop.animation.join;

import com.gameshopcorp.gameshop.graphics.SuperSurface;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;

public class SuperJoin {

    public SuperSurface[] superSurfaces;
    public Vector2f[] points;
    public SuperJoin(SuperSurface[] superSurfaces, Vector2f[] points){

        this.superSurfaces = superSurfaces;
        this.points = points;

    }

    public void moveJoin(Vector3f move){

        for (int i = 0; i < superSurfaces.length; i++){

            superSurfaces[i].moveSuperLine((byte) points[i].x, (byte) points[i].y, new Vector3f(move));

        }

    }

    public void moveJoinWithScale(Vector3f move){
        for (int i = 0; i < superSurfaces.length; i++){

            Vector3f scale = superSurfaces[i].node.getLocalScale();
            superSurfaces[i].moveSuperLine((byte) points[i].x, (byte) points[i].y, new Vector3f(move).divide(scale));

        }
    }
}
