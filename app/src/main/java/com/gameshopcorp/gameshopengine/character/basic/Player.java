package com.gameshopcorp.gameshopengine.character.basic;

import com.gameshopcorp.gameshopengine.character.basic.body.Body;
import com.gameshopcorp.gameshopengine.character.basic.body.Head;
import com.gameshopcorp.gameshopengine.character.basic.body.Neck;
import com.jme3.math.Vector4f;

public class Player {

    public Player(){

        Head head = new Head(7, new Vector4f(255,215,172,255));
        Neck neck = new Neck(7, new Vector4f(255,215,172,255));
        neck.superMesh.node.scale(.5f,1.5f, .5f);
        neck.superMesh.node.move(.25f,-1f,-.25f);
        Body body = new Body(7, new Vector4f(255,215,172,255));
        body.superMesh.node.scale(3,1,1);
        body.superMesh.node.move(-1f,-2,-.5f);

    }
}
