package dev.rythem.cosine.event.api;

public class Event {

	private boolean cancelled;
	
	public Event()
	{	
	}
	
	public void cancel() {this.cancelled = true;}
	public boolean isCancelled() {return this.cancelled;}
	
}
