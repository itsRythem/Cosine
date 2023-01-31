package team.cosine.module.settings.impl;

import java.awt.Color;

import team.cosine.module.settings.Setting;

public final class ColorPicker extends Setting {

	private Color color;
	
	private float hue,
		saturation,
		brightness,
		alpha;
	
	private boolean expanded;
	
	public ColorPicker(final String name, final int color)
	{
		this.name = name;
		this.setColor(color);
	}
	
	public int getColor()
	{
		final Color color = new Color(Color.HSBtoRGB(hue, saturation, brightness));
		
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha).getRGB();
	}
	
	public void setColor(final int color)
	{
		this.color = new Color(color);
		
        float[] hsb = new float[3];
        hsb = Color.RGBtoHSB(this.color.getRed(), this.color.getGreen(), this.color.getBlue(), hsb);
        
        this.hue = hsb[0];
        this.saturation = hsb[1];
        this.brightness = hsb[2];
	}

	public float getHue()
	{
		return this.hue;
	}

	public void setHue(final float hue)
	{
		this.hue = hue;
	}

	public float getSaturation()
	{
		return saturation;
	}

	public void setSaturation(final float saturation)
	{
		this.saturation = saturation;
	}

	public float getBrightness()
	{
		return brightness;
	}

	public void setBrightness(final float brightness)
	{
		this.brightness = brightness;
	}
	
	public float getAlpha()
	{
		return alpha;
	}

	public void setAlpha(final float alpha)
	{
		this.alpha = alpha;
	}
	
	public void expand()
	{
		this.expanded = !this.expanded;
	}
	
	public boolean isExpanded()
	{
		return this.expanded;
	}
	
}
