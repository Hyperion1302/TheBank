package com.Hyperion1302.TheBank;

import org.bukkit.ChatColor;

public class API {
	
	private static API instance = new API();
	public static API getInstance() {
		return instance;
	}
	
	public String colourize(String msg) {
		msg = ChatColor.translateAlternateColorCodes('&', msg);
		return msg;
	}

}
