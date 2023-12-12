package com.natamus.justplayerheads.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.justplayerheads.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry public static boolean enablePlayerHeadCaching = true;
	@Entry public static boolean playerDropsHeadOnDeath = true;
	@Entry(min = 0.0001, max = 1.0) public static double playerHeadDropChance = 1.0;

	public static void initConfig() {
		configMetaData.put("enablePlayerHeadCaching", Arrays.asList(
			"If enabled, enables the caching of player head textures. This fixes the limitations of the Mojang API, but does mean that whenever players update their skin the old head is still dropped until the server reboots or an administator uses the '/jph cache' command."
		));
		configMetaData.put("playerDropsHeadOnDeath", Arrays.asList(
			"If enabled, allows players to drop their head on death."
		));
		configMetaData.put("playerHeadDropChance", Arrays.asList(
			"Sets the chance of a player dropping their head if 'playerDropsHeadOnDeath' is enabled."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}