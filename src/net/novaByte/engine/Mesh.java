package net.novaByte.engine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

public class Mesh 
{
	private int vbo, size, ibo;
	
	public Mesh()
	{
		vbo = glGenBuffers();
		ibo = glGenBuffers();
		size = 0;
	}
	
	public void addVertices(Vertex[] vertices, int[] indices)
	{
		size = indices.length;
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, Util.createFlippedBuffer(indices), GL_STATIC_DRAW);
	}
	
	public void draw()
	{
		glEnableVertexAttribArray(0);
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);	// 4 represents the size of a BYTE
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
	// Param1 : The type of thing you want to draw. 
	// Param2 : The number of vertices. 
	// Param3 : The type of the vertices. Param4 : The offset to start at
		glDrawElements(GL_TRIANGLES, size, GL_UNSIGNED_INT, 0);	
		
		glDisableVertexAttribArray(0);
	}
}
