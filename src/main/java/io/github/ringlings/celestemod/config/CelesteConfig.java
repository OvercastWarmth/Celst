package io.github.ringlings.celestemod.config;

import org.quiltmc.config.api.WrappedConfig;
import org.quiltmc.config.api.annotations.Comment;
import org.quiltmc.config.api.annotations.FloatRange;

public class CelesteConfig extends WrappedConfig {
	@Comment("Configuration for dashes")
	public final DashConfig dash = new DashConfig();

	public class DashConfig implements Section {
		//	default dash amount
		@Comment("Default number of dashes the player has (without the dash enchantment)")
		public final int default_dashes = 0;

		//	max dash level enchantment
		@Comment("Maximum level you can get for the dash enchantment in the enchanting table")
		public final int max_dash_level = 2;

		//	dash velocity
		@Comment("Multiplier for dash velocity")
		@FloatRange(min = 0f, max = 10f)
		public final float dash_velocity = 1.0f;

		//	cool-down
		@Comment("Cool-down for dashing (in ticks)")
		public final int dash_cool_down = 10;
	}
}
