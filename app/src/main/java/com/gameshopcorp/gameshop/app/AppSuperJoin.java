package com.gameshopcorp.gameshop.app;

import com.gameshopcorp.gameshop.animation.join.SuperJoin;
import com.gameshopcorp.gameshop.animation.join.SuperJoinGroup;

import java.util.HashMap;

public class AppSuperJoin {


        public HashMap<String, SuperJoin> superJoins;
        public HashMap<String, SuperJoinGroup> superJoinGroups;

        private static AppSuperJoin _instance;

        private AppSuperJoin(){

            superJoins = new HashMap<>();
            superJoinGroups = new HashMap<>();
        }

        public static AppSuperJoin getInstance(){

            if (_instance == null){
                _instance = new AppSuperJoin();
            }
            return _instance;
        }

    }

