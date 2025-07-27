package com.gameshopcorp.gameshopengine.supermesh;

import com.gameshopcorp.gameshopengine.animation.join.SuperJoin;
import com.gameshopcorp.gameshopengine.graphics.SuperMesh;
import com.gameshopcorp.gameshopengine.graphics.SuperSurface;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;

import java.util.HashMap;

public class SuperCube {

    boolean debug = false;
    public SuperMesh superMesh;
    public HashMap<String, SuperJoin> superJoins;
    public SuperCube(SuperSquare top, SuperSquare bottom, SuperSquare front, SuperSquare back, SuperSquare left, SuperSquare right){


        superMesh = new SuperMesh(new String[]{"top","bottom","front","back","left","right"}, new SuperSurface[]{top.superMesh.superMesh.get(top.name), bottom.superMesh.superMesh.get(bottom.name), front.superMesh.superMesh.get(front.name), back.superMesh.superMesh.get(back.name), left.superMesh.superMesh.get(left.name), right.superMesh.superMesh.get(right.name)});

        if (debug){

            superMesh.superMesh.get("top").atms.layer.drawCircle(superMesh.superMesh.get("top").atms.width/2, superMesh.superMesh.get("top").atms.height/2, superMesh.superMesh.get("top").atms.width + superMesh.superMesh.get("top").atms.height, new Vector4f(0,0,255,255));
            superMesh.superMesh.get("top").updateSimpleMeshes();
            superMesh.superMesh.get("bottom").atms.layer.drawCircle(superMesh.superMesh.get("bottom").atms.width/2, superMesh.superMesh.get("bottom").atms.height/2, superMesh.superMesh.get("bottom").atms.width + superMesh.superMesh.get("bottom").atms.height, new Vector4f(255,0,0,255));
            superMesh.superMesh.get("bottom").updateSimpleMeshes();
            superMesh.superMesh.get("front").atms.layer.drawCircle(superMesh.superMesh.get("front").atms.width/2, superMesh.superMesh.get("front").atms.height/2, superMesh.superMesh.get("front").atms.width + superMesh.superMesh.get("front").atms.height, new Vector4f(0,255,0,255));
            superMesh.superMesh.get("front").updateSimpleMeshes();
            superMesh.superMesh.get("back").atms.layer.drawCircle(superMesh.superMesh.get("back").atms.width/2, superMesh.superMesh.get("back").atms.height/2, superMesh.superMesh.get("back").atms.width + superMesh.superMesh.get("back").atms.height, new Vector4f(255,0,255,255));
            superMesh.superMesh.get("back").updateSimpleMeshes();
            superMesh.superMesh.get("left").atms.layer.drawCircle(superMesh.superMesh.get("left").atms.width/2, superMesh.superMesh.get("left").atms.height/2, superMesh.superMesh.get("left").atms.width + superMesh.superMesh.get("left").atms.height, new Vector4f(0,255,255,255));
            superMesh.superMesh.get("left").updateSimpleMeshes();
            superMesh.superMesh.get("right").atms.layer.drawCircle(superMesh.superMesh.get("right").atms.width/2, superMesh.superMesh.get("right").atms.height/2, superMesh.superMesh.get("right").atms.width + superMesh.superMesh.get("right").atms.height, new Vector4f(255,255,0,255));
            superMesh.superMesh.get("right").updateSimpleMeshes();

        }


        superJoins = new HashMap<>();

        SuperJoin topFrontLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("front"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(3,3)});
        SuperJoin topFrontRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("front"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(3,3), new Vector2f(3,3), new Vector2f(3,3)});
        SuperJoin topBackLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("back"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(0,0), new Vector2f(3,0), new Vector2f(3,0)});
        SuperJoin topBackRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("back"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(0,3), new Vector2f(3,3), new Vector2f(3,0)});

        SuperJoin bottomFrontLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("front"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(0,0), new Vector2f(0,3)});
        SuperJoin bottomFrontRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("front"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(3,3), new Vector2f(0,3), new Vector2f(0,3)});
        SuperJoin bottomBackLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("back"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(0,0), new Vector2f(0,0), new Vector2f(0,0)});
        SuperJoin bottomBackRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("back"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(0,3), new Vector2f(0,3), new Vector2f(0,0)});

        SuperJoin edgeTopFrontMidLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(3,1), new Vector2f(3,1)});
        SuperJoin edgeTopFrontMidRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(3,2), new Vector2f(3,2)});
        SuperJoin edgeBottomFrontMidLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(3,1), new Vector2f(0,1)});
        SuperJoin edgeBottomFrontMidRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(3,2), new Vector2f(0,2)});

        SuperJoin edgeTopBackMidLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("back")}, new Vector2f[]{new Vector2f(0,1), new Vector2f(3,1)});
        SuperJoin edgeTopBackMidRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("back")}, new Vector2f[]{new Vector2f(0,2), new Vector2f(3,2)});
        SuperJoin edgeBottomBackMidLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("back")}, new Vector2f[]{new Vector2f(0,1), new Vector2f(0,1)});
        SuperJoin edgeBottomBackMidRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("back")}, new Vector2f[]{new Vector2f(0,2), new Vector2f(0,2)});

        SuperJoin edgeFrontLeftMidTop = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(2,0), new Vector2f(2,3)});
        SuperJoin edgeFrontLeftMidBottom = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(1,0), new Vector2f(1,3)});
        SuperJoin edgeFrontRightMidTop = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(2,3), new Vector2f(2,3)});
        SuperJoin edgeFrontRightMidBottom = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(1,3), new Vector2f(1,3)});

        SuperJoin edgeBackLeftMidTop = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(2,0), new Vector2f(2,0)});
        SuperJoin edgeBackLeftMidBottom = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(1,0), new Vector2f(1,0)});
        SuperJoin edgeBackRightMidTop = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(2,3), new Vector2f(2,0)});
        SuperJoin edgeBackRightMidBottom = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(1,3), new Vector2f(1,0)});

        SuperJoin edgeLeftTopMidFront = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,2), new Vector2f(2,0)});
        SuperJoin edgeLeftTopMidBack = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,1), new Vector2f(1,0)});
        SuperJoin edgeLeftBottomMidFront = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,2), new Vector2f(2,0)});
        SuperJoin edgeLeftBottomMidBack = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,1), new Vector2f(1,0)});

        SuperJoin edgeRightTopMidFront = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,2), new Vector2f(2,3)});
        SuperJoin edgeRightTopMidBack = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,1), new Vector2f(1,3)});
        SuperJoin edgeRightBottomMidFront = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,2), new Vector2f(2,3)});
        SuperJoin edgeRightBottomMidBack = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,1), new Vector2f(1,3)});


        //SuperJoin topFrontRight = new SuperJoin()
        //edgeRightBottomMidBack.moveJoin(new Vector3f( 1,-1,0));

        superJoins.put("topFrontLeft", topFrontLeft);
        superJoins.put("topFrontRight", topFrontRight);
        superJoins.put("topBackLeft", topBackLeft);
        superJoins.put("topBackRight", topBackRight);

        superJoins.put("bottomFrontLeft", bottomFrontLeft);
        superJoins.put("bottomFrontRight",bottomFrontRight);
        superJoins.put("bottomBackLeft", bottomBackLeft);
        superJoins.put("bottomBackRight", bottomBackRight);

        superJoins.put("edgeTopFrontMidLeft", edgeTopFrontMidLeft);
        superJoins.put("edgeTopFrontMidRight", edgeTopFrontMidRight);
        superJoins.put("edgeBottomFrontMidLeft", edgeBottomFrontMidLeft);
        superJoins.put("edgeBottomFrontMidRight", edgeBottomFrontMidRight);

        superJoins.put("edgeTopBackMidLeft", edgeTopBackMidLeft);
        superJoins.put("edgeTopBackMidRight", edgeTopBackMidRight);
        superJoins.put("edgeBottomBackMidLeft", edgeBottomBackMidLeft);
        superJoins.put("edgeBottomBackMidRight", edgeBottomBackMidRight);

        superJoins.put("edgeFrontLeftMidTop", edgeFrontLeftMidTop);
        superJoins.put("edgeFrontLeftMidBottom", edgeFrontLeftMidBottom);
        superJoins.put("edgeFrontRightMidTop", edgeFrontRightMidTop);
        superJoins.put("edgeFrontRightMidBottom", edgeFrontRightMidBottom);

        superJoins.put("edgeBackLeftMidTop", edgeBackLeftMidTop);
        superJoins.put("edgeBackLeftMidBottom", edgeBackLeftMidBottom);
        superJoins.put("edgeBackRightMidTop", edgeBackRightMidTop);
        superJoins.put("edgeBackRightMidBottom", edgeBackRightMidBottom);

        superJoins.put("edgeLeftTopMidFront", edgeLeftTopMidFront);
        superJoins.put("edgeLeftTopMidBack", edgeLeftTopMidBack);
        superJoins.put("edgeLeftBottomMidFront", edgeLeftBottomMidFront);
        superJoins.put("edgeLeftBottomMidBack", edgeLeftBottomMidBack);

        superJoins.put("edgeRightTopMidFront", edgeRightTopMidFront);
        superJoins.put("edgeRightTopMidBack", edgeRightTopMidBack);
        superJoins.put("edgeRightBottomMidFront", edgeRightBottomMidFront);
        superJoins.put("edgeRightBottomMidBack", edgeRightBottomMidBack);

        superMesh.superJoins = superJoins;
    }

}
