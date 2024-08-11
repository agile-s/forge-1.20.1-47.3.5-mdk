package net.myosotis.kanekiller.world;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.myosotis.kanekiller.globalVars;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Kanekiller.MODID)
public class Kanekiller {

    public static final String MODID = "kanekiller";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Kanekiller() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(PlayerKillHandler.class);
    }

    @Mod.EventBusSubscriber(modid = "kanekiller", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class PlayerKillHandler {
        @SubscribeEvent
        public static void onPlayerKill(LivingDeathEvent event) {

            LOGGER.info("First");
            Entity killedEntity = event.getEntity();
            Minecraft mc = Minecraft.getInstance();
            LocalPlayer clientPlayer = mc.player;

            if (clientPlayer != null) {

                LOGGER.info("Second");

                if (event.getSource().getEntity() instanceof Player killer && killer.equals(clientPlayer)) {

                        LOGGER.info("Third");
                        Component message = Component.literal(globalVars.getCurrentValue() + " - 7");
                        globalVars.setCurrentValue(globalVars.getCurrentValue() - 7);
                        mc.player.connection.sendChat(message.getString());
                        LOGGER.info("Fourth");

                    }
                }
            }
        }


}
