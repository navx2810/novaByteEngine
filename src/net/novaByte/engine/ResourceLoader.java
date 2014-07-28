package net.novaByte.engine;

import java.io.BufferedReader;
import java.io.FileReader;

public class ResourceLoader 
{
	public static String loadShader(String fileName)
	{
		StringBuilder shaderSource = new StringBuilder();
		BufferedReader shaderReader;
		
		try 
		{	
			shaderReader = new BufferedReader(new FileReader("./res/shaders/" + fileName));
			String line;
			
			while( ( line = shaderReader.readLine() ) != null )
			{
				shaderSource.append(line).append("\n");
			}
			
			shaderReader.close();
		} catch (Exception e) 
		{
			System.err.println("Could not load shader file : " + fileName);
			System.exit(1);
		}
		
		
		return shaderSource.toString();
	}
}
