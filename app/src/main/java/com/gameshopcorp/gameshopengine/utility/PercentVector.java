package com.gameshopcorp.gameshopengine.utility;

import com.jme3.math.Vector2f;

public class PercentVector {

    public Vector2f whole;
    public PercentVector(Vector2f whole){

        this.whole = whole;
    }

    public Vector2f percent(Vector2f percentage){

        return new Vector2f((whole.x * percentage.x)/100f, (whole.y * percentage.y)/100f);

    }

    public Vector2f percent(float x, float y){

        return percent(new Vector2f(x, y));
    }

    public Vector2f wholeToPercentage(Vector2f whole){

        return (new Vector2f((whole.x/this.whole.x) * 100f, (whole.y/this.whole.y) * 100f));
    }
}
