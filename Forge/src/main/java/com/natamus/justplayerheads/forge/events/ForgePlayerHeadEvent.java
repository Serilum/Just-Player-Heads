package com.natamus.justplayerheads.forge.events;

import com.natamus.justplayerheads.cmds.CommandJph;
import com.natamus.justplayerheads.events.PlayerHeadEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgePlayerHeadEvent {
	public static void registerEventsInBus() {
		BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgePlayerHeadEvent.class);
	}

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
