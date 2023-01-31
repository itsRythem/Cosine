package team.cosine.event.impl;

import team.cosine.event.api.Event;
import team.cosine.event.api.EventType;

public final class EventMotionUpdate extends Event<EventMotionUpdate> {
	
	public double posX, posY, posZ, prevPosX, prevPosY, prevPosZ;
	public float rotationYaw, rotationPitch, prevRotationYaw, prevRotationPitch;
	public boolean onGround;
	public final byte type;
	
	public EventMotionUpdate(final double posX, final double posY, final double posZ, final double prevPosX, final double prevPosY, final double prevPosZ, final float rotationYaw, final float rotationPitch, final float prevRotationYaw, final float prevRotationPitch, final boolean onGround, final byte type)
	{
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.prevPosX = prevPosX;
		this.prevPosY = prevPosY;
		this.prevPosZ = prevPosZ;
		this.rotationYaw = rotationYaw;
		this.rotationPitch = rotationPitch;
		this.prevRotationYaw = prevRotationYaw;
		this.prevRotationPitch = prevRotationPitch;
		this.onGround = onGround;
		this.type = type;
	}
	
	public boolean isPre()
	{
		return this.type == EventType.PRE;
	}
	
	public boolean isPost()
	{
		return this.type == EventType.POST;
	}
	
}

