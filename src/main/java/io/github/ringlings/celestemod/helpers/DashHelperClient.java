package io.github.ringlings.celestemod.helpers;

import io.github.ringlings.celestemod.CelesteMod;
import io.github.ringlings.celestemod.registry.CelesteEnchantments;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.quiltmc.loader.api.minecraft.ClientOnly;

@ClientOnly
public class DashHelperClient {


	public static int currentDashes = 0; // Number of dashes the player currently has while in midair
	public static int dashes; // Number of dashes the player has while idle
	public static int extraDashes; // Extra dashes (added to `dashes`)
	public static int configCoolDown = CelesteMod.CONFIG.dashCoolDown(); // Cool-down for dashing
	static int coolDown = 0; // Current progress in the cool-down

	public static float velocityMultiplier = CelesteMod.CONFIG.dashVelocity(); // Configured multiplier for dash velocity

	public static double dashSlowdown = CelesteMod.CONFIG.dashSlowdown(); // Configured dash slowdown

	public static boolean isDashing; // Whether or not the player is currently dashing

	// Logic for dashing
	public static void dash(ClientPlayerEntity player) {
		// Make sure the player actually has dashes and isn't on cool-down
		if (currentDashes == 0 || coolDown > 0) {
			return;
		}

		// Get the player's looking trio for the velocity calculation
		float pitch = player.getPitch();
		float yaw = player.getYaw();
		float roll = player.getRoll();

		// Velocity trio calculation (absolute mess but this is what bows do so meh)
		float x = (-MathHelper.sin(yaw * (float) (Math.PI / 180.0)) * MathHelper.cos(pitch * (float) (Math.PI / 180.0))) * velocityMultiplier;
		float y = (-MathHelper.sin((pitch + roll) * (float) (Math.PI / 180.0))) * velocityMultiplier / 1.5f;
		float z = (MathHelper.cos(yaw * (float) (Math.PI / 180.0)) * MathHelper.cos(pitch * (float) (Math.PI / 180.0))) * velocityMultiplier;

		// Set the player's velocity and make sure that the movement is linear
		player.setVelocity(x, y, z);
		player.setNoGravity(true);
		player.setNoDrag(true);

		// Subtract one dash, start the cool-down, confirm that the player is, in fact, dashing
		currentDashes--;
		coolDown = configCoolDown;
		isDashing = true;
	}

	// General calculations relating to dashing that are performed every tick
	public static void tick(ClientPlayerEntity player, int maxDashes) {
		// Configure the max dashes to be consistent
		dashes = maxDashes;

		// Calculate the extra dashes from the equipped chest-plate
		ItemStack itemStack = player.getEquippedStack(EquipmentSlot.CHEST);
		int level = EnchantmentHelper.getLevel(CelesteEnchantments.DASH, itemStack);
		if (level >= 1) {
			extraDashes = level;
		} else {
			extraDashes = 0;
		}

		// Give the player back their dashes if applicable
		if (player.isOnGround() && coolDown < configCoolDown / 2) {
			currentDashes = dashes + extraDashes;
		}

		// Tick down the cool-down
		if (coolDown > 0) {
			coolDown--;
		}

		// Do a lot of shit if the cool-down is 0 (im not bothering explaining this)
		if (coolDown == 0) {
			player.setNoGravity(false);
			player.setNoDrag(false);
			Vec3d vel = player.getVelocity();
			player.setVelocity(vel.multiply(dashSlowdown));
			coolDown = -1;
			isDashing = false;
		}
	}
}
