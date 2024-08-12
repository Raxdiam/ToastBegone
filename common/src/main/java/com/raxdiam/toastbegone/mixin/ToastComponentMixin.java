package com.raxdiam.toastbegone.mixin;

import com.raxdiam.toastbegone.ToastConfig;
import net.minecraft.client.gui.components.toasts.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.client.gui.components.toasts.SystemToast.SystemToastId.*;

@Mixin(ToastComponent.class)
public class ToastComponentMixin {
    @Inject(at = @At("HEAD"), method = "addToast", cancellable = true)
    private void addToast(Toast toast, CallbackInfo ci) {
        var config = ToastConfig.getInstance();

        if (switch (toast) {
            case TutorialToast ignored -> config.isBlockTutorial();
            case RecipeToast ignored -> config.isBlockRecipe();
            case AdvancementToast ignored -> config.isBlockAdvancement();
            case SystemToast systemToast -> {
                if (config.isBlockAllSystemToasts()) {
                    yield true;
                } else {
                    var systemToasts = config.getSystemToasts();
                    var systemToastId = systemToast.getToken();
                    if (systemToastId == NARRATOR_TOGGLE) {
                        yield systemToasts.isBlockNarratorToggle();
                    } else if (systemToastId == PERIODIC_NOTIFICATION) {
                        yield systemToasts.isBlockPeriodicNotification();
                    } else if (systemToastId == FILE_DROP_FAILURE) {
                        yield systemToasts.isBlockFileDropFailure();
                    } else if (systemToastId == LOW_DISK_SPACE) {
                        yield systemToasts.isBlockLowDiskSpace();
                    } else if (systemToastId == PACK_LOAD_FAILURE) {
                        yield systemToasts.isBlockPackLoadFailure();
                    } else if (systemToastId == PACK_COPY_FAILURE) {
                        yield systemToasts.isBlockPackCopyFailure();
                    } else if (systemToastId == CHUNK_LOAD_FAILURE) {
                        yield systemToasts.isBlockChunkLoadFailure();
                    } else if (systemToastId == CHUNK_SAVE_FAILURE) {
                        yield systemToasts.isBlockChunkSaveFailure();
                    } else if (systemToastId == WORLD_ACCESS_FAILURE) {
                        yield systemToasts.isBlockWorldAccessFailure();
                    } else if (systemToastId == WORLD_BACKUP) {
                        yield systemToasts.isBlockWorldBackup();
                    } else if (systemToastId == UNSECURE_SERVER_WARNING) {
                        yield systemToasts.isBlockUnsecureServerWarning();
                    } else {
                        yield false;
                    }
                }
            }
            default -> {
                var className = toast.getClass().getName();
                yield config.getBlockedClasses().contains(className);
            }
        }) {
            ci.cancel();
        }
    }
}
