package team.cosine.event.impl;

import net.minecraft.entity.MoverType;
import team.cosine.event.api.Event;
import team.cosine.event.api.EventType;

public final class EventChat extends Event<EventChat> {
	
	public String message;
	
	public EventChat(final String message)
	{
		this.message = message;
	}
	
}

