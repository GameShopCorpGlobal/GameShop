package com.gameshopcorp.gameshop.supermesh;

import com.gameshopcorp.gameshop.graphics.ATMS;
import com.gameshopcorp.gameshop.graphics.SuperLine;
import com.gameshopcorp.gameshop.graphics.SuperMesh;
import com.gameshopcorp.gameshop.graphics.SuperSurface;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

public class SuperSquare {

    public SuperMesh superMesh;
    public Node node;

    public ATMS atms;
    public String name;
    public SuperSquare(String name, ATMS atms, Node node, int numPoints, Vector3f bottomLeft, Vector3f bottomRight, Vector3f topLeft, Vector3f topRight){

        this.atms = atms;
        this.node = node;
        this.name = name;

        Vector3f a0 = new Vector3f(bottomLeft);
        Vector3f a3 = new Vector3f(bottomRight);

        Vector3f d0 = new Vector3f(topLeft);
        Vector3f d3 = new Vector3f(topRight);

        Vector3f a1 = FastMath.interpolateLinear(.33f, a0, a3);
        Vector3f a2 = FastMath.interpolateLinear(.66f, a0, a3);

        Vector3f b0 = FastMath.interpolateLinear(.33f, a0, d0);
        Vector3f c0 = FastMath.interpolateLinear(.66f, a0, d0);

        Vector3f d1 = FastMath.interpolateLinear(.33f, d0, d3);
        Vector3f d2 = FastMath.interpolateLinear(.66f, d0, d3);

        Vector3f b3 = FastMath.interpolateLinear(.33f, a3, d3);
        Vector3f c3 = FastMath.interpolateLinear(.66f, a3, d3);

        Vector3f b1 = FastMath.interpolateLinear(.33f, b0, b3);
        Vector3f b2 = FastMath.interpolateLinear(.66f, b0, b3);

        Vector3f c1 = FastMath.interpolateLinear(.33f, c0, c3);
        Vector3f c2 = FastMath.interpolateLinear(.66f, c0, c3);

        SuperLine a = new SuperLine(new Vector3f[]{a0,a1,a2,a3}, numPoints);
        SuperLine b = new SuperLine(new Vector3f[]{b0,b1,b2,b3}, numPoints);
        SuperLine c = new SuperLine(new Vector3f[]{c0,c1,c2,c3}, numPoints);
        SuperLine d = new SuperLine(new Vector3f[]{d0,d1,d2,d3}, numPoints);

        SuperSurface superSurface = new SuperSurface(new SuperLine[]{a, b, c, d}, this.atms, this.node );
        superMesh = new SuperMesh(new String[]{name}, new SuperSurface[]{superSurface});
    }
}
