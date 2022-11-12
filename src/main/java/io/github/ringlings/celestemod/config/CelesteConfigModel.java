package io.github.ringlings.celestemod.config;

import io.wispforest.owo.config.Option;
import io.wispforest.owo.config.annotation.*;


@SuppressWarnings({"unused", "InnerClassMayBeStatic"})
@Modmenu(modId = "celestemod")
@Config(name = "celestemod", wrapperName = "CelesteConfig")
public class CelesteConfigModel {
	@SectionHeader("dashingConfigs")

	@Hook
	@Sync(Option.SyncMode.OVERRIDE_CLIENT)
	public int defaultDashes = 0;

	@Hook
	@Sync(Option.SyncMode.OVERRIDE_CLIENT)
	public float dashVelocity = 2.0f;

	@Hook
	@Sync(Option.SyncMode.OVERRIDE_CLIENT)
	public int dashCoolDown = 5;

	@Hook
	@Sync(Option.SyncMode.OVERRIDE_CLIENT)
	public double dashSlowdown = 0.6;

	@RestartRequired
	public int maxDashLevel = 2;

	@RestartRequired
	public boolean dashTreasureEnchantment = true;
}
