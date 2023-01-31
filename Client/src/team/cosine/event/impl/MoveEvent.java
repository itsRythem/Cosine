package team.cosine.event.impl;

import net.minecraft.entity.MoverType;
import team.cosine.event.api.Event;
import team.cosine.event.api.EventType;

public final class MoveEvent extends Event {
	
	public MoverType type;
	public double x, y, z;
	
	public MoveEvent(final MoverType type, final double x, final double y, final double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.type = type;
	}
	
}

