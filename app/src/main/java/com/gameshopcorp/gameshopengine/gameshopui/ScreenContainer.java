package com.gameshopcorp.gameshopengine.gameshopui;

import com.jme3.math.Vector2f;

import java.util.HashMap;

public class ScreenContainer {

    public HashMap<String, Screen> screens;
    public String selectedScreen;
    public ScreenContainer(){
        screens = new HashMap<>();
        selectedScreen = "";
    }

    public void click(Vector2f point){
        screens.get(selectedScreen).click(point);
    }

    public String scroll(Vector2f point){
       return screens.get(selectedScreen).scroll(point);
    }

    public void clear(){
        screens.get(selectedScreen).clear();
    }

    public void changeScreen(String screen){
        clear();
        selectedScreen = screen;
        screens.get(selectedScreen).draw();
    }
}
