package dev.rythem.cosine.module.settings;

public abstract class Setting {

	protected String name, description;
	
	public <T> T description(final String description)
	{
		this.description = description;
		return (T)this;
	}
	
	public String getName() {return this.name;}
	public String getDescription() {return this.description;}
	
}
