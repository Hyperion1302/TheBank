package com.Hyperion1302.TheBank.Commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
	
	private static HashMap<String, CommandInterface> commands = new HashMap<String, CommandInterface>();
	
	public void register(String name, CommandInterface cmd) {
		commands.put(name, cmd);
    }
	
	public boolean exists(String name) {
		return commands.containsKey(name);
	}
	
	public CommandInterface getExecutor(String name) {
		return commands.get(name);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			if (args.length == 0) {
				getExecutor("thebank").onCommand(sender, cmd, label, args);
			}
			
			if (args.length > 0) {
				
				if (exists(args[0])) {
					getExecutor(args[0]).onCommand(sender, cmd, label, args);
					return true;
				} else {
					sender.sendMessage("This command does not exist.");
				}
			}
		} else {
			sender.sendMessage("You must be a player to do this!");
			return true;
		}
		return false;
	}

}
