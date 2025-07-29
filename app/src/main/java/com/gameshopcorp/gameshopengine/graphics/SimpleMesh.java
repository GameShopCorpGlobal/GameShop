package com.gameshopcorp.gameshopengine.graphics;
import com.gameshopcorp.gameshopengine.app.App;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.VertexBuffer;
import com.jme3.texture.Texture2D;
import com.jme3.util.BufferUtils;

public class SimpleMesh {

    public Vector3f[] vertices;
    Vector2f[] texCoord;

    public Mesh m;

    public SimpleGeometry geom;

    public Material mat;

    public Texture2D texture;
    public SimpleMesh(SuperSurface superSurface, Vector3f[] vertices, Vector2f[] texCoord, Texture2D texture, Node node){

        this.texture = texture;

        m = new Mesh();

        // Vertex positions in space
        this.vertices = new Vector3f[4];
        this.vertices[0] = new Vector3f(vertices[0]);
        this.vertices[1] = new Vector3f(vertices[1]);
        this.vertices[2] = new Vector3f(vertices[2]);
        this.vertices[3] = new Vector3f(vertices[3]);

        // Texture coordinates
        this.texCoord = new Vector2f[4];
        this.texCoord[0] = new Vector2f(texCoord[0]); // new Vector2f(0,0);
        this.texCoord[1] = new Vector2f(texCoord[1]);//new Vector2f(1,0);
        this.texCoord[2] = new Vector2f(texCoord[2]);//new Vector2f(0,1);
        this.texCoord[3] = new Vector2f(texCoord[3]);//new Vector2f(1,1);

        // Indexes. We define the order in which mesh should be constructed
        short[] indexes = {2, 0, 1, 1, 3, 2};// 3, 2, 1, 2,1,0};
        //,2,3,1,1,0,2};



        // Setting buffers
        m.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(this.vertices));
        m.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(this.texCoord));
        m.setBuffer(VertexBuffer.Type.Index, 1, BufferUtils.createShortBuffer(indexes));

        m.updateBound();


        //*****RenderState*****

        // texture.setWrap(Texture.WrapMode.Repeat);
        // *************************************************************************
        // First mesh uses one solid color
        // *************************************************************************

        // Creating a geometry, and apply a single color material to it
        this.geom = new SimpleGeometry(superSurface, this);

        this.geom.setMesh(m);
        this.geom.setName("OurMesh");

        mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.getAdditionalRenderState().setFaceCullMode(RenderState.FaceCullMode.Off);
        mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        mat.setTransparent(true);
        mat.getAdditionalRenderState().setDepthTest(true);
        mat.getAdditionalRenderState().setDepthWrite(true);
        // mat.setColor("Color", ColorRGBA.fromRGBA255(255,255,255,255));
        mat.setTexture("ColorMap", this.texture);
        geom.setQueueBucket(RenderQueue.Bucket.Transparent);
        geom.setMaterial(mat);
        //geom.getMesh().scaleTextureCoordinates(new Vector2f(2, 2));

        // Attaching our geometry to the root node.
        //app.getRootNode().attachChild(geom);
        node.attachChild(geom);
    }

    public Vector2f get2DContactPointFrom3D(Vector3f contactPoint){

        //x/z , y/z

//        Vector3f midpoint = new Vector3f(vertices[0].add(vertices[1].add(vertices[2].add(vertices[3])))).divide(4);
//
//        float distanceNear = vertices[0].distance(contactPoint);
//        float distanceFar = vertices[3].distance(contactPoint);


        Vector3f distanceNearAxis = new Vector3f(contactPoint.x - vertices[0].x, contactPoint.y - vertices[0].y, contactPoint.z - vertices[0].z);
        //Vector3f distanceFarAxis = new Vector3f(vertices[3].x - contactPoint.x, vertices[3].y - contactPoint.y, vertices[3].z - contactPoint.z);

        Vector3f distanceAxis = new Vector3f(vertices[3].x - vertices[0].x, vertices[3].y - vertices[0].y, vertices[3].z - vertices[0].z);

        Vector3f totalPercentage = distanceNearAxis.divide(distanceAxis);

        String highestVal = "x";
        if (distanceAxis.y > distanceAxis.x){
            highestVal = "y";
        }
        if (distanceAxis.z > distanceAxis.y){
            highestVal = "z";
        }
        String lowestVal = "x";
        if (distanceAxis.y < distanceAxis.x){
            lowestVal = "y";
        }
        if (distanceAxis.z < distanceAxis.y){
            lowestVal = "z";
        }
        String midVal = "xyz";
       midVal = midVal.replace(highestVal, "");
       midVal = midVal.replace(lowestVal, "");

        Vector2f point = new Vector2f();
       if (highestVal.equals("x")){
           if (midVal.equals("y")){
               point = new Vector2f(totalPercentage.x, totalPercentage.y);
           }
       }
        if (highestVal.equals("x")){
            if (midVal.equals("z")){
                point = new Vector2f(totalPercentage.x, totalPercentage.z);

            }
        }
        if (highestVal.equals("y")){
            if (midVal.equals("x")){
                point = new Vector2f(totalPercentage.y, totalPercentage.x);

            }
        }
        if (highestVal.equals("y")){
            if (midVal.equals("z")){
                point = new Vector2f(totalPercentage.y, totalPercentage.z);

            }
        }
        if (highestVal.equals("z")){
            if (midVal.equals("x")){
                point = new Vector2f(totalPercentage.z, totalPercentage.x);

            }
        }
        if (highestVal.equals("z")){
            if (midVal.equals("y")){
                point = new Vector2f(totalPercentage.z, totalPercentage.y);

            }
        }

        System.out.println(point);
        //x2 + y2 + z2 = s2
        return point;
    }
}
