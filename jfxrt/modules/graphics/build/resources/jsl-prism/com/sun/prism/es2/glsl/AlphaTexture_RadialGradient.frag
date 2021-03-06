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
varying vec2 texCoord1;
varying lowp vec4 perVertexColor;
uniform sampler2D maskInput;
lowp float mask(vec2 texCoord) {
return texture2D(maskInput, texCoord).a;
}
uniform sampler2D colors;
uniform vec4 content;
uniform vec3 precalc;
lowp vec4 paint(vec2 texCoord) {
float xfx = texCoord.x - precalc.x;
float dist = (precalc.x * xfx + sqrt(xfx * xfx + texCoord.y * texCoord.y * precalc.y)) * precalc.z;
vec2 fractvals = vec2(fract(dist), clamp(dist, 0.0, 1.0));
vec2 clrCoord = vec2(content.x + dot(fractvals, content.zw), content.y);
return texture2D(colors, clrCoord);
}
void main() {
gl_FragColor = mask(texCoord0) * paint(texCoord1) * perVertexColor;
}
