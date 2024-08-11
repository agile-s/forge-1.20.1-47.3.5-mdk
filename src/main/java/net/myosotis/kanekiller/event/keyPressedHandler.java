package net.myosotis.kanekiller.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.myosotis.kanekiller.globalVars;
import net.myosotis.kanekiller.util.keyboardHandler;

public class keyPressedHandler {
    @Mod.EventBusSubscriber(modid = "kanekiller", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ClientEvents {
        @SubscribeEvent
        public static void keyRegistrator(RegisterKeyMappingsEvent event) {
            event.register(keyboardHandler.mykey);
        }

        @SubscribeEvent
        public static void onClientTick(TickEvent.ClientTickEvent event) {
            if (keyboardHandler.mykey.consumeClick()) {
                globalVars.resetCurrentValue();
            }
        }
    }
}
