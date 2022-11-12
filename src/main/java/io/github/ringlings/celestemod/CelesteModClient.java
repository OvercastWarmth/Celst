package io.github.ringlings.celestemod;

import io.github.ringlings.celestemod.config.CelesteModConfigHooks;
import io.github.ringlings.celestemod.events.DashEventClient;
import io.github.ringlings.celestemod.keybinds.CelesteKeyBinds;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientTickEvents;

@ClientOnly
public class CelesteModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		ClientTickEvents.END.register(new DashEventClient());

		KeyBindingHelper.registerKeyBinding(CelesteKeyBinds.DASH);

		CelesteModConfigHooks.subscribeToHooks();
	}
}
