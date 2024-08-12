package com.raxdiam.toastbegone;

import me.shedaniel.autoconfig.serializer.NightConfigSerializer;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ClientModInitializer;

public class ToastBegoneMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AutoConfig.register(ToastConfig.class, NightConfigSerializer::new);
    }
}
