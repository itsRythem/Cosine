package team.cosine.module.settings.impl;

import team.cosine.module.settings.Setting;

public final class Textbox extends Setting {
	
	private StringBuilder text = new StringBuilder();
	
	public Textbox(final String name, final String text)
	{
		this.name = name;
		this.text.append(text);
	}
	
	public String getText()
	{
		return this.text.toString();
	}
	
	public void set(final String text)
	{
		this.text.delete(0, this.text.length());
		this.text.append(text);
	}
	
	public void append(final String text)
	{
		this.text.append(text);
	}
	
	public void clear()
	{
		this.text.delete(0, this.text.length());
	}
	
	public void back()
	{
		if(this.text.length() > 0)
			this.text.delete(this.text.length() - 1, this.text.length());
	}
	
}
