package com.gameshopcorp.gameshop.gameshopui;

import com.gameshopcorp.gameshop.app.App;
import com.gameshopcorp.gameshop.graphics.ATMS;
import com.gameshopcorp.gameshop.graphics.SuperLine;
import com.gameshopcorp.gameshop.graphics.SuperSurface;
import com.gameshopcorp.gameshop.supermesh.SuperSquare;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.texture.Texture2D;

public class SuperSquareUI extends SuperSquare{

    //public SuperMeshUI superMesh;

    public SuperSquareUI(String name, ATMS atms, Node node, int numPoints, Vector3f bottomLeft, Vector3f bottomRight, Vector3f topLeft, Vector3f topRight, Texture2D texture2D) {
        super(name, atms, node, numPoints, bottomLeft, bottomRight, topLeft, topRight, texture2D);

       /// node.detachAllChildren();
        superMesh.node.detachAllChildren();
        SuperSurfaceUI superSurfaceUI = new SuperSurfaceUI(new SuperLine[]{superSurface.currencyLines[0], superSurface.currencyLines[1], superSurface.currencyLines[2], superSurface.currencyLines[3]}, this.atms, this.node, texture2D);

       superMesh.node.attachChild(superSurfaceUI.node);
        App.getInstance().app.getRootNode().attachChild(superMesh.node);
        //node.attachChild(superSurfaceUI.node);
    }
}
