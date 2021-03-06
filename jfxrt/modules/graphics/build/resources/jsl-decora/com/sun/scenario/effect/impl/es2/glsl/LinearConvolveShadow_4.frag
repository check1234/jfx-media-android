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
uniform sampler2D img;
uniform int count;
uniform vec4 offset;
uniform vec4 shadowColor;
uniform vec4 weights[1];
void main() {
int i;
float sum = 0.0;
vec2 loc = texCoord0 + offset.zw;
{
sum += weights[0].x * texture2D(img, loc).a;
loc += offset.xy;
sum += weights[0].y * texture2D(img, loc).a;
loc += offset.xy;
sum += weights[0].z * texture2D(img, loc).a;
loc += offset.xy;
sum += weights[0].w * texture2D(img, loc).a;
loc += offset.xy;
}
sum = clamp(sum, 0.0, 1.0);
gl_FragColor = sum * shadowColor;
}
