package team.cosine.module.settings.impl;

import team.cosine.module.settings.Setting;

public class Keybind extends Setting {

	private KeybindType type;
	private int key, typeIndex;
	
	public Keybind(final String name, final int key, final KeybindType type)
	{
		this.name = name;
		this.key = key;
		this.type = type;
		this.typeIndex = type.getIndex();
	}
	
	public int getKey()
	{
		return this.key;
	}
	
	public void setKey(final int key)
	{
		this.key = key;
	}
	
	public KeybindType getType()
	{
		return this.type;
	}
	
	public void toggleType()
	{
		typeIndex++;
		if(typeIndex > KeybindType.LAST)typeIndex = 0;
		
		this.type = KeybindType.find(typeIndex);
	}
	
	public static enum KeybindType
	{
		
		TOGGLE("Toggle", 0),
		HOLD("Hold", 1);
		
		public static int LAST = 1;
		
		private String name;
		private int index;
		KeybindType(final String name, final int index)
		{
			this.name = name;
			this.index = index;
		}
		
		public int getIndex()
		{
			return this.index;
		}
		
		public String getName()
		{
			return this.name;
		}
		
		public static KeybindType find(final int index)
		{
			for(KeybindType type : values())
			{
				if(type.getIndex() == index)
					return type;
			}
			
			return values()[0];
		}
		
	}
	
}
