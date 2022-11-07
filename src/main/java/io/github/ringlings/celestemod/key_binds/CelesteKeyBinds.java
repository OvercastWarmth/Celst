package io.github.ringlings.celestemod.key_binds;

import net.minecraft.client.option.KeyBind;
import org.lwjgl.glfw.GLFW;

// We looked at Ok Zoomer's keybind code to make this, thamk ennui
public class CelesteKeyBinds {

	// Keybind Category
	public static final String CELESTE_KEYBIND_CATEGORY = "key.celestemod.category";

	// Dash Keybind
	public static final KeyBind DASH = new KeyBind("key.celestemod.dash", GLFW.GLFW_KEY_R, CELESTE_KEYBIND_CATEGORY);
}
