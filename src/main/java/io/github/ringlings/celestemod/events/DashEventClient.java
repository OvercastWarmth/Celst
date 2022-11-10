package io.github.ringlings.celestemod.events;

import io.github.ringlings.celestemod.CelesteMod;
import io.github.ringlings.celestemod.helpers.DashHelper;
import io.github.ringlings.celestemod.key_binds.CelesteKeyBinds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientTickEvents;

public class DashEventClient implements ClientTickEvents.End {
	public static int BASE_DASH_LEVEL = CelesteMod.CONFIG.default_dashes();

	@Override
	public void endClientTick(MinecraftClient client) {
		if (client.player == null) return;
		ClientPlayerEntity PLAYER = client.player;

		boolean dashPressed = CelesteKeyBinds.DASH.isPressed();

		if (dashPressed) {
			DashHelper.dash(PLAYER);
		}

		DashHelper.updateDashCount(PLAYER, BASE_DASH_LEVEL);
	}
}
