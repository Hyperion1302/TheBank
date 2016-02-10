package com.Hyperion1302.TheBank;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;

import com.Hyperion1302.TheBank.Listeners.PlayerJoin;

public class API {
	
	private static API instance = new API();
	public static API getInstance() {
		return instance;
	}
	
	public String colourize(String msg) {
		msg = ChatColor.translateAlternateColorCodes('&', msg);
		return msg;
	}
	
	public void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		
		PlayerJoin pj = new PlayerJoin();
		
		pm.registerEvents(pj, Core.getInstance());
	}

}
