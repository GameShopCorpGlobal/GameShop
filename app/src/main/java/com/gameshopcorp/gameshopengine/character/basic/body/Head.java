package com.gameshopcorp.gameshopengine.character.basic.body;

import com.gameshopcorp.gameshopengine.character.basic.body.base.Base;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

public class Head extends Base {

    public Head(int numPoints, Vector4f baseColor){
        super(numPoints, baseColor);

        this.superMesh.superJoins.get("bottomFrontLeft").moveJoin(new Vector3f(.25f,.25f,-.25f));

        this.superMesh.superJoins.get("edgeBottomFrontMidLeft").moveJoin(new Vector3f(0,-.15f,-.1f));

        this.superMesh.superJoins.get("edgeLeftBottomMidFront").moveJoin(new Vector3f(0, -.5f, 0f));
        this.superMesh.superJoins.get("edgeLeftBottomMidBack").moveJoin(new Vector3f(0, -.25f, -.25f));

        this.superMesh.superJoins.get("bottomBackLeft").moveJoin(new Vector3f(0,.25f,0));
        this.superMesh.superJoins.get("topBackLeft").moveJoin(new Vector3f(0,.25f,-.25f));

        this.superMesh.superJoins.get("edgeBackLeftMidBottom").moveJoin(new Vector3f(0,0,-.5f));
        this.superMesh.superJoins.get("edgeBackLeftMidTop").moveJoin(new Vector3f(0,0,-.5f));

        this.superMesh.superJoins.get("edgeLeftTopMidFront").moveJoin(new Vector3f(0, .5f, 0f));
        this.superMesh.superJoins.get("edgeLeftTopMidBack").moveJoin(new Vector3f(0, .5f, 0f));

        //

        this.superMesh.superJoins.get("bottomFrontRight").moveJoin(new Vector3f(-.25f,.25f,-.25f));

        this.superMesh.superJoins.get("edgeBottomFrontMidRight").moveJoin(new Vector3f(0,-.15f,-.1f));

        this.superMesh.superJoins.get("edgeRightBottomMidFront").moveJoin(new Vector3f(0, -.5f, 0f));
        this.superMesh.superJoins.get("edgeRightBottomMidBack").moveJoin(new Vector3f(0, -.25f, -.25f));

        this.superMesh.superJoins.get("bottomBackRight").moveJoin(new Vector3f(0,.25f,0));
        this.superMesh.superJoins.get("topBackRight").moveJoin(new Vector3f(0,.25f,-.25f));

        this.superMesh.superJoins.get("edgeBackRightMidBottom").moveJoin(new Vector3f(0,0,-.5f));
        this.superMesh.superJoins.get("edgeBackRightMidTop").moveJoin(new Vector3f(0,0,-.5f));

        this.superMesh.superJoins.get("edgeRightTopMidFront").moveJoin(new Vector3f(0, .5f, 0f));
        this.superMesh.superJoins.get("edgeRightTopMidBack").moveJoin(new Vector3f(0, .5f, 0f));

        //

        this.superMesh.superMesh.get("front").moveSuperLine((byte) 1, (byte) 1,new Vector3f(0,0,.33f));
        this.superMesh.superMesh.get("front").moveSuperLine((byte) 1, (byte) 2,new Vector3f(0,0,.33f));
        this.superMesh.superMesh.get("front").moveSuperLine((byte) 2, (byte) 1,new Vector3f(0,0,.33f));
        this.superMesh.superMesh.get("front").moveSuperLine((byte) 2, (byte) 2,new Vector3f(0,0,.33f));

        //

        this.superMesh.superMesh.get("top").moveSuperLine((byte) 1, (byte) 1,new Vector3f(0,1,0));
        this.superMesh.superMesh.get("top").moveSuperLine((byte) 1, (byte) 2,new Vector3f(0,1,0));
        this.superMesh.superMesh.get("top").moveSuperLine((byte) 2, (byte) 1,new Vector3f(0,1,0));
        this.superMesh.superMesh.get("top").moveSuperLine((byte) 2, (byte) 2,new Vector3f(0,1,0));

        //

        this.superMesh.superJoins.get("edgeTopFrontMidLeft").moveJoin(new Vector3f(0,.5f, .25f));
        this.superMesh.superJoins.get("edgeTopFrontMidRight").moveJoin(new Vector3f(0,.5f, .25f));

        //

        this.superMesh.superJoins.get("edgeTopBackMidLeft").moveJoin(new Vector3f(0,.5f, -.25f));
        this.superMesh.superJoins.get("edgeTopBackMidRight").moveJoin(new Vector3f(0,.5f, -.25f));

        //

        this.superMesh.superMesh.get("left").moveSuperLine((byte) 1, (byte) 1,new Vector3f(-.33f,.45f,0));
        this.superMesh.superMesh.get("left").moveSuperLine((byte) 1, (byte) 2,new Vector3f(-.33f,.45f,0));
        this.superMesh.superMesh.get("left").moveSuperLine((byte) 2, (byte) 1,new Vector3f(-.33f,.25f,0));
        this.superMesh.superMesh.get("left").moveSuperLine((byte) 2, (byte) 2,new Vector3f(-.33f,.25f,0));

        //

        this.superMesh.superMesh.get("right").moveSuperLine((byte) 1, (byte) 1,new Vector3f(.33f,.45f,0));
        this.superMesh.superMesh.get("right").moveSuperLine((byte) 1, (byte) 2,new Vector3f(.33f,.45f,0));
        this.superMesh.superMesh.get("right").moveSuperLine((byte) 2, (byte) 1,new Vector3f(.33f,.25f,0));
        this.superMesh.superMesh.get("right").moveSuperLine((byte) 2, (byte) 2,new Vector3f(.33f,.25f,0));

        //

        this.superMesh.superMesh.get("back").moveSuperLine((byte) 1, (byte) 1,new Vector3f(0,0,-.75f));
        this.superMesh.superMesh.get("back").moveSuperLine((byte) 1, (byte) 2,new Vector3f(0,0,-.75f));
        this.superMesh.superMesh.get("back").moveSuperLine((byte) 2, (byte) 1,new Vector3f(0,0,-.75f));
        this.superMesh.superMesh.get("back").moveSuperLine((byte) 2, (byte) 2,new Vector3f(0,0,-.75f));

        //

        this.superMesh.superMesh.get("bottom").moveSuperLine((byte) 1, (byte) 1,new Vector3f(0,-.75f,0));
        this.superMesh.superMesh.get("bottom").moveSuperLine((byte) 1, (byte) 2,new Vector3f(0,-.75f,0));
        this.superMesh.superMesh.get("bottom").moveSuperLine((byte) 2, (byte) 1,new Vector3f(0,-.75f,0));
        this.superMesh.superMesh.get("bottom").moveSuperLine((byte) 2, (byte) 2,new Vector3f(0,-.75f,0));



    }
}
