package team.cosine.module.settings.api;

import java.util.ArrayList;
import java.util.List;

import team.cosine.module.settings.Setting;

public final class Sector extends Setting {

	private List<Setting> settings = new ArrayList<Setting>();
	
	public Sector(final String name)
	{
		this.name = name;
	}
	
	public void add(final Setting setting)
	{
		this.settings.add(setting);
	}
	
	public void remove(final Setting setting)
	{
		this.settings.remove(setting);
	}
	
	public void clear()
	{
		this.settings.clear();
	}
	
	public List<Setting> get()
	{
		return this.settings;
	}
	
}
