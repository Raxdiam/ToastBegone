package com.raxdiam.toastbegone;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = Constants.MOD_ID)
public class ToastConfig implements ConfigData, IToastConfig {
    @Comment("Allow tutorial toasts to be displayed")
    boolean allowTutorial = false;

    @Comment("Allow recipe toasts to be displayed")
    boolean allowRecipe = false;

    @Comment("Allow advancement toasts to be displayed")
    boolean allowAdvancement = true;

    @Comment("Allow system toasts to be displayed")
    boolean allowSystem = true;

    @Override
    public boolean getAllowTutorial() {
        return allowTutorial;
    }

    @Override
    public boolean getAllowRecipe() {
        return allowRecipe;
    }

    @Override
    public boolean getAllowAdvancement() {
        return allowAdvancement;
    }

    @Override
    public boolean getAllowSystem() {
        return allowSystem;
    }
}
