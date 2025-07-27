package com.gameshopcorp.gameshopengine.character.basic.body.base;

//import com.gameshopcorp.heroes.supermesh.SuperCube;

import com.gameshopcorp.gameshopengine.graphics.ATMS;
import com.gameshopcorp.gameshopengine.graphics.SuperMesh;
import com.gameshopcorp.gameshopengine.supermesh.SuperCube;
import com.gameshopcorp.gameshopengine.supermesh.SuperSquare;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.scene.Node;

public class Base {

    public SuperMesh superMesh;


    public Base(int numPoints, Vector4f baseColor){

        ATMS atmsTop = new ATMS("Top", 128,128);
        atmsTop.layer.drawCircle(64,64, 128, baseColor);
        ATMS atmsBottom = new ATMS("Top", 128,128);
        atmsBottom.layer.drawCircle(64,64, 128, baseColor);
        ATMS atmsLeft = new ATMS("Top", 128,128);
        atmsLeft.layer.drawCircle(64,64, 128, baseColor);
        ATMS atmsRight = new ATMS("Top", 128,128);
        atmsRight.layer.drawCircle(64,64, 128, baseColor);
        ATMS atmsFront = new ATMS("Top", 128,128);
        atmsFront.layer.drawCircle(64,64, 128, baseColor);
        ATMS atmsBack = new ATMS("Top", 128,128);
        atmsBack.layer.drawCircle(64,64, 128, baseColor);



        SuperSquare sTop = new SuperSquare("top", atmsTop, new Node("top"), numPoints, new Vector3f(0,1,0), new Vector3f(1,1,0),new Vector3f(0,1,1),new Vector3f(1,1,1), null);
        SuperSquare sBottom = new SuperSquare("bottom", atmsBottom, new Node("bottom"), numPoints, new Vector3f(0,0,0), new Vector3f(1,0,0),new Vector3f(0,0,1),new Vector3f(1,0,1), null);
        SuperSquare sFront = new SuperSquare("front", atmsFront, new Node("front"), numPoints, new Vector3f(0,0,1), new Vector3f(1,0,1),new Vector3f(0,1,1),new Vector3f(1,1,1), null);
        SuperSquare sBack = new SuperSquare("back", atmsBack, new Node("back"), numPoints, new Vector3f(0,0,0), new Vector3f(1,0,0),new Vector3f(0,1,0),new Vector3f(1,1,0), null);
        SuperSquare sLeft = new SuperSquare("left", atmsLeft, new Node("left"), numPoints, new Vector3f(0,0,0), new Vector3f(0,0,1),new Vector3f(0,1,0),new Vector3f(0,1,1), null);
        SuperSquare sRight = new SuperSquare("right", atmsRight, new Node("right"), numPoints, new Vector3f(1,0,0), new Vector3f(1,0,1),new Vector3f(1,1,0),new Vector3f(1,1,1), null);

        SuperCube superCube = new SuperCube(sTop, sBottom, sFront, sBack, sLeft, sRight);

        superMesh = superCube.superMesh;
    }
}
