package com.gameshopcorp.gameshop.character.basic.body;

import com.gameshopcorp.gameshop.character.basic.body.base.Base;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

public class Neck extends Base {

    //Like A Cylinder
    public Neck(int numPoints, Vector4f baseColor){
        super(numPoints, baseColor);

        this.superMesh.superJoins.get("topFrontLeft").moveJoin(new Vector3f(.25f,0f,.25f));
        this.superMesh.superJoins.get("topFrontRight").moveJoin(new Vector3f(-.25f,0f,.25f));
        this.superMesh.superJoins.get("topBackLeft").moveJoin(new Vector3f(.25f,0f,-.25f));
        this.superMesh.superJoins.get("topBackRight").moveJoin(new Vector3f(-.25f,0f,-.25f));

        //

        this.superMesh.superJoins.get("bottomFrontLeft").moveJoin(new Vector3f(-.25f,0f,-.25f));
        this.superMesh.superJoins.get("bottomFrontRight").moveJoin(new Vector3f(.25f,0f,-.25f));
        this.superMesh.superJoins.get("bottomBackLeft").moveJoin(new Vector3f(-.25f,0f,.25f));
        this.superMesh.superJoins.get("bottomBackRight").moveJoin(new Vector3f(.25f,0f,.25f));

        //

        this.superMesh.superJoins.get("edgeTopFrontMidLeft").moveJoin(new Vector3f(0f,0f,.35f));
        this.superMesh.superJoins.get("edgeTopFrontMidRight").moveJoin(new Vector3f(0f,0f,.35f));
        this.superMesh.superJoins.get("edgeTopBackMidLeft").moveJoin(new Vector3f(0f,0f,-.35f));
        this.superMesh.superJoins.get("edgeTopBackMidRight").moveJoin(new Vector3f(0f,0f,-.35f));

        this.superMesh.superJoins.get("edgeLeftTopMidFront").moveJoin(new Vector3f(-.35f,0f,0f));
        this.superMesh.superJoins.get("edgeLeftTopMidBack").moveJoin(new Vector3f(-.35f,0f,0f));
        this.superMesh.superJoins.get("edgeRightTopMidFront").moveJoin(new Vector3f(.35f,0f,0f));
        this.superMesh.superJoins.get("edgeRightTopMidBack").moveJoin(new Vector3f(.35f,0f,0f));

        //


        this.superMesh.superJoins.get("edgeBottomFrontMidLeft").moveJoin(new Vector3f(0f,0f,.35f));
        this.superMesh.superJoins.get("edgeBottomFrontMidRight").moveJoin(new Vector3f(0f,0f,.35f));
        this.superMesh.superJoins.get("edgeBottomBackMidLeft").moveJoin(new Vector3f(0f,0f,-.35f));
        this.superMesh.superJoins.get("edgeBottomBackMidRight").moveJoin(new Vector3f(0f,0f,-.35f));

        this.superMesh.superJoins.get("edgeLeftBottomMidFront").moveJoin(new Vector3f(-.35f,0f,0f));
        this.superMesh.superJoins.get("edgeLeftBottomMidBack").moveJoin(new Vector3f(-.35f,0f,0f));
        this.superMesh.superJoins.get("edgeRightBottomMidFront").moveJoin(new Vector3f(.35f,0f,0f));
        this.superMesh.superJoins.get("edgeRightBottomMidBack").moveJoin(new Vector3f(.35f,0f,0f));

    }
}
