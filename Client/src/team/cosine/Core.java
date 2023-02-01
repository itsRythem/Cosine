package team.cosine;

import net.minecraft.client.gui.Gui;
import team.cosine.animation.Animation;
import team.cosine.animation.Easing;
import team.cosine.event.EventHandler;
import team.cosine.event.api.EventHook;
import team.cosine.event.impl.EventRenderGui;
import team.cosine.integrated.Console;
import team.cosine.integrated.Handler;
import team.cosine.module.KeybindHandler;
import team.cosine.module.ModuleHandler;
import team.cosine.ui.notifications.NotificationHandler;
import team.cosine.util.render.RenderUtil;

public final class Core {
	
	private final Console console = new Console(); // DO NOT USE THIS
	
	private final ModuleHandler moduleHandler = new ModuleHandler();
	private final EventHandler eventHandler = new EventHandler();
	private final NotificationHandler notificationHandler = new NotificationHandler();
	private final KeybindHandler keybindHandler = new KeybindHandler();
	
	public void load()
	{
		//console.initiate(); WIP
		
		moduleHandler.load();
		eventHandler.load();
		notificationHandler.load();
		keybindHandler.load();
		
		eventHandler.register(this);
		
	}
	
	private Animation animation = new Animation();
	
	@EventHook
	public void onRenderGui(final EventRenderGui event)
	{
		animation.animate((System.currentTimeMillis() % 2500 > 500 ? 100 : 300), 1, Easing.ELASTIC_OUT);

        RenderUtil.drawRect(animation.getValue() + 60, 10, animation.getValue() + 80, 20, -1);
	}
	
	public void unload()
	{
		moduleHandler.unload();
		eventHandler.unload();
		notificationHandler.unload();
		keybindHandler.unload();
		
		//console.terminate(); WIP
	}
	
	public Console getConsole() {return this.console;}
	public ModuleHandler getModuleHandler() {return this.moduleHandler;}
	public EventHandler getEventHandler() {return this.eventHandler;}
	public NotificationHandler getNotificationHandler() {return this.notificationHandler;}
	public KeybindHandler getKeybindHandler() {return this.keybindHandler;}
	
}
