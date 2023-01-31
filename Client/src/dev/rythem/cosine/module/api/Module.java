package dev.rythem.cosine.module.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.rythem.cosine.Cosine;
import dev.rythem.cosine.module.settings.Setting;
import dev.rythem.cosine.module.settings.impl.Keybind;
import net.minecraft.client.Minecraft;

public class Module {

	protected static Minecraft mc = Minecraft.getMinecraft();
	
	private String name, description, suffix;
	private boolean state;
	
	private final ModuleCategory category;
	private final Keybind keySetting;
	
	private List<Setting> settings = new ArrayList<Setting>();
	
	public Module(final String name, final String description, final int key, final ModuleCategory category)
	{
		this.name = name;
		this.description = description;
		this.category = category;
		this.keySetting = new Keybind("Keybind", key);
		
		this.registerSettings(keySetting);
	}
	
	public void registerSettings(final Setting... settings)
	{
		this.settings.addAll(Arrays.asList(settings));
	}
	
	public void toggle()
	{
		toggle(!this.state);
	}
	
	public void toggle(final boolean state)
	{
		toggle(state, false);
	}
	
	public void toggle(final boolean state, final boolean silent)
	{
		this.state = state;
		this.handleToggle(silent);
	}
	
	private void handleToggle(final boolean silent)
	{
		this.onToggle(this.state);
		
		if(this.state)
		{
			Cosine.get().getEventHandler().register(this);
			
			if(!silent) // Notification
			{}
		}
		else
		{
			Cosine.get().getEventHandler().unregister(this);
			
			if(!silent) // Notification
			{}
		}
	}
	
	public void onToggle(final boolean state) {}
	public int getKey(){return this.keySetting.getKey();}
	public void setKey(final int key){this.keySetting.setKey(key);}
	public String getName(){return this.name;}
	public String getDescription(){return this.description;}
	public ModuleCategory getCategory() {return this.category;};
	public boolean isToggled() {return this.state;}
	public String getSuffix() {return null;}
	public List<Setting> getSettings() {return this.settings;}
	
}
