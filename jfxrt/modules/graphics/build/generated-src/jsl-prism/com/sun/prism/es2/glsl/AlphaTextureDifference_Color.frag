#ifdef GL_ES
#extension GL_OES_standard_derivatives : enable
precision highp float;
precision highp int;
#else
#define highp
#define mediump
#define lowp
#endif
varying vec2 texCoord0;
varying lowp vec4 perVertexColor;
uniform sampler2D maskInput;
uniform vec2 innerOffset;
lowp float mask(vec2 texCoord) {
return texture2D(maskInput, texCoord).a - texture2D(maskInput, texCoord - innerOffset).a;
}
void main() {
gl_FragColor = mask(texCoord0) * perVertexColor;
}