package net.lordofthecraft.gitlab.seventhcircle.flowers;

import net.lordofthecraft.gitlab.seventhcircle.flowers.listeners.BoneMealListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlowersAndBones extends JavaPlugin {

    @Override
    public void onEnable() {
        eventRegistry();
    }

    private void eventRegistry(){
        getServer().getPluginManager().registerEvents(new BoneMealListener(), this);
    }
}
