package com.Hyperion1302.TheBank;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
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
	
	public void saveCustomFile(File file, FileConfiguration fileconfig) {
		try {
			fileconfig.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
