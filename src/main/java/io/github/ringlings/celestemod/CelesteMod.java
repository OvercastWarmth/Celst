package io.github.ringlings.celestemod;

import io.github.ringlings.celestemod.config.CelesteConfig;
import io.github.ringlings.celestemod.registry.CelesteEnchantments;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CelesteMod implements ModInitializer {
	//	This logger is used to write text to the console and the log file.
//	It is considered best practice to use your mod name as the logger's name.
//	That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("CelesteMod");
	public static final CelesteConfig CONFIG = CelesteConfig.createAndLoad();

	@Override
	public void onInitialize(ModContainer mod) {
		// :approveline:
		LOGGER.info("hi so uh yeah hi intellij keeps screaming at me because the logger in our mod is unused so im just gonna throw this here so that it stops doing that k thanks enjoy the mod");

		CelesteEnchantments.RegisterEnchantments();
	}
}
