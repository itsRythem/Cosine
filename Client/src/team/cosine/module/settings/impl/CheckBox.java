package team.cosine.module.settings.impl;

import team.cosine.module.settings.Setting;

public class CheckBox extends Setting {

	private boolean state;
	
	public CheckBox(final String name, final boolean state)
	{
		this.name = name;
		this.state = state;
	}
	
	public boolean getState()
	{
		return this.state;
	}
	
	public void setState(final boolean state)
	{
		this.state = state;
	}
	
}
