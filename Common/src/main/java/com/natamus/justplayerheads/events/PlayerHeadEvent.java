package com.natamus.justplayerheads.events;

import com.natamus.collective.data.GlobalVariables;
import com.natamus.collective.features.PlayerHeadCacheFeature;
import com.natamus.justplayerheads.config.ConfigHandler;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;

public class PlayerHeadEvent {
	public static void onPlayerDeath(ServerLevel world, ServerPlayer player) {
		if (!ConfigHandler.playerDropsHeadOnDeath) {
			return;
		}
		
		if (ConfigHandler.onlyDropHeadsByPlayerKill) {
			if (!(damageSource.getDirectEntity() instanceof Player)) {
				return;
			}
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
			player.spawnAtLocation(headStack, 1);
		}
	}
}
