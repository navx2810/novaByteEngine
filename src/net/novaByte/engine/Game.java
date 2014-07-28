package net.novaByte.engine;

import org.lwjgl.input.Keyboard;

public class Game 
{
	private Mesh mesh;
	private Shader shader;
	private Transform transform;
	
	public Game() 
	{
		mesh = ResourceLoader.loadMesh("box.obj"); //new Mesh();
		shader = new Shader();
		
//		Vertex[] vertices = new Vertex[] { 	new Vertex(new Vector3f(-1, -1, 0)),
//										new Vertex(new Vector3f(0, 1, 0)),
//										new Vertex(new Vector3f(1, -1, 0)),
//										new Vertex(new Vector3f(0, -1, 1))};
//		
//		int[] indicies = new int[] {0,1,3, 3,1,2, 2,1,0, 0,2,3};
//		
//		mesh.addVertices(vertices, indicies);
		
		transform = new Transform();
		
		shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vert"));
		shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.frag"));
		shader.compileShader();
		
		shader.addUniform("transform");
	}
	
	public void input()
	{
		if(Input.getKeyDown(Keyboard.KEY_W))
			System.out.println("KEY W IS DOWN");
		if(Input.getKeyUp(Keyboard.KEY_W))
			System.out.println("KEY W IS UP");
		
		if(Input.getMouseDown(1))
			System.out.println("MOUSE : Right Clicked AT " + Input.getMousePosition().toString());
		if (Input.getMouseUp(1))
			System.out.println("Mouse : Right Click Released AT " + Input.getMousePosition().toString());
			
	}
	
	float temp = 0.0f;
	
	public void update()
	{
//		if(temp <= 3f)
			temp += Time.getDelta(); 	// TODO: This is a simple tween--thing. Build a tween engine off of this
//		System.out.println(temp);
			
		float sinTemp = (float)(Math.sin(temp));
		
		transform.setTranslation(sinTemp, 0, 0);
		transform.setRotation(0, sinTemp * 180, 0);
		transform.setScale( .5f, .5f, .5f );
			
	}
	
	public void render()
	{
		shader.bind();
		shader.setUniform("transform", transform.getTransformation());
		mesh.draw();
	}
	
}
