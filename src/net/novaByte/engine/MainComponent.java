package net.novaByte.engine;

public class MainComponent 
{
	
	public static final int WIDTH = 1280, HEIGHT = 720;
	public static final String TITLE = "NovaByte v01";
	
	public MainComponent() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void start()
	{
		run();
	}
	
	public void stop()
	{
		
	}
	
	public void run()
	{
		while ( !Window.isCloseRequested() )
		{
			render();
		}
	}
	
	public void render()
	{
		Window.render();
	}
	
	public void cleanUp()
	{
		
	}
	
	public static void main(String[] args)
	{
		Window.createWindow(WIDTH, HEIGHT, TITLE);
		
		MainComponent game = new MainComponent();
		
		game.start();
	}
}
