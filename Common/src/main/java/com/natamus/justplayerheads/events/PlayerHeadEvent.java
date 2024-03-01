package com.natamus.justplayerheads.events;

import com.natamus.collective.data.GlobalVariables;
import com.natamus.collective.functions.HeadFunctions;
import com.natamus.justplayerheads.config.ConfigHandler;
import com.natamus.justplayerheads.data.Variables;

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
		
		String playerName = player.getName().getString();
		
		ItemStack headStack = null;
		if (ConfigHandler.enablePlayerHeadCaching) {
			if (Variables.headcache.containsKey(playerName.toLowerCase())) {
				headStack = Variables.headcache.get(playerName.toLowerCase());
			}
		}
		
		if (headStack == null) {
			headStack = HeadFunctions.getPlayerHead(playerName, 1);
			
			if (headStack != null && ConfigHandler.enablePlayerHeadCaching) {
				Variables.headcache.put(playerName.toLowerCase(), headStack.copy());
			}
		}
		
		if (headStack == null) {
			return;
		}
		
		player.spawnAtLocation(headStack, 1);
	}
}
