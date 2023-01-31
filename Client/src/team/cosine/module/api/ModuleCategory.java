package team.cosine.module.api;

public enum ModuleCategory {

	COMBAT("Combat"),
	PLAYER("Player"),
	MOVEMENT("Movement"),
	RENDER("Render"),
	WORLD("World"),
	EXPLOIT("Exploit"),
	CHAT("Chat"),
	MISC("Misc");
	
	private String name;
	ModuleCategory(final String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
}
