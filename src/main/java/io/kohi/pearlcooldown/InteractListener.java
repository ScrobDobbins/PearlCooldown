package io.kohi.pearlcooldown;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener
{
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{	
		if(event.getPlayer().getGameMode() != GameMode.CREATIVE && event.getItem().getType() == Material.ENDER_PEARL && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK))
		{
			Player thePlayer = event.getPlayer();
			long currTime = System.currentTimeMillis();
			
			if(PearlCooldown.cooldown.get(thePlayer.getUniqueId()) != null)
			{
				long pearlTime = PearlCooldown.cooldown.get(thePlayer.getUniqueId());
				long timeDiff = currTime - pearlTime;
				
				if(timeDiff < PearlCooldown.CoolDown)
				{
					thePlayer.sendMessage("You cannot pearl again for another " + String.format("%.2f", (PearlCooldown.CoolDown - timeDiff) / 1000F) + " seconds.");
					event.setCancelled(true);
				}
				else
				{
					PearlCooldown.cooldown.put(thePlayer.getUniqueId(), currTime);
				}
			}
			else
			{
				PearlCooldown.cooldown.put(thePlayer.getUniqueId(), currTime);
			}
		}
	}
}