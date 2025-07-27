package com.gameshopcorp.gameshopengine.app;

import com.gameshopcorp.gameshopengine.MyGame;

public class App {

    public MyGame app;
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
