package com.raxdiam.toastbegone;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.ConfigValue;

public class ToastConfig implements IToastConfig {
    public final ConfigValue<Boolean> allowTutorial;
    public final ConfigValue<Boolean> allowRecipe;
    public final ConfigValue<Boolean> allowAdvancement;
    public final ConfigValue<Boolean> allowSystem;

    public ToastConfig(ModConfigSpec.Builder builder) {

        allowTutorial = builder
                .comment("Allow tutorial toasts to be displayed")
                .translation("config.toastbegone.allowTutorial")
                .define("allowTutorial", false);
        allowRecipe = builder
                .comment("Allow recipe toasts to be displayed")
                .translation("config.toastbegone.allowRecipe")
                .define("allowRecipe", false);
        allowAdvancement = builder
                .comment("Allow advancement toasts to be displayed")
                .translation("config.toastbegone.allowAdvancement")
                .define("allowAdvancement", true);
        allowSystem = builder
                .comment("Allow system toasts to be displayed")
                .translation("config.toastbegone.allowSystem")
                .define("allowSystem", true);
    }

    @Override
    public boolean getAllowTutorial() {
        return allowTutorial.get();
    }

    @Override
    public boolean getAllowRecipe() {
        return allowRecipe.get();
    }

    @Override
    public boolean getAllowAdvancement() {
        return allowAdvancement.get();
    }

    @Override
    public boolean getAllowSystem() {
        return allowSystem.get();
    }

    public static final ModConfigSpec SPEC;
    public static final ToastConfig INSTANCE;

    static {
        var specPair = new ModConfigSpec.Builder().configure(ToastConfig::new);
        SPEC = specPair.getRight();
        INSTANCE = specPair.getLeft();
    }
}
