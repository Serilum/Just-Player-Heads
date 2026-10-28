package com.serilum.justplayerheads;

import com.natamus.collective.features.PlayerHeadCacheFeature;
import com.serilum.justplayerheads.config.ConfigHandler;

public class ModCommon {

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		PlayerHeadCacheFeature.enableHeadCaching();
	}
}