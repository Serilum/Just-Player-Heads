package com.natamus.justplayerheads;

import com.natamus.collective.features.PlayerHeadCacheFeature;
import com.natamus.justplayerheads.config.ConfigHandler;

public class ModCommon {

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		PlayerHeadCacheFeature.enableHeadCaching();
	}
}