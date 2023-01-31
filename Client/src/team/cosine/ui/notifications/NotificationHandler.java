package team.cosine.ui.notifications;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import team.cosine.integrated.Handler;
import team.cosine.ui.notifications.api.Notification;
import team.cosine.ui.notifications.api.NotificationType;

public class NotificationHandler extends Handler {
	
	protected static Minecraft mc = Minecraft.getMinecraft();
	
	private final List<Notification> queue = new CopyOnWriteArrayList<Notification>(),
			active = new CopyOnWriteArrayList<Notification>();
	
	public NotificationHandler()
	{
	}
	
	@Override
	public void load()
	{
	}

	@Override
	public void unload()
	{
		queue.clear();
		active.clear();
	}
	
	public void render()
	{
		
	}
	
	public void draw(final String title, final String body, final NotificationType type, final long time, final long duration, final float x, final float y, final float width, final float height)
	{
		
	}
	
	public void cancel(final Notification notification)
	{
		if(this.queue.contains(notification))
			this.queue.remove(notification);
		
		if(this.active.contains(notification))
			this.active.remove(notification);
	}

	public boolean exists(final Notification notification)
	{
		return (this.queue.contains(notification) || this.active.contains(notification));
	}
	
	public boolean isActive(final Notification notification)
	{
		return this.active.contains(notification);
	}
	
	public void post(final Notification notification)
	{
		this.queue.add(notification);
	}
	
}
