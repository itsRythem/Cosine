package dev.rythem.cosine;

public final class Cosine {
	
	private static final Core core = new Core();
	private static boolean initialized;
	
	public Cosine()
	{
	}
	
	public static void initialize()
	{	
		final long time = System.currentTimeMillis();
		core.load();
		
		System.out.println(
				"                                                              \r\n"
				+ "                                                              \r\n"
				+" $$$$$$\\   $$$$$$\\   $$$$$$\\  $$$$$$\\ $$\\   $$\\ $$$$$$$$\\ $$\\ \r\n"
				+ "$$  __$$\\ $$  __$$\\ $$  __$$\\ \\_$$  _|$$$\\  $$ |$$  _____|$$ |\r\n"
				+ "$$ /  \\__|$$ /  $$ |$$ /  \\__|  $$ |  $$$$\\ $$ |$$ |      $$ |\r\n"
				+ "$$ |      $$ |  $$ |\\$$$$$$\\    $$ |  $$ $$\\$$ |$$$$$\\    $$ |\r\n"
				+ "$$ |      $$ |  $$ | \\____$$\\   $$ |  $$ \\$$$$ |$$  __|   \\__|\r\n"
				+ "$$ |  $$\\ $$ |  $$ |$$\\   $$ |  $$ |  $$ |\\$$$ |$$ |          \r\n"
				+ "\\$$$$$$  | $$$$$$  |\\$$$$$$  |$$$$$$\\ $$ | \\$$ |$$$$$$$$\\ $$\\ \r\n"
				+ " \\______/  \\______/  \\______/ \\______|\\__|  \\__|\\________|\\__|\r\n"
				+ "                                                              \r\n"
				+ "                                                              \r\n"
				+ "                      Loading Took: " + (System.currentTimeMillis() - time) + "ms            "
				+ "                                                              \r\n");
		
		initialized = true;
	}
	
	public static void terminate()
	{
		core.unload();
		
		initialized = false;
	}
	
	public static Core get()
	{
		return core;
	}
	
	public static boolean isInitialized()
	{
		return initialized;
	}
	
}
