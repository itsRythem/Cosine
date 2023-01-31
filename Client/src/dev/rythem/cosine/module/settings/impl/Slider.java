package dev.rythem.cosine.module.settings.impl;

import dev.rythem.cosine.module.settings.Setting;

public class Slider extends Setting {

	private float value, minimum, maximum, increment;
	
	public Slider(final String name, final float value, final float minimum, final float maximum, final float increment)
	{
		this.name = name;
		this.value = value;
		this.minimum = minimum;
		this.maximum = maximum;
		this.increment = increment;
	}
	
	public float getValue()
	{
		return this.value;
	}
	
	public int getValueInt()
	{
		return (int)this.value;
	}
	
	public long getValueLong()
	{
		return (long)this.value;
	}
	
	public void setValue(final float value)
	{
		this.value = value;
	}
	
}
