package com.raxdiam.toastbegone;

import com.raxdiam.dawn.shadowed.com.electronwill.nightconfig.core.serde.annotations.SerdeComment;
import com.raxdiam.dawn.AutoConfig;
import com.raxdiam.dawn.ConfigData;
import com.raxdiam.dawn.annotation.Config;
import com.raxdiam.dawn.annotation.ConfigEntry;

import java.util.List;

@Config(name = Constants.MOD_ID)
public class ToastConfig implements ConfigData {
    @SerdeComment("Block tutorial toasts")
    boolean blockTutorial = true;

    @SerdeComment("Block recipe toasts")
    boolean blockRecipe = true;

    @SerdeComment("Block advancement toasts")
    boolean blockAdvancement = false;

    @SerdeComment("Block all system toasts")
    @SerdeComment("This will block all system toasts regardless of the individual options below")
    @ConfigEntry.Gui.Tooltip
    boolean blockAllSystemToasts = false;

    @SerdeComment("System toast options")
    @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
    SystemToastOptions systemToasts = new SystemToastOptions();

    @SerdeComment("List of toast classes added by mods to block")
    @ConfigEntry.Gui.Tooltip
    List<String> blockedClasses = List.of();

    public boolean isBlockTutorial() {
        return blockTutorial;
    }

    public boolean isBlockRecipe() {
        return blockRecipe;
    }

    public boolean isBlockAdvancement() {
        return blockAdvancement;
    }

    public boolean isBlockAllSystemToasts() {
        return blockAllSystemToasts;
    }

    public SystemToastOptions getSystemToasts() {
        return systemToasts;
    }

    public List<String> getBlockedClasses() {
        return blockedClasses;
    }

    public static class SystemToastOptions {
        @SerdeComment("Block tutorial hint toasts")
        boolean blockTutorialHint = false;

        @SerdeComment("Block narrator toggle toasts")
        boolean blockNarratorToggle = false;

        @SerdeComment("Block periodic notification toasts (a.k.a. the \"Compliance Notification\")")
        boolean blockPeriodicNotification = false;

        @SerdeComment("Block pack load failure toasts")
        boolean blockPackLoadFailure = false;

        @SerdeComment("Block pack copy failure toasts")
        boolean blockPackCopyFailure = false;

        @SerdeComment("Block world access failure toasts")
        boolean blockWorldAccessFailure = false;

        @SerdeComment("Block world backup toasts")
        boolean blockWorldBackup = false;

        @SerdeComment("Block unsecure server warning toasts")
        boolean blockUnsecureServerWarning = false;

        public boolean isBlockTutorialHint() {
            return blockTutorialHint;
        }

        public boolean isBlockNarratorToggle() {
            return blockNarratorToggle;
        }

        public boolean isBlockPeriodicNotification() {
            return blockPeriodicNotification;
        }

        public boolean isBlockPackLoadFailure() {
            return blockPackLoadFailure;
        }

        public boolean isBlockPackCopyFailure() {
            return blockPackCopyFailure;
        }

        public boolean isBlockWorldAccessFailure() {
            return blockWorldAccessFailure;
        }

        public boolean isBlockWorldBackup() {
            return blockWorldBackup;
        }

        public boolean isBlockUnsecureServerWarning() {
            return blockUnsecureServerWarning;
        }
    }

    public static ToastConfig getInstance() {
        return AutoConfig.getConfigHolder(ToastConfig.class).getConfig();
    }
}
