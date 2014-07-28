package net.novaByte.engine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

public class RenderUtil 
{
	public static void clearScreen()
	{
		//TODO: Stencil Buffer
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	public static void initGraphics()
	{
		glClearColor(0.01f, 0.01f, 0.01f, 0.01f);
		
		glFrontFace(GL_CW);	// CW : 'clock-wise'
		glCullFace(GL_BACK);
		glEnable(GL_CULL_FACE);
		glEnable(GL_DEPTH_TEST);
		
		//TODO: Depth clamp for later
		
		glEnable(GL_FRAMEBUFFER_SRGB);
	}
	
	public static String getOpenGLVersion()
	{
		return glGetString(GL_VERSION);
	}
}
