package io.github.ringlings.celestemod.config;

import io.github.ringlings.celestemod.CelesteMod;
import io.github.ringlings.celestemod.events.DashEventClient;
import io.github.ringlings.celestemod.helpers.DashHelper;

public class CelesteModConfigHooks {
	public static void subscribeToHooks() {
		CelesteMod.CONFIG.subscribeToDefault_dashes(value -> {
			DashEventClient.BASE_DASH_LEVEL = value;
		});

		CelesteMod.CONFIG.subscribeToDash_velocity(value -> {
			DashHelper.velocityMultiplier = value;
		});

		CelesteMod.CONFIG.subscribeToDash_cool_down(value -> {
			DashHelper.configCoolDown = value;
		});

		CelesteMod.CONFIG.subscribeToDash_slowdown(value -> {
			DashHelper.dashSlowdown = value;
		});
	}
}
