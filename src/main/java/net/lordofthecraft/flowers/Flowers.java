package net.lordofthecraft.flowers;

import org.bukkit.plugin.java.JavaPlugin;

import net.lordofthecraft.flowers.listeners.BoneMealListener;

public final class Flowers extends JavaPlugin {

    @Override
    public void onEnable() {
        eventRegistry();
    }

    private void eventRegistry(){
        getServer().getPluginManager().registerEvents(new BoneMealListener(), this);
    }
}
