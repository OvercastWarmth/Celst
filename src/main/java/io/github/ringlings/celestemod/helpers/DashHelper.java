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
	public static int configCoolDown = CelesteMod.CONFIG.dash_cool_down();
	static int coolDown = 0;

	public static float velocityMultiplier = CelesteMod.CONFIG.dash_velocity();

	public static double dashSlowdown = CelesteMod.CONFIG.dash_slowdown();

	public static boolean isDashing;

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
		} else {
			extraDashes = 0;
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
			PLAYER.setVelocity(vel.multiply(dashSlowdown));
			coolDown = -1;
			isDashing = false;
		}
	}
}
