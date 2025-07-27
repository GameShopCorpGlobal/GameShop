package com.gameshopcorp.gameshopengine.animation.join;

import com.jme3.math.Vector3f;

import java.util.ArrayList;
import java.util.Arrays;

public class SuperJoinGroup {

    ArrayList<SuperJoin> superJoins;
    public SuperJoinGroup(SuperJoin... superJoins){

        this.superJoins = new ArrayList<>(Arrays.asList(superJoins));
    }

    public void moveJoin(Vector3f move){

        for (SuperJoin sj: superJoins){
            sj.moveJoin(move);
        }
    }

    public void moveJoinWithScale(Vector3f move){

        for (SuperJoin sj: superJoins){
            sj.moveJoinWithScale(move);
        }
    }
}
