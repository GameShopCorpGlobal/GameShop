//the global uniform World view projection matrix
//(more on global uniforms below)
//uniform mat4 g_WorldViewProjectionMatrix;
//The attribute inPosition is the Object space position of the vertex
precision mediump float;
attribute vec3 inPosition;
attribute vec2 inTexCoord;
varying vec2 texCoord;
void main(){
    //Transformation of the object space coordinate to projection space
    //coordinates.
    //- gl_Position is the standard GLSL variable holding projection space
    //position. It must be filled in the vertex shader
    //- To convert position we multiply the worldViewProjectionMatrix by
    //by the position vector.
    //The multiplication must be done in this order.
    texCoord = inTexCoord;
    //gl_Position =  vec4((inPosition.x) / 3.0, (inPosition.y) / 7.0 , 0.0, 1.0);
    gl_Position =  vec4((inPosition.x), (inPosition.y) , 0.0, 1.0);
    //gl_Position =  vec4((inPosition.x) - 1.0, (inPosition.y) - 1.0 , 0.0, 1.0);

}