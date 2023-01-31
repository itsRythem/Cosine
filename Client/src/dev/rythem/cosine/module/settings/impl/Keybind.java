package dev.rythem.cosine.module.settings.impl;

import dev.rythem.cosine.module.settings.Setting;

public class Keybind extends Setting {

	private int key;
	
	public Keybind(final String name, final int key)
	{
		this.name = name;
		this.key = key;
	}
	
	public int getKey()
	{
		return this.key;
	}
	
	public void setKey(final int key)
	{
		this.key = key;
	}
	
}
