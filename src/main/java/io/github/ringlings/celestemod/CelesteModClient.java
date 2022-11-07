package io.github.ringlings.celestemod;

import io.github.ringlings.celestemod.key_binds.CelesteKeyBinds;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

@ClientOnly
public class CelesteModClient implements ClientModInitializer {


	@Override
	public void onInitializeClient(ModContainer mod) {

		KeyBindingHelper.registerKeyBinding(CelesteKeyBinds.DASH);
	}
}
