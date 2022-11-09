package io.github.ringlings.celestemod.config;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.RestartRequired;
import org.quiltmc.config.api.annotations.Comment;


@SuppressWarnings("unused")
@Modmenu(modId = "celestemod")
@Config(name = "celestemod", wrapperName = "CelesteConfig")
public class CelesteConfigModel {
	//	default dash amount
	@Comment("Default number of dashes the player has (without the dash enchantment)")
	public int default_dashes = 0;

	//	max dash level enchantment
	@RestartRequired
	@Comment("Maximum level you can get for the dash enchantment in the enchanting table")
	public int max_dash_level = 2;

	@RestartRequired
	@Comment("Whether the dash enchantment is obtainable in an enchanting table or not")
	public boolean dash_treasure_enchantment = true;

	//	dash velocity
	@Comment("Multiplier for dash velocity")
	public float dash_velocity = 1.0f;

	//	cool-down
	@Comment("Cool-down for dashing (in ticks)")
	public int dash_cool_down = 10;
}
