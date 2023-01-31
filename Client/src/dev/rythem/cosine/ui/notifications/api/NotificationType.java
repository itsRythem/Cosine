package dev.rythem.cosine.ui.notifications.api;

public enum NotificationType {

	SUCCESS("A", 0xFF62d14b),
	WARNING("B", 0xFFd4c24c),
	ERROR("C", 0xFFde5959),
	QUESTION("D", 0xFFd1cec9),
	MUSIC("E", 0xFF81db93),
	MARKET("F", 0xFF819edb),
	PURCHASE_DECLINED("G", -1),
	MARKET_SALE("H", -1),
	MESSAGE("I", 0xFFdb819e),
	SCRIPT("J", 0xFF5c6673),
	GIFT("K", 0xFFc66ccc),
	LINK("L", 0xFF6cb6cc),
	FILE("M", 0xFF71db93),
	FRIEND_REQUEST("N", -1),
	UPDATE_REQUIRED("O", -1),
	SCANNING("P", -1);
	
	private final String icon;
	private final int color;
	
	NotificationType(final String icon, final int color)
	{
		this.icon = icon;
		this.color = color;
	}
	
	public String icon()
	{
		return this.icon;
	}
	
	public int color()
	{
		return this.color;
	}
	
}
