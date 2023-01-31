package dev.rythem.cosine.module.settings.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.rythem.cosine.module.settings.Setting;

public class ComboBox extends Setting {

	private final List<String> options = new ArrayList<String>();
	private String option;
	
	public ComboBox(final String name, final String... options)
	{
		this.name = name;
		this.options.addAll(Arrays.asList(option));
		if(this.options.size() > 0) this.option = this.options.get(0);
	}
	
	public List<String> getOptions()
	{
		return this.options;
	}
	
	public boolean is(final String option)
	{
		return this.option.equalsIgnoreCase(option);
	}
	
	public String getOption() {return this.option;}
	public void setOption(final String option) {this.option = option;}
	
}
