precision mediump float;
uniform vec4 m_Color;
//#ifdef COLORMAP
uniform sampler2D m_ColorMap;
varying vec2 texCoord;
//#endif
void main(){
    //returning the color of the pixel (here solid blue)
    //- gl_FragColor is the standard GLSL variable that holds the pixel
    //color. It must be filled in the Fragment Shader.
    gl_FragColor = texture2D(m_ColorMap, texCoord);
}