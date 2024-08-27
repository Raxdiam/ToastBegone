package com.raxdiam.toastbegone.mixin;

import com.raxdiam.toastbegone.ToastConfig;
import net.minecraft.client.gui.components.toasts.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ToastComponent.class)
public class ToastComponentMixin {
    @Inject(at = @At("HEAD"), method = "addToast", cancellable = true)
    private void addToast(Toast toast, CallbackInfo ci) {
        var config = ToastConfig.getInstance();
        var block = false;

        if (toast instanceof TutorialToast) {
            block = config.isBlockTutorial();
        } else if (toast instanceof RecipeToast) {
            block = config.isBlockRecipe();
        } else if (toast instanceof AdvancementToast) {
            block = config.isBlockAdvancement();
        } else if (toast instanceof SystemToast systemToast) {
            if (config.isBlockAllSystemToasts()) {
                block = true;
            } else {
                var systemToasts = config.getSystemToasts();
                var systemToastId = systemToast.getToken();

                switch (systemToastId) {
                    case TUTORIAL_HINT -> block = systemToasts.isBlockTutorialHint();
                    case NARRATOR_TOGGLE -> block = systemToasts.isBlockNarratorToggle();
                    case PERIODIC_NOTIFICATION -> block = systemToasts.isBlockPeriodicNotification();
                    case PACK_LOAD_FAILURE -> block = systemToasts.isBlockPackLoadFailure();
                    case PACK_COPY_FAILURE -> block = systemToasts.isBlockPackCopyFailure();
                    case WORLD_ACCESS_FAILURE -> block = systemToasts.isBlockWorldAccessFailure();
                    case WORLD_BACKUP -> block = systemToasts.isBlockWorldBackup();
                    case UNSECURE_SERVER_WARNING -> block = systemToasts.isBlockUnsecureServerWarning();
                }
            }
        } else {
            var className = toast.getClass().getName();
            block = config.getBlockedClasses().contains(className);
        }

        if (block) {
            ci.cancel();
        }
    }
}
