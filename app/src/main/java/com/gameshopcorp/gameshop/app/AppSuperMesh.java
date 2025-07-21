package com.gameshopcorp.gameshop.app;

import com.gameshopcorp.gameshop.graphics.SuperMesh;

import java.util.HashMap;

public class AppSuperMesh {

    public HashMap<String, SuperMesh> superMeshes;
    private static AppSuperMesh _instance;

    private AppSuperMesh(){

        superMeshes = new HashMap<>();
    }

    public static AppSuperMesh getInstance(){

        if (_instance == null){
            _instance = new AppSuperMesh();
        }
        return _instance;
    }

}
