package com.gameshopcorp.gameshop.gameshopui;

import com.gameshopcorp.gameshop.app.App;
import com.gameshopcorp.gameshop.graphics.SimpleMesh;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.texture.Texture2D;

public class SimpleMeshUI extends SimpleMesh {
    public SimpleMeshUI(Vector3f[] vertices, Vector2f[] texCoord, Texture2D texture, Node node) {
        super(vertices, texCoord, texture, node);



        node.detachAllChildren();
        //*****RenderState*****

        // texture.setWrap(Texture.WrapMode.Repeat);
        // *************************************************************************
        // First mesh uses one solid color
        // *************************************************************************

        // Creating a geometry, and apply a single color material to it
        this.geom = new Geometry("OurMesh", m);


        mat = new Material(App.getInstance().app.getAssetManager(), "/MatDefs/GameShopUI.j3md");
        mat.getAdditionalRenderState().setFaceCullMode(RenderState.FaceCullMode.Off);
        mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        mat.setTransparent(true);
        mat.getAdditionalRenderState().setDepthTest(true);
        mat.getAdditionalRenderState().setDepthWrite(true);
        // mat.setColor("Color", ColorRGBA.fromRGBA255(255,255,255,255));
        mat.setTexture("ColorMap", this.texture);
        mat.setColor("Color", ColorRGBA.White);
        geom.setQueueBucket(RenderQueue.Bucket.Transparent);
        geom.setMaterial(mat);
        m.updateBound();
        node.attachChild(geom);
    }
}
