package io.github.ringlings.celestemod.enchantments;

import io.github.ringlings.celestemod.CelesteMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class DashEnchantment extends Enchantment {
	public DashEnchantment() {
		super(Rarity.RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
	}

	@Override
	public int getMaxLevel() {
		return CelesteMod.CONFIG.max_dash_level();
	}

	public boolean isTreasure() {
		return CelesteMod.CONFIG.dash_treasure_enchantment();
	}
}
