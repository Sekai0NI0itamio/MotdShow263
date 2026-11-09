package itamio.motdshow;

import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("motdshow")
public class MotdShowMod {
    public MotdShowMod() {
        MinecraftForge.EVENT_BUS.addListener(this::onRegisterCommands);
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("motdshow").requires(s -> s.hasPermission(0))
            .executes(ctx -> {
                String motd = ctx.getSource().getServer().getMotd(); ctx.getSource().sendSuccess(() -> Component.literal("Server MOTD: " + motd), false);
                return 1;
            }));
    }
}
