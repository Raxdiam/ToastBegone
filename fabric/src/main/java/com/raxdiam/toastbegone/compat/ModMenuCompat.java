package com.raxdiam.toastbegone.compat;

import com.raxdiam.toastbegone.ToastConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import com.raxdiam.dawn.AutoConfig;

public class ModMenuCompat implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(ToastConfig.class, parent).get();
    }
}
