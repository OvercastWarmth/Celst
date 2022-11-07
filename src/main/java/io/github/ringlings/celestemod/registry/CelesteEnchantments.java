package io.github.ringlings.celestemod.registry;

import io.github.ringlings.celestemod.enchantments.DashEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CelesteEnchantments {
	public static Enchantment DASH = new DashEnchantment();

	public static void RegisterEnchantments() {
		Registry.register(Registry.ENCHANTMENT, new Identifier("celestemod", "dash"), DASH);
	}
}
