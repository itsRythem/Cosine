package team.cosine.event.api;

import team.cosine.Cosine;

public class Event<T> {

	private boolean cancelled;
	
	public Event()
	{	
	}
	
	public T call()
	{
		Cosine.get().getEventHandler().call(this);
		return (T)this;
	}
	
	public void cancel() {this.cancelled = true;}
	public boolean isCancelled() {return this.cancelled;}
	
}
