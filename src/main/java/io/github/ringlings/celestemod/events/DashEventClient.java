package io.github.ringlings.celestemod.events;

import io.github.ringlings.celestemod.CelesteMod;
import io.github.ringlings.celestemod.helpers.DashHelperClient;
import io.github.ringlings.celestemod.keybinds.CelesteKeyBinds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientTickEvents;

@ClientOnly
public class DashEventClient implements ClientTickEvents.End {
	public static int baseDashLevel = CelesteMod.CONFIG.defaultDashes();

	@Override
	public void endClientTick(MinecraftClient client) {
		// We don't want to do anything if there's no player lmao
		if (client.player == null) return;

		// Store the player for later use
		ClientPlayerEntity player = client.player;
		// Check if the player is attempting to dash
		boolean dashPressed = CelesteKeyBinds.DASH.isPressed();

		// If they are trigger the relevant function
		if (dashPressed) {
			DashHelperClient.dash(player);
		}

		// No matter what, do the regular dash checks
		DashHelperClient.tick(player, baseDashLevel);
	}
}
