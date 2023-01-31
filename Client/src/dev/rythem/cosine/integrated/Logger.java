package dev.rythem.cosine.integrated;

public final class Logger {

	public static int SUCCESS = 0, ERROR = 1;

	public static void log(final Object obj)
	{
		log(obj, true, true, 0);
	}
	
	public static void log(final Object obj, final int context)
	{
		log(obj, true, true, context);
	}
	
	public static void log(final Object obj, final boolean console, final boolean system, final int context)
	{
		if(system && context == 0) System.out.println(obj);
		else if(system && context == 1) System.err.println(obj);
	}
	
}
