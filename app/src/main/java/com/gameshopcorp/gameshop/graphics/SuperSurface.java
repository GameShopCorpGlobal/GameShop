package com.gameshopcorp.gameshop.graphics;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.VertexBuffer;
import com.jme3.texture.Texture2D;
import com.jme3.util.BufferUtils;

public class SuperSurface {

    public SuperLine[] vInfinitesimals;
    public SimpleMesh[] simpleMeshes;

    public SuperLine[] currencyLines;
    public float width;
    public float height;

    public float dim;

    //SimpleApplication app;

    public ATMS atms;
    //Texture2D texture;
    public Node node;

    public SuperSurface(SuperLine[] currencyLines, ATMS atms, Node node){

        //this.app = app;
        this.currencyLines = currencyLines;
        //this.texture = texture;
        this.atms = atms;
        this.node = node;

        setDimensions();
        setImageArray();
        drawSimpleMeshes();

    }

//    public void updateTexture(Texture2D texture){
//        this.texture = texture;
//    }
    public SimpleMesh getMeshFromValue(int x, int y){

        return  simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * x) + y];
    }

    public void setSuperLine(byte line, byte point, Vector3f newPoint){
        this.currencyLines[line].setSuperLine(point, newPoint);
        for (int i = 0; i < this.vInfinitesimals.length; i++){

            this.vInfinitesimals[i].setSuperLine((byte) 0, currencyLines[0].infinitesimals[i]); ;//= new CurrencyLine(new Vector3f[]{currencyLines[0].infinitesimals[i], currencyLines[1].infinitesimals[i], currencyLines[2].infinitesimals[i], currencyLines[3].infinitesimals[i]}, (byte)16);
            this.vInfinitesimals[i].setSuperLine((byte) 1, currencyLines[1].infinitesimals[i]);
            this.vInfinitesimals[i].setSuperLine((byte) 2, currencyLines[2].infinitesimals[i]);
            this.vInfinitesimals[i].setSuperLine((byte) 3, currencyLines[3].infinitesimals[i]);
        }
        updateSimpleMeshes();
    }

    public void moveSuperLine(byte line, byte point, Vector3f movePoint){
        this.currencyLines[line].moveSuperLine(point, movePoint);
        for (int i = 0; i < this.vInfinitesimals.length; i++){

            this.vInfinitesimals[i].setSuperLine((byte) 0, currencyLines[0].infinitesimals[i]); ;//= new CurrencyLine(new Vector3f[]{currencyLines[0].infinitesimals[i], currencyLines[1].infinitesimals[i], currencyLines[2].infinitesimals[i], currencyLines[3].infinitesimals[i]}, (byte)16);
            this.vInfinitesimals[i].setSuperLine((byte) 1, currencyLines[1].infinitesimals[i]);
            this.vInfinitesimals[i].setSuperLine((byte) 2, currencyLines[2].infinitesimals[i]);
            this.vInfinitesimals[i].setSuperLine((byte) 3, currencyLines[3].infinitesimals[i]);
        }
        updateSimpleMeshes();
    }

    public void updateSimpleMeshes(){

        int maxX = this.vInfinitesimals[0].infinitesimals.length - 1;
        int maxY = this.vInfinitesimals.length - 1;
        for (int y = 0; y < maxY; y++){
            for (int x = 0; x < maxX; x++){

                Vector3f[] simpleMesh = new Vector3f[4];

                simpleMesh[0] = this.vInfinitesimals[y].infinitesimals[x];
                simpleMesh[1] = this.vInfinitesimals[y + 1].infinitesimals[x];
                simpleMesh[2] = this.vInfinitesimals[y].infinitesimals[x + 1];
                simpleMesh[3] = this.vInfinitesimals[y + 1].infinitesimals[x + 1];
                Vector2f[] texCoord = new Vector2f[4];

//                Vector2f distance = new Vector2f(((this.vInfinitesimals[maxY].infinitesimals[maxX].x) - (this.vInfinitesimals[0].infinitesimals[0].x)), ((this.vInfinitesimals[maxY].infinitesimals[maxX].y) - (this.vInfinitesimals[0].infinitesimals[0].y)));
//                Vector2f base = new Vector2f(this.vInfinitesimals[0].infinitesimals[0].x, this.vInfinitesimals[0].infinitesimals[0].y);

//                texCoord[0] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x].y - base.y)/distance.y)); // new Vector2f(0,0);
//                texCoord[1] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x].y - base.y )/distance.y));//new Vector2f(1,0);
//                texCoord[2] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x + 1].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(0,1);
//                texCoord[3] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x + 1].x) - base.x)/distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(1,1);

                texCoord[0] = new Vector2f((float) x /maxX, (float) y /maxY);
                texCoord[1] = new Vector2f((float) x /maxX, (float) (y + 1) /maxY);
                texCoord[2] = new Vector2f((float) (x + 1) /maxX, (float) y /maxY);
                texCoord[3] = new Vector2f((float) (x + 1) /maxX, (float) (y + 1) /maxY);

                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].texCoord = texCoord;
                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].vertices = simpleMesh;

                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].m.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].vertices));
                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].m.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].texCoord));
                //m.setBuffer(VertexBuffer.Type.Index, 1, BufferUtils.createShortBuffer(indexes));

                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].m.updateBound();

                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].mat.setTexture("ColorMap", new Texture2D(atms.makeATMS()));
                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].geom.setMaterial(simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].mat);

                //simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].geom.updateModelBound();




            }
        }
    }

    public void setDimensions(){

        this.dim = 3;

        width = currencyLines[0].points[currencyLines[0].points.length - 1].x - currencyLines[0].points[0].x;
        height = currencyLines[currencyLines.length - 1].points[0].y - currencyLines[0].points[0].y;
        this.vInfinitesimals = new SuperLine[currencyLines[0].infinitesimals.length];

        for (int i = 0; i < this.vInfinitesimals.length; i++){

            this.vInfinitesimals[i] = new SuperLine(new Vector3f[]{currencyLines[0].infinitesimals[i], currencyLines[1].infinitesimals[i], currencyLines[2].infinitesimals[i], currencyLines[3].infinitesimals[i]}, (byte)vInfinitesimals.length);

        }
    }

    public void setImageArray(){
        int imageArray = 1;

        width = this.vInfinitesimals.length;
        height = this.vInfinitesimals[0].infinitesimals.length;

        imageArray = (int)width * (int)height;

        simpleMeshes = new SimpleMesh[imageArray];
    }
    public void drawSimpleMeshes(){
        int maxX = this.vInfinitesimals[0].infinitesimals.length - 1;
        int maxY = this.vInfinitesimals.length - 1;
        for (int y = 0; y < maxY; y++){
            for (int x = 0; x < maxX; x++){

                Vector3f[] simpleMesh = new Vector3f[4];

                simpleMesh[0] = this.vInfinitesimals[y].infinitesimals[x];
                simpleMesh[1] = this.vInfinitesimals[y + 1].infinitesimals[x];
                simpleMesh[2] = this.vInfinitesimals[y].infinitesimals[x + 1];
                simpleMesh[3] = this.vInfinitesimals[y + 1].infinitesimals[x + 1];

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
                texCoord[0] = new Vector2f((float) x /maxX, (float) y /maxY);
                texCoord[1] = new Vector2f((float) x /maxX, (float) (y + 1) /maxY);
                texCoord[2] = new Vector2f((float) (x + 1) /maxX, (float) y /maxY);
                texCoord[3] = new Vector2f((float) (x + 1) /maxX, (float) (y + 1) /maxY);

                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x] = new SimpleMesh(simpleMesh, texCoord, new Texture2D(atms.makeATMS()), node);

            }
        }
    }

