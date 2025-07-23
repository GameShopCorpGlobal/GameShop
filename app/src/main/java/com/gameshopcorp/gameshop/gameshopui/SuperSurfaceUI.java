package com.gameshopcorp.gameshop.gameshopui;

import com.gameshopcorp.gameshop.graphics.ATMS;
import com.gameshopcorp.gameshop.graphics.SuperLine;
import com.gameshopcorp.gameshop.graphics.SuperSurface;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.texture.Texture2D;

public class SuperSurfaceUI extends SuperSurface {
    public SimpleMeshUI[] simpleMeshes;
    public SuperSurfaceUI(SuperLine[] currencyLines, ATMS atms, Node node, Texture2D texture2D) {
        super(currencyLines, atms, node, texture2D);

    }

    @Override
    public void setImageArray(){
        int imageArray = 1;

        width = this.vInfinitesimals.length;
        height = this.vInfinitesimals[0].infinitesimals.length;

        imageArray = (int)width * (int)height;

        simpleMeshes = new SimpleMeshUI[imageArray];
    }

    @Override
    public void drawSimpleMeshes(){
        int maxX = this.vInfinitesimals[0].infinitesimals.length - 1;
        int maxY = this.vInfinitesimals.length - 1;

        this.maxX = maxX;
        this.maxY = maxY;

        for (int y = 0; y < maxY; y++){
            for (int x = 0; x < maxX; x++){

                Vector3f[] simpleMesh = new Vector3f[4];

                // if (texture2D == null) {
                simpleMesh[0] = this.vInfinitesimals[y].infinitesimals[x];
                simpleMesh[1] = this.vInfinitesimals[y + 1].infinitesimals[x];
                simpleMesh[2] = this.vInfinitesimals[y].infinitesimals[x + 1];
                simpleMesh[3] = this.vInfinitesimals[y + 1].infinitesimals[x + 1];
//                } else {
//                    simpleMesh[2] = this.vInfinitesimals[y].infinitesimals[x];
//                    simpleMesh[1] = this.vInfinitesimals[y + 1].infinitesimals[x];
//                    simpleMesh[0] = this.vInfinitesimals[y].infinitesimals[x + 1];
//                    simpleMesh[3] = this.vInfinitesimals[y + 1].infinitesimals[x + 1];
//                }
//                simpleMesh[0] = this.vInfinitesimals[y + 1].infinitesimals[x];
//                simpleMesh[1] = this.vInfinitesimals[y].infinitesimals[x];
//                simpleMesh[2] = this.vInfinitesimals[y].infinitesimals[x + 1];
//                simpleMesh[3] = this.vInfinitesimals[y + 1].infinitesimals[x + 1];




                Vector2f[] texCoord = new Vector2f[4];

                /*
                Vector2f distance = new Vector2f(((this.vInfinitesimals[maxY].infinitesimals[maxX].x) - (this.vInfinitesimals[0].infinitesimals[0].x)), ((this.vInfinitesimals[maxY].infinitesimals[maxX].y) - (this.vInfinitesimals[0].infinitesimals[0].y)));
                Vector2f base = new Vector2f(this.vInfinitesimals[0].infinitesimals[0].x, this.vInfinitesimals[0].infinitesimals[0].y);

                texCoord[0] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x].y - base.y)/distance.y)); // new Vector2f(0,0);
                texCoord[1] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x].y - base.y )/distance.y));//new Vector2f(1,0);
                texCoord[2] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x + 1].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(0,1);
                texCoord[3] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x + 1].x) - base.x)/distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(1,1);

                */
                //if (texture2D == null) {
                texCoord[0] = new Vector2f((float) x / maxX, (float) y / maxY);
                texCoord[1] = new Vector2f((float) x / maxX, (float) (y + 1) / maxY);
                texCoord[2] = new Vector2f((float) (x + 1) / maxX, (float) y / maxY);
                texCoord[3] = new Vector2f((float) (x + 1) / maxX, (float) (y + 1) / maxY);
//                } else {
//                    texCoord[2] = new Vector2f((float) x / maxX, (float) (y + 1) / maxY);
//                    texCoord[1] = new Vector2f((float) (x + 1) / maxX, (float) y / maxY);
//                    texCoord[0] = new Vector2f((float) (x + 1) / maxX, (float) (y + 1) / maxY);
//                    texCoord[3] = new Vector2f((float) x / maxX, (float) y / maxY);
//
//                }
                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x] = new SimpleMeshUI(simpleMesh, texCoord, getTexture2D(), node);

            }
        }
    }
}
