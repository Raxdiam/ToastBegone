package com.raxdiam.toastbegone;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;

@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public class ToastBegoneMod {
    public ToastBegoneMod(IEventBus eventBus) {
        var container = ModLoadingContext.get().getActiveContainer();

        container.registerConfig(ModConfig.Type.CLIENT, ToastConfig.SPEC);
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}