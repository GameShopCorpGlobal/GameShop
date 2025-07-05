package com.gameshopcorp.gameshop.app;

import com.jme3.app.SimpleApplication;

public class App {

    public SimpleApplication app;
    private static App _instance;

    private App(){

    }

    public static App getInstance(){

        if (_instance == null){
            _instance = new App();
        }
        return _instance;
    }

}
