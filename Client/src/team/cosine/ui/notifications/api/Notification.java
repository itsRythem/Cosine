package team.cosine.ui.notifications.api;

public class Notification {
	
	private final String title, body;
	private final NotificationType type;
	private long time, duration;
	
	public Notification(final String title, final String body, final long duration, final NotificationType type)
	{
		this.title = title;
		this.body = body;
		this.duration = duration;
		this.type = type;
		
		this.time = System.currentTimeMillis();
	}

	public String getTitle()
	{
		return title;
	}

	public String getBody()
	{
		return body;
	}

	public NotificationType getType()
	{
		return type;
	}

	public long getTime()
	{
		return time;
	}

	public long getDuration()
	{
		return duration;
	}
	
	public void resetTime()
	{
		this.time = System.currentTimeMillis();
	}
	
}
