package com.raxdiam.toastbegone.platform;

import com.raxdiam.toastbegone.IToastConfig;
import com.raxdiam.toastbegone.ToastBegoneMod;
import com.raxdiam.toastbegone.platform.services.IPlatformHelper;

import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatformHelper implements IPlatformHelper {
    @Override
    public IToastConfig getConfig() {
        return ToastBegoneMod.CONFIG_HOLDER.getConfig();
    }

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
