package com.raxdiam.toastbegone;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

public class ToastBegoneMod implements ClientModInitializer {
    public static ConfigHolder<ToastConfig> CONFIG_HOLDER;

    @Override
    public void onInitializeClient() {
        CONFIG_HOLDER = AutoConfig.register(ToastConfig.class, JanksonConfigSerializer::new);
    }
}
