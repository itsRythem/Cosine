package team.cosine.event.impl;

import net.minecraft.entity.MoverType;
import team.cosine.event.api.Event;
import team.cosine.event.api.EventType;

public final class ChatEvent extends Event {
	
	public String message;
	
	public ChatEvent(final String message)
	{
		this.message = message;
	}
	
}

