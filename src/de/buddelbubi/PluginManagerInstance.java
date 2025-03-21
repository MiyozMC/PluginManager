package de.buddelbubi;

import cn.nukkit.Server;


import cn.nukkit.command.Command;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import de.buddelbubi.commands.PluginManagerCommand;
import de.buddelbubi.commands.PluginManagerReloadCommand;
import de.buddelbubi.listeners.PluginCallListener;
import de.buddelbubi.listeners.UIListener;

public class PluginManagerInstance extends PluginBase {

	public static Plugin plugin;
	
	public static final String prefix = "§ePluginManager §8» §7";
	
	public void onEnable() {
		
		plugin = this;
	
		Command command = new PluginManagerCommand("pluginmanager");
		command.setAliases(new String[] {"pm"});
		command.setDescription("PluginManager的主命令");
		
		getServer().getCommandMap().register(command.getName(), command);
		
		Command reload = new PluginManagerReloadCommand("reload");
		reload.setAliases(new String[] {"rl"});
		reload.setPermission("nukkit.command.reload");
		getServer().getCommandMap().register(reload.getName(), reload);
		
		getServer().getPluginManager().registerEvents(new UIListener(), this);
		getServer().getPluginManager().registerEvents(new PluginCallListener(), this);
		
	}
	
	
	
	public static PluginManager getPluginManager() {
		return Server.getInstance().getPluginManager();
	}
	
}
