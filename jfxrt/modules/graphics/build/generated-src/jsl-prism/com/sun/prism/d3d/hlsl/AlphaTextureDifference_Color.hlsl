sampler2D maskInput : register(s0);
float2 innerOffset : register(c0);
float mask(float2 texCoord) {
return tex2D(maskInput, texCoord).a - tex2D(maskInput, texCoord - innerOffset).a;
}
void main(in float2 pos0 : TEXCOORD0,
in float2 pos1 : TEXCOORD1,
in float2 pixcoord : VPOS,
in float4 jsl_vertexColor : COLOR0,
out float4 color : COLOR0) {
color = mask(pos0) * jsl_vertexColor;
}
