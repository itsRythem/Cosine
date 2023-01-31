package team.cosine.event.impl;

import team.cosine.event.api.Event;

public final class EventRenderGui extends Event<EventRenderGui> {

	public float partialTicks;
	
	public EventRenderGui(final float partialTicks)
	{
		this.partialTicks = partialTicks;
	}
	
}
