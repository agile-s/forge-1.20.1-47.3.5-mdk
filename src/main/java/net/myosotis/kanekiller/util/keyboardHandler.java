package net.myosotis.kanekiller.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.myosotis.kanekiller.world.Kanekiller;
import org.lwjgl.glfw.GLFW;

public class keyboardHandler {
    public static final KeyMapping mykey = new KeyMapping(
            "key." + Kanekiller.MODID + ".reset",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_K,
            "key.category." + Kanekiller.MODID + ".Kanekiller");
}
