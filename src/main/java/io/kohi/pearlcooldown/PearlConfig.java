package io.kohi.pearlcooldown;

import java.io.File;

import org.bukkit.plugin.Plugin;

import net.cubespace.Yamler.Config.Comment;
import net.cubespace.Yamler.Config.Config;

public class PearlConfig extends Config
{
	public PearlConfig(Plugin plugin)
	{
		CONFIG_HEADER	= new String[]{"PearlCooldown Configuation Settings"};
		CONFIG_FILE		= new File(plugin.getDataFolder(), "PearlCooldown.yml");
	}
	
	@Comment
	(
		"Ender Pearl cooldown time (in seconds)"
	)
	private long CooldownLength = 15;

	public long getCooldownLength()
	{
		return CooldownLength;
	}

	public void setCooldownLength(long cooldownLength)
	{
		CooldownLength = cooldownLength;
	}
}