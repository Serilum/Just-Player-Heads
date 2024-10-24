package com.natamus.justplayerheads.events;

import com.natamus.collective.data.GlobalVariables;
import com.natamus.collective.features.PlayerHeadCacheFeature;
import com.natamus.justplayerheads.config.ConfigHandler;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class PlayerHeadEvent {
	public static void onPlayerDeath(ServerLevel serverLevel, ServerPlayer player) {
		if (!ConfigHandler.playerDropsHeadOnDeath) {
			return;
		}
		
		double num = GlobalVariables.random.nextDouble();
		if (num > ConfigHandler.playerHeadDropChance) {
			return;
		}
		
		String playerName = player.getName().getString();
		
		ItemStack headStack = PlayerHeadCacheFeature.getPlayerHeadStackFromCache(player);
		if (headStack == null) {
			headStack = PlayerHeadCacheFeature.getPlayerHeadStackFromCache(player.serverLevel(), player.getName().getString());
		}

		if (headStack != null) {
			player.spawnAtLocation(serverLevel, headStack, 1);
		}
	}
}
