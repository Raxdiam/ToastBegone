package com.raxdiam.toastbegone;

import com.raxdiam.dawn.AutoConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import java.util.function.Supplier;

@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public class ToastBegoneNeoForge {
    public ToastBegoneNeoForge(IEventBus eventBus) {
        ToastBegone.init();

        var container = ModLoadingContext.get().getActiveContainer();
        container.registerExtensionPoint(IConfigScreenFactory.class, (Supplier<IConfigScreenFactory>) () ->
                (IConfigScreenFactory) (modContainer, screen) -> AutoConfig.getConfigScreen(ToastConfig.class, screen).get());
    }
}