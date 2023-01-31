package team.cosine.module;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import team.cosine.module.api.Module;
import team.cosine.Cosine;
import team.cosine.integrated.Handler;
import team.cosine.module.settings.impl.Keybind;
import team.cosine.module.settings.impl.Keybind.KeybindType;

public final class KeybindHandler extends Handler {
	
	public KeybindHandler()
	{
	}
	
	@Override
	public void load()
	{
	}

	@Override
	public void unload()
	{
		
	}
	
	public void handle(final int key, final boolean state)
	{
		final Collection<Module> modules = Cosine.get().getModuleHandler().getModules();
		
		modules.forEach(module -> {
			final Keybind keybind = module.getKeybind();
			
			if(keybind.getKey() == key)
			{
				switch(keybind.getType())
				{
				case TOGGLE:
					module.toggle();
					break;
				case HOLD:
					if(state)module.toggle(true);
					else module.toggle(false);
					break;
				}
			}
		});
	}
	
}
