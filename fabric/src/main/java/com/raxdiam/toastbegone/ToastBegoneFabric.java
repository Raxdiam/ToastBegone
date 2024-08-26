package com.raxdiam.toastbegone;

import net.fabricmc.api.ClientModInitializer;

public class ToastBegoneFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ToastBegone.init();
    }
}
