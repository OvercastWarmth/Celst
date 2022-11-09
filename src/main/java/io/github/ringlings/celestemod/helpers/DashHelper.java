package io.github.ringlings.celestemod.helpers;

import io.github.ringlings.celestemod.CelesteMod;
import io.github.ringlings.celestemod.registry.CelesteEnchantments;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class DashHelper {

	public static int currentDashes = 0;
	public static int maxDashes;
	public static int extraDashes;
	public static boolean isDashing;

	static int coolDown = 0;
	static int configCoolDown = CelesteMod.CONFIG.dash_cool_down();

	static float velocityMultiplier = CelesteMod.CONFIG.dash_velocity();

	public static void dash(ClientPlayerEntity PLAYER) {
		if (currentDashes == 0 || coolDown > 0) {
			return;
		}

		float pitch = PLAYER.getPitch();
		float yaw = PLAYER.getYaw();
		float roll = PLAYER.getRoll();

		float x = (-MathHelper.sin(yaw * (float) (Math.PI / 180.0)) * MathHelper.cos(pitch * (float) (Math.PI / 180.0))) * velocityMultiplier;
		float y = (-MathHelper.sin((pitch + roll) * (float) (Math.PI / 180.0))) * velocityMultiplier;
		float z = (MathHelper.cos(yaw * (float) (Math.PI / 180.0)) * MathHelper.cos(pitch * (float) (Math.PI / 180.0))) * velocityMultiplier;

		PLAYER.setVelocity(x, y, z);
		PLAYER.setNoGravity(true);
		PLAYER.setNoDrag(true);

		currentDashes--;
		coolDown = configCoolDown;
		isDashing = true;
	}

	public static void updateDashCount(ClientPlayerEntity PLAYER, int MAX_DASHES) {
		maxDashes = MAX_DASHES;

		var itemStack = PLAYER.getEquippedStack(EquipmentSlot.CHEST);
		int level = EnchantmentHelper.getLevel(CelesteEnchantments.DASH, itemStack);
		if (level >= 1) {
			extraDashes = level;
		}

		if (PLAYER.isOnGround() && coolDown < configCoolDown / 2) {
			currentDashes = maxDashes + extraDashes;
		}

		if (coolDown > 0) {
			coolDown--;
		}

		if (coolDown == 0) {
			PLAYER.setNoGravity(false);
			PLAYER.setNoDrag(false);
			Vec3d vel = PLAYER.getVelocity();
			PLAYER.setVelocity(vel.multiply(0.75));
			coolDown = -1;
			isDashing = false;
		}

		// yeah im lazy so im gonna change the player data

		if (configCoolDown != CelesteMod.CONFIG.dash_cool_down()) {
			configCoolDown = CelesteMod.CONFIG.dash_cool_down();
		}
		if (velocityMultiplier != CelesteMod.CONFIG.dash_velocity()) {
			if (CelesteMod.CONFIG.dash_velocity() > 10f) {
				CelesteMod.CONFIG.dash_velocity(10f);
			}
			if (CelesteMod.CONFIG.dash_velocity() < -10f) {
				CelesteMod.CONFIG.dash_velocity(-10f);
			}
			velocityMultiplier = CelesteMod.CONFIG.dash_velocity();
		}
	}
}
