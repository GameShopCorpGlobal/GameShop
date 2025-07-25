package com.gameshopcorp.gameshop.gameshopui;

import com.gameshopcorp.gameshop.app.App;
import com.gameshopcorp.gameshop.graphics.ATMS;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.math.Vector2f;
import com.jme3.texture.Texture2D;
import com.jme3.ui.Picture;

import java.util.ArrayList;

public class Omni {

    //public ArrayList<Omni> omnis;
    public ATMS atms;
    public Vector2f start;
    public Vector2f end;
    public String text;
    public Picture pic;
    public Omni(String text, ATMS atms, Vector2f start, Vector2f end){

        this.text = text;
        this.atms = atms;
        //this.omnis = new ArrayList<>();
        this.start = start;
        this.end = end;
        this.pic = new Picture("Omni");
        this.pic.setPosition(start.x, start.y);
        this.pic.setHeight(end.y - start.y);
        this.pic.setWidth(end.x - start.x);

    }

    public void draw(){

        pic.setTexture(App.getInstance().app.getAssetManager(), new Texture2D(atms.makeATMS()), true);
        App.getInstance().app.getGuiNode().attachChild(pic);
        drawText();
       // drawContainer();
    }

    public void drawText(){

        BitmapFont guiFont = App.getInstance().app.getAssetManager().loadFont("/Fonts/GoogleSans.fnt");
        BitmapText helloText = new BitmapText(guiFont);
        helloText.setSize(guiFont.getCharSet().getRenderedSize());
        helloText.setText(text);
        helloText.setLocalTranslation(((start.x + end.x)/2f) -((start.x + end.x)/16f)  , ((start.y + end.y)/2f) , 0);
        App.getInstance().app.getGuiNode().attachChild(helloText);

    }

//    public void drawContainer(){
//
//        for (Omni o: omnis){
//
//            if (o.start.x > start.x && o.start.y > start.y && o.end.x < end.x && o.end.y < end.y){
//                o.draw();
//            }
//
//        }
//
//    }

    public void onClick(){

    }
//    public void onClick(Vector2f position){
//
//        for (Omni o: omnis){
//            if (position.x > o.start.x && position.x < o.end.x && position.y > o.start.y && position.y < o.end.y){
//                o.onClick(position);
//            }
//        }
//
//    }
}
