package com.natamus.justplayerheads.events;

import com.natamus.collective.data.GlobalVariables;
import com.natamus.collective.functions.HeadFunctions;
import com.natamus.justplayerheads.config.ConfigHandler;
import com.natamus.justplayerheads.util.Variables;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class PlayerHeadEvent {
	public static void onPlayerDeath(ServerLevel world, ServerPlayer player) {
		if (!ConfigHandler.playerDropsHeadOnDeath) {
			return;
		}
		
		double num = GlobalVariables.random.nextDouble();
		if (num > ConfigHandler.playerHeadDropChance) {
			return;
		}
		
		String name = player.getName().getString();
		
		ItemStack head = null;
		if (ConfigHandler.enablePlayerHeadCaching) {
			if (Variables.headcache.containsKey(name.toLowerCase())) {
				head = Variables.headcache.get(name.toLowerCase());
			}
		}
		
		if (head == null) {
			head = HeadFunctions.getPlayerHead(name, 1);
			
			if (head != null && ConfigHandler.enablePlayerHeadCaching) {
				ItemStack cachehead = head.copy();
				
				Variables.headcache.put(name.toLowerCase(), cachehead);
			}
		}
		
		if (head == null) {
			return;
		}
		
		player.spawnAtLocation(head, 1);
	}
}
