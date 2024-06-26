package com.natamus.justplayerheads.neoforge.events;

import com.natamus.justplayerheads.cmds.CommandJph;
import com.natamus.justplayerheads.events.PlayerHeadEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class NeoForgePlayerHeadEvent {
	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent e) {
		CommandJph.register(e.getDispatcher());
	}
	
	@SubscribeEvent
	public static void entityDeath(LivingDeathEvent e) {
		Entity entity = e.getEntity();
		Level level = entity.level();
		if (level.isClientSide) {
			return;
		}

		if (!(entity instanceof Player)) {
			return;
		}

		PlayerHeadEvent.onPlayerDeath((ServerLevel)level, (ServerPlayer)entity);
	}
}
