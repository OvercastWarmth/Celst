package io.github.ringlings.celestemod.config;

import org.quiltmc.config.api.values.TrackedValue;
import org.quiltmc.loader.api.config.QuiltConfig;

import java.util.List;

public class CelesteConfigManager {
	public static final CelesteConfig CONFIG = QuiltConfig.create("celestemod", "config", CelesteConfig.class);

	public static final TrackedValue<Integer> DEFAULT_DASHES = (TrackedValue<Integer>) CONFIG.getValue(List.of("dash", "default_dashes"));
	public static final TrackedValue<Integer> MAX_DASH_LEVEL = (TrackedValue<Integer>) CONFIG.getValue(List.of("dash", "max_dash_level"));
	public static final TrackedValue<Float> DASH_VELOCITY = (TrackedValue<Float>) CONFIG.getValue(List.of("dash", "dash_velocity"));
	public static final TrackedValue<Integer> DASH_COOL_DOWN = (TrackedValue<Integer>) CONFIG.getValue(List.of("dash", "dash_cool_down"));
}