//    public float[] vertices;
//    public int[] indices;
//    //public Vector3f[] positions;
//    public float[] texCoord;
//
//    public ATMS atms;
//
//    public SuperLine[] polyLines;
//    public SuperLine[] vInfinitesimals;
//
//    public float width;
//    public float height;
//
//    public float infWidth;
//    public float infHeight;
//
//    public Mesh m;
//
//    public Geometry geom;
//    public Material mat;
//
//    public SuperSurface(ATMS atms, SuperLine[] polyLines){
//
//        this.polyLines = polyLines;
//        this.atms = atms;
//        makeVerticalLines();
//        allocateVertices();
//        allocateIndices();
//        allocateTexCoords();
//        createShape();
//
//    }
//
//    public void createShape(){
//
//        m = new Mesh();
//
//        // Setting buffers
//        m.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(this.vertices));
//        m.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(this.texCoord));
//        m.setBuffer(VertexBuffer.Type.Index, 1, BufferUtils.createIntBuffer(this.indices));
//
//        m.updateBound();
//
//
//        //*****RenderState*****
//
//        // texture.setWrap(Texture.WrapMode.Repeat);
//        // *************************************************************************
//        // First mesh uses one solid color
//        // *************************************************************************
//
//        // Creating a geometry, and apply a single color material to it
//        this.geom = new Geometry("OurMesh", m);
//
//        mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.getAdditionalRenderState().setFaceCullMode(RenderState.FaceCullMode.Off);
//        mat.setTransparent(true);
//       mat.getAdditionalRenderState().setDepthWrite(true);
//        mat.getAdditionalRenderState().setDepthTest(true);
//        mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
//
//        geom.setQueueBucket(RenderQueue.Bucket.Transparent);
//        Texture2D texture = new Texture2D(atms.makeATMS());
//        mat.setColor("Color", ColorRGBA.fromRGBA255(255,255,255,255));
//        mat.setTexture("ColorMap", texture);
//        geom.setMaterial(mat);
//        //geom.getMesh().scaleTextureCoordinates(new Vector2f(2, 2));
//
//        // Attaching our geometry to the root node.
//        //app.getRootNode().attachChild(geom);
//        App.getInstance().app.getRootNode().attachChild(geom);
//
//    }
//
//    public int getTotalVertices(){
//
//        // for (GameShopPolySurface gsps: this.gspSurfaces){
//
//        // totalVertices += gsps.vInfinitesimals[0].infinitesimals.length * 4;
//
//        int totalVertices = 0;
//
//        for (SuperLine vi: vInfinitesimals){
//
//            totalVertices += vi.infinitesimals.length;
//        }
//
//        infWidth = vInfinitesimals[0].infinitesimals.length;
//        infHeight = vInfinitesimals.length;
//        return totalVertices;
//    }
//
//    public void makeVerticalLines(){
////     this.dim = 3;
////
//        width = (polyLines[0].points[polyLines[0].points.length - 1].x - polyLines[0].points[0].x);
//        height = (polyLines[polyLines.length - 1].points[0].y - polyLines[0].points[0].y);
//        this.vInfinitesimals = new SuperLine[polyLines[0].infinitesimals.length];
//
//        for (int i = 0; i < this.vInfinitesimals.length; i++){
//
//            this.vInfinitesimals[i] = new SuperLine(new Vector3f[]{polyLines[0].infinitesimals[i], polyLines[1].infinitesimals[i], polyLines[2].infinitesimals[i], polyLines[3].infinitesimals[i]}, this.vInfinitesimals.length);
//
//        }
//    }
//
//
//    public void allocateVertices(){
//
//        int totalVertices = 0;
//        //for (GameShopPolySurface gsps: this.gspSurfaces){
//            for (SuperLine gscl: vInfinitesimals){
//
//                // System.out.println(totalVertices);
//                totalVertices += gscl.infinitesimals.length * 3;
//            }
//        //}
//        this.vertices = new float[totalVertices];
//
//        int i = 0;
//
////        for (SuperSurface gsps: this.gspSurfaces){
//            for (SuperLine gscl:  vInfinitesimals){
//
//                for (com.jme3.math.Vector3f v: gscl.infinitesimals){
//
//                    this.vertices[i] = v.x;
//                    this.vertices[i + 1] = v.y;
//                    this.vertices[i + 2] = v.z;
////                  if (this.vertices[i ]  ==  0.8234531f){
////
////                      System.out.println("ROUNDED: " + (i));
////                  }
//                    if (this.vertices[i + 2]  ==  0f){
//
//                        //System.out.println("ROUNDED: " + (i + 2));
//                        if ((i + 3) % 3 == 0){
//
//
//                            //  System.out.println("Z CORD: " + (i + 2));
//                        }
//                    }
//                    i+=3;
//                }
//                // System.out.println(totalVertices);
//                //totalVertices += gscl.infinitesimals.length;
//            }
//       // }
//
//        //   System.out.println(vertices.length);
//        // System.out.println(Arrays.toString(vertices));
//
//        int j = 0;
//        for (float v: vertices){
//
//            if (j == 0){
//
//                //   System.out.print(" x " + v);
//                j++;
//
//            } else if (j == 1){
//
//
//                // System.out.print(" y " + v);
//                j++;
//
//            } else if (j == 2){
//
//
//                // System.out.print(" z " + v);
//                // System.out.println("");
//                j = 0;
//            }
//
//        }
////          for (GameShopCurrencyLine gscl: vInfinitesimals){
////
////              for (com.jme3.math.Vector3f v: gscl.infinitesimals){
////
////
////                  i++;
////              }
////          }
//
//        // System.out.println(vertices.length);
//        // System.out.println(Arrays.asList(vertices));
////        int totalVertices = 0;
////        int j = 0;
////        for (GameShopPolySurface gsps: this.gspSurfaces){
////
////          gsps.getTotalVertices();
////          // totalVertices += gsps.getTotalVertices();
////          System.out.println(gsps.infWidth);
////          System.out.println(gsps.infHeight);
////           this.surfacePeek[j] = (int) (gsps.infWidth * gsps.infHeight);
////           totalVertices += this.surfacePeek[j];
////            j++;
////        }
////
////        vertices = new float[totalVertices * 3];
////        int i = 0;
////        for (GameShopPolySurface gsps: this.gspSurfaces){
////
////           for (GameShopPolyLine vi: gsps.vInfinitesimals){
////
////              for (com.jme3.math.Vector3f v : vi.infinitesimals){
////
////                  vertices[i] = v.x;
////                  vertices[i + 1] = v.y;
////                  vertices[i + 2] = v.z;
////
////                  i += 3;
////              }
////           }
////        }
//        System.out.println(vertices.length);
//        System.out.println(Arrays.toString(vertices));
//    }
//
//    int skips = 0;
//
//    public void allocateIndices(){
//
//        int finalIndex = 0;
//        //Find Poly Surface.  Determine Dimensions.  Go To Where In Array Start And End
//        //Indices Seem To Be Half Of The Vertices.
//
//        int totalIndices = 0;
//
////         for (GameShopPolySurface gsps: this.gspSurfaces){
////
////             for (GameShopPolyLine gspl: gsps.vInfinitesimals){
////
////                 for (com.jme3.math.Vector3f v: gspl.infinitesimals){
////                 totalIndices += 6;
////                 //totalIndices += 12;
////                 }
////             }
////         }
//
//        totalIndices = ((this.vertices.length) * 3);
//
//        // totalIndices -= 150;
//        //  totalIndices = (totalIndices/4) * 6;
//
//        // System.out.println("totalIndices: " + totalIndices);
//        indices = new int[totalIndices];
//
//        int index = 0;
//        int i = 0;
//        int line = 0;
//        int l = 0;
//        boolean isBreak = false;
//
////        for (GameShopPolySurface gsps: this.gspSurfaces){
////
////            if (isBreak){
////
////                break;
////            }
////            if (index + 6 >= totalIndices){
////
////            break;
////        }
//            int lastLine = 0;
//            for (SuperLine gspl:  vInfinitesimals){
//
//
//                if (isBreak){
//                    break;
//                }
//                System.out.println(lastLine);
//                lastLine++;
//
//                int linelength = 0;
//                for (com.jme3.math.Vector3f v: gspl.infinitesimals){
//
//
////                    linelength++;
////
////                    if (linelength == gspl.infinitesimals.length){
////
//////                        indices[index] =  -0;
//////                        indices[index + 1] = -0;
//////                        indices[index + 2] = -0;
//////                        indices[index + 3] = -0;
//////                        indices[index + 4] = -0;
//////                        indices[index + 5] = -0;
//////
//////                        index+=6;
////                        i+=1;
////                        //linelength = 0;
////                        //break;
////                    }
//
//                    if ((short) (i + gspl.numPoints + 1) == (short)(vertices.length/3) - 1){
//
//                        finalIndex = index;
//                        // System.out.println("BREAK");
//                        isBreak = true;
//                        break;
//                    }
//                    indices[index] = (short) (i + gspl.numPoints + 1);
//                    indices[index + 1] = (short) i;
//                    indices[index + 2] = (short) (i + 1);
//                    indices[index + 3] = (short) (i + 1);
//                    indices[index + 4] = (short) (i + gspl.numPoints + 2);
//                    indices[index + 5] = (short) (i + gspl.numPoints + 1);
////                    if (indices[index] == (vertices.length/3) - 1){
////                        finalIndex = index;
////                        System.out.println("BREAK " + finalIndex);
////                        isBreak = true;
////                        break;
////                    }
//                    System.out.println("After" + lastLine);
//
//
//                    i++;
//                    l++;
//
//                    index += 6;
//
//
//
//                }
//
//
//
//
//                if (i % (gspl.infinitesimals.length * gspl.infinitesimals.length) == 0) {
//
//                    line++;
//                }
//
//
//            }
//        //}
//        //System.out.println(finalIndex);
//
//        indices = Arrays.copyOfRange(indices, 0, finalIndex);
//        System.out.println("indices");
//        System.out.println(Arrays.toString(indices));
//    }
//
//    public void allocateTexCoords(){
//
//        // this.texCoord = new com.jme3.math.Vector2f[(this.vertices.length/6) - (skips * 2) - 4];
//
//        //this.texCoord = new com.jme3.math.Vector2f[this.vertices.length];
//        this.texCoord = new float [(this.vertices.length/3) * 2];
//
//        int i = 0;
//        float x = 0;
//        float y = 0;
//        int slice = 0;
//        int v = 0;
////        for (GameShopPolySurface gsps: this.gspSurfaces){
////            if (gsps.polyLines.length / 4 != atms.textureSamples.length){
////
////                System.out.println("You Need 4 CurrencyLines for every 1 Texture Sample");
////                for (float tc: this.texCoord){
////
////                    tc = 0f;
////                }
////                return;
////            }
////
////            int maxLines = gsps.vInfinitesimals.length;
////            int lines = 0;
////
////            System.out.println("currencyLines " + gsps.polyLines.length);
////            System.out.println("vInfinitesimals " + gsps.vInfinitesimals.length);
////
////        }
//
//
//        while ( v < texCoord.length){
//
//            if (v == 0){
//                x = 0;//atms.textureSamples[slice].x;
//                y  = 0;//atms.textureSamples[slice].z;
//            }
////            if (slice == atms.textureSamples.length){
////
////                break;
////            }
//
//            //texCoord[v] = new com.jme3.math.Vector2f((atms.textureSamples[slice].x + (x)) , (atms.textureSamples[slice].z + (y)));
//
//            texCoord[v] =   (x);
//            texCoord[v + 1] =  (y);
//
//             getTotalVertices();
//            //y += (((float) 1 /(((float) this.gspSurfaces[slice].vInfinitesimals[0].infinitesimals.length /atms.textureSamples.length))));
////y += (((float) 1 /(((float) this.gspSurfaces[slice].vInfinitesimals[0].infinitesimals.length /atms.textureSamples.length))));
//
//            y += (float)(1/ (infWidth - 1));
//
//            if (y > 1){
//                y  = 0;
//                x += (float)(1/ ( infHeight - 1));
//
//                //x += (((float) 1 /(((float) this.gspSurfaces[slice].vInfinitesimals.length /atms.textureSamples.length))));
//            }
//
//            v+=2;
//        }
//        i++;
//        slice++;
//
//        System.out.println(Arrays.toString(this.texCoord));
//    }
}
