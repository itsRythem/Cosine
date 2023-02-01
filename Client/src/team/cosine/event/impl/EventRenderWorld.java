package team.cosine.event.impl;

import team.cosine.event.api.Event;

public final class EventRenderWorld extends Event<EventRenderWorld> {

	public float partialTicks;
	
	public EventRenderWorld(final float partialTicks)
	{
		this.partialTicks = partialTicks;
	}
	
}
