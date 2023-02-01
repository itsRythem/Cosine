package team.cosine.event.impl;

import net.minecraft.network.Packet;
import team.cosine.event.api.Event;

public final class EventPacket extends Event<EventPacket> {

	public Packet<?> packet;
	
	public EventPacket(final Packet<?> packet)
	{
		this.packet = packet;
	}
	
}
