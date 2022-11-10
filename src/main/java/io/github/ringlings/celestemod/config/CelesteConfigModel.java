package io.github.ringlings.celestemod.config;

import io.wispforest.owo.config.annotation.*;


@SuppressWarnings({"unused", "InnerClassMayBeStatic"})
@Modmenu(modId = "celestemod")
@Config(name = "celestemod", wrapperName = "CelesteConfig")
public class CelesteConfigModel {
	@SectionHeader("dashingConfigs")

	@Hook
//	@Sync(Option.SyncMode.OVERRIDE_CLIENT)
	public int default_dashes = 0;

	@Hook
//	@Sync(Option.SyncMode.OVERRIDE_CLIENT)
	public float dash_velocity = 2.0f;

	@Hook
//	@Sync(Option.SyncMode.OVERRIDE_CLIENT)
	public int dash_cool_down = 5;

	@Hook
	public double dash_slowdown = 0.6;

	@RestartRequired
	public int max_dash_level = 2;

	@RestartRequired
	public boolean dash_treasure_enchantment = true;
}
