package user11681.headsdowndisplay.integration;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.client.gui.screen.Screen;
import user11681.headsdowndisplay.config.HDDConfig;

public class HDDModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return (final Screen screen) -> AutoConfig.getConfigScreen(HDDConfig.class, screen).get();
    }
}
