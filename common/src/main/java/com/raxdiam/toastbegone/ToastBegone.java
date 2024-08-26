package com.raxdiam.toastbegone;

import com.raxdiam.dawn.AutoConfig;
import com.raxdiam.dawn.serializer.NightConfigSerializer;

public class ToastBegone {
    public static void init() {
        AutoConfig.register(ToastConfig.class, NightConfigSerializer::new);
    }
}
