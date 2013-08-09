#ifdef GL_ES
    precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_texCoords;
uniform sampler2D u_texture;

uniform int steps = 5;
uniform float radius = 0.0010f;

void main()
{
	vec4 sum = vec4(0);
	vec2 texcoord = v_texCoords;
	int j;
	int i;

	for( i= -steps ;i < steps; i++)
	{
		for (j = -steps; j < steps; j++)
		{
			sum += texture2D(u_texture, texcoord + vec2(j, i)*radius) * 0.20; 
		}
	}

	gl_FragColor = sum*sum*0.006+texture2D(u_texture, texcoord);
}