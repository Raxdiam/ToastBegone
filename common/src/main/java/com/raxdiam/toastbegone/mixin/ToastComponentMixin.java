package com.raxdiam.toastbegone.mixin;

import net.minecraft.client.gui.components.toasts.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.raxdiam.toastbegone.platform.Services;

@Mixin(ToastComponent.class)
public class ToastComponentMixin {
    @Inject(at = @At("HEAD"), method = "addToast", cancellable = true)
    private void addToast(Toast toast, CallbackInfo ci) {
        var config = Services.PLATFORM.getConfig();

        switch (toast) {
            case TutorialToast ignored when !config.getAllowTutorial() -> ci.cancel();
            case RecipeToast ignored when !config.getAllowRecipe() -> ci.cancel();
            case AdvancementToast ignored when !config.getAllowAdvancement() -> ci.cancel();
            case SystemToast ignored when !config.getAllowSystem() -> ci.cancel();
            default -> {
            }
        }
    }
}
