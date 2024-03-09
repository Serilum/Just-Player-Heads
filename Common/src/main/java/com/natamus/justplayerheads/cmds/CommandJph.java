package com.natamus.justplayerheads.cmds;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.natamus.collective.functions.HeadFunctions;
import com.natamus.collective.functions.ItemFunctions;
import com.natamus.collective.functions.MessageFunctions;
import com.natamus.justplayerheads.config.ConfigHandler;
import com.natamus.justplayerheads.data.Variables;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;

public class CommandJph {
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("jph")
				.requires((iCommandSender) -> iCommandSender.getEntity() instanceof Player && iCommandSender.hasPermission(2))
				.then(Commands.literal("head")
				.then(Commands.argument("name", StringArgumentType.word())
				.then(Commands.argument("amount", IntegerArgumentType.integer(1, 64))
				.executes((command) -> {
					int amount = 1;
					int specifiedAmount = IntegerArgumentType.getInteger(command, "amount");
					if (specifiedAmount > 1 && specifiedAmount <= 64) {
						amount = specifiedAmount;
					}
					
					processJph(command, amount);
					return 1;
				}))))

				.then(Commands.literal("head")
				.then(Commands.argument("name", StringArgumentType.word())
				.executes((command) -> {
					processJph(command, 1);
					return 1;
				})))

				.then(Commands.literal("cache")
				.executes((command) -> {
					CommandSourceStack source = command.getSource();
					
					Variables.headcache = new HashMap<String, ItemStack>();
					
					MessageFunctions.sendMessage(source, "The player head texture cache has been emptied.", ChatFormatting.DARK_GREEN);
					return 1;
				}))

				.executes((command) -> {
					CommandSourceStack source = command.getSource();

					MessageFunctions.sendMessage(source, "Allows you to get the head of a player.", ChatFormatting.DARK_GREEN);
					MessageFunctions.sendMessage(source, " Usage: /jph playerName (amount)", ChatFormatting.DARK_GREEN);
					return 1;
				})
			);
	}
	
	public static void processJph(CommandContext<CommandSourceStack> command, Integer amount) {
		CommandSourceStack source = command.getSource();
		
		String target = StringArgumentType.getString(command, "name");
		
		ItemStack head = null;
		if (ConfigHandler.enablePlayerHeadCaching) {
			if (Variables.headcache.containsKey(target.toLowerCase())) {
				head = Variables.headcache.get(target.toLowerCase());
				head.setCount(amount);
			}
		}
		
		if (head == null) {
			head = HeadFunctions.getPlayerHead(target, amount);
			
			if (head != null && ConfigHandler.enablePlayerHeadCaching) {
				ItemStack cachehead = head.copy();
				cachehead.setCount(1);
				
				Variables.headcache.put(target.toLowerCase(), cachehead);
			}
		}

		if (head == null) {
			String message = "Unable to generate the player head. Either the player '" + target + "' does not exist or the Mojang API server has had too many requests in a short period of time.";
			MessageFunctions.sendMessage(source, message, ChatFormatting.DARK_RED);
		}
		else {
			String message = "Succesfully generated the head of the player '" + target + "'.";
			MessageFunctions.sendMessage(source, message, ChatFormatting.DARK_GREEN);
			
			Player player = source.getPlayer();
			ItemFunctions.giveOrDropItemStack(player, head);
		}
	}
}