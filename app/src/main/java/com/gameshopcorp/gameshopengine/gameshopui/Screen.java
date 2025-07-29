package com.gameshopcorp.gameshopengine.gameshopui;

import com.jme3.math.Vector2f;

import java.util.ArrayList;

public class Screen {

    public ArrayList<Omni> omnis;
    //public ATMS atms;
    public Screen(){

       // this.atms = atms;
        omnis = new ArrayList<>();

    }

    public void click(Vector2f position){

        for (Omni o: omnis){
            if (position.x > o.start.x && position.x < o.end.x && position.y > o.start.y && position.y < o.end.y){
                o.onClick(position);
            }
        }
    }

    public void draw(){
        onDraw();

        for (Omni o: omnis){
            o.draw();
        }
    }

    public void clear(){
        for (Omni o: omnis){
            o.detachNode();
        }
    }

    public void onDraw(){

    }
}
