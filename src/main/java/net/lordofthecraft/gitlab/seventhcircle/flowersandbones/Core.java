package net.lordofthecraft.gitlab.seventhcircle.flowersandbones;

import net.lordofthecraft.gitlab.seventhcircle.flowersandbones.Events.onBoneMeal;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        eventRegistry();
    }

    private void eventRegistry(){
        getServer().getPluginManager().registerEvents(new onBoneMeal(), this);
    }
}
