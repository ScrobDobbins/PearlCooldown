package io.kohi.pearlcooldown;

import java.util.HashMap;
import java.util.UUID;

import net.cubespace.Yamler.Config.InvalidConfigurationException;

import org.bukkit.plugin.java.JavaPlugin;

import io.kohi.pearlcooldown.InteractListener;

public class PearlCooldown extends JavaPlugin
{
	private PearlConfig pearlConfig = null;
	public static HashMap<UUID, Long> cooldown = new HashMap<UUID, Long>();
	public static long CoolDown;
	
	@Override
	public void onEnable()
	{
		getLogger().info("PearlCooldown Started..");
		try
		{
			pearlConfig = new PearlConfig(this);
			pearlConfig.init();
			CoolDown = pearlConfig.getCooldownLength() * 1000;
		}
		catch(InvalidConfigurationException ex)
		{
			getLogger().severe("Invalid configuration file...");
			ex.printStackTrace();
		}
		getServer().getPluginManager().registerEvents(new InteractListener(), this);
	}
	
	@Override
	public void onDisable()
	{
		getLogger().info("PearlCooldown Unloading..");
	}
}