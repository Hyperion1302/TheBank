package com.Hyperion1302.TheBank.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.Hyperion1302.TheBank.API;
import com.Hyperion1302.TheBank.Core;

public class PlayerJoin implements Listener {
	
	API api = API.getInstance();
	Core core = Core.getInstance();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		player.sendMessage("Bob");
		
		//Alert - If server is using plugin (OP only)
		if (player.isOp()) {
			player.sendMessage(api.colourize("&c&lAlert> This server is using " + core.pdf.getName()));
		}
	}

}
