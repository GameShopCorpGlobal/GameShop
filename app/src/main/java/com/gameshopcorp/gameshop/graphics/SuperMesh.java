package com.gameshopcorp.gameshop.graphics;

import com.gameshopcorp.gameshop.animation.join.SuperJoin;
import com.gameshopcorp.gameshop.app.App;
import com.jme3.scene.Node;

import java.util.HashMap;

public class SuperMesh {

    public HashMap<String, SuperSurface> superMesh;
    public HashMap<String, SuperJoin> superJoins;
    public Node node;
    public SuperMesh(String[] names, SuperSurface[] superSurfaces){

        superMesh = new HashMap<>();
        superJoins = new HashMap<>();
//        linkNames = new HashMap<>();
//        linkValues = new HashMap<>();

        node = new Node("SuperMesh");
        int i = 0;
        for (String s: names){

            superMesh.put(s, superSurfaces[i]);
            node.attachChild(superSurfaces[i].node);
            i++;

        }

        App.getInstance().app.getRootNode().attachChild(node);


    }

}
