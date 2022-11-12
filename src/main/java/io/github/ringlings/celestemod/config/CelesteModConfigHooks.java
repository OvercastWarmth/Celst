package io.github.ringlings.celestemod.config;

import io.github.ringlings.celestemod.CelesteMod;
import io.github.ringlings.celestemod.events.DashEventClient;
import io.github.ringlings.celestemod.helpers.DashHelperClient;
import org.quiltmc.loader.api.minecraft.ClientOnly;

// Hooks for keeping applicable config options up to date internally
@ClientOnly
public class CelesteModConfigHooks {
	public static void subscribeToHooks() {
		CelesteMod.CONFIG.subscribeToDefaultDashes(value -> DashEventClient.baseDashLevel = value);
		CelesteMod.CONFIG.subscribeToDashVelocity(value -> DashHelperClient.velocityMultiplier = value);
		CelesteMod.CONFIG.subscribeToDashCoolDown(value -> DashHelperClient.configCoolDown = value);
		CelesteMod.CONFIG.subscribeToDashSlowdown(value -> DashHelperClient.dashSlowdown = value);
	}
}
