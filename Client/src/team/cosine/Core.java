package team.cosine;

import team.cosine.event.EventHandler;
import team.cosine.integrated.Handler;
import team.cosine.module.ModuleHandler;
import team.cosine.ui.notifications.NotificationHandler;

public final class Core {
	
	private final ModuleHandler moduleHandler = new ModuleHandler();
	private final EventHandler eventHandler = new EventHandler();
	private final NotificationHandler notificationHandler = new NotificationHandler();
	public double frameDelta;
	
	public void load()
	{
		moduleHandler.load();
		eventHandler.load();
		notificationHandler.load();
	}
	
	public void unload()
	{
		moduleHandler.unload();
		eventHandler.unload();
		notificationHandler.unload();
	}
	
	public ModuleHandler getModuleHandler() {return this.moduleHandler;}
	public EventHandler getEventHandler() {return this.eventHandler;}
	public NotificationHandler getNotificationHandler() {return this.notificationHandler;}
	
}
