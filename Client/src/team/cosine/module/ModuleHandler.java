package team.cosine.module;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import team.cosine.integrated.Handler;
import team.cosine.integrated.Logger;
import team.cosine.module.api.Module;
import team.cosine.module.impl.combat.*;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class ModuleHandler extends Handler {
	
	private final ConcurrentMap<Class<? extends Module>, Module> modules = new ConcurrentHashMap<Class<? extends Module>, Module>();
	
	@Override
	public void load()
	{
		register(CrystalAura.class);
	}
	
	@Override
	public void unload()
	{
		this.modules.clear();
	}
	
	public void register(final Class<? extends Module> moduleClass)
	{
		try
		{
			final Module module = moduleClass.getDeclaredConstructor().newInstance();
			if(module != null)
			{
				this.modules.put(moduleClass, module);
				Logger.log("Loaded Module: " + module.getName(), Logger.SUCCESS);
			}
			else Logger.log("Failed Loading Module With Class: " + moduleClass.getSimpleName(), Logger.ERROR);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Logger.log("Failed Loading Module With Class: " + moduleClass.getSimpleName(), Logger.ERROR);
		}
	}
	
	public <T>T getModuleByClassGeneric(final Class<? extends Module> moduleClass)
	{
		return (T)this.modules.get(moduleClass);
	}
	
	public Module getModuleByClass(final Class<? extends Module> moduleClass)
	{
		return this.modules.get(moduleClass);
	}
	
	public Set<Class<? extends Module>> getModuleKeys()
	{
		return this.modules.keySet();
	}
	
	public Set<Entry<Class<? extends Module>, Module>> getModuleEntries()
	{
		return this.modules.entrySet();
	}
	
	public Collection<Module> getModules()
	{
		return this.modules.values();
	}

}
