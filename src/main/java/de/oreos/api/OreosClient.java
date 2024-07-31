package de.oreos.api;

import de.oreos.api.event.EventManager;
import de.oreos.api.event.client.ClientPopupEvent;
import de.oreos.api.meta.MinecraftMeta;
import de.oreos.api.resource.Popup;

public final class OreosClient {

    private static OreosClient instance;

    private EventManager eventManager;

    private final MinecraftMeta minecraftMeta;

    public OreosClient(MinecraftMeta minecraftMeta){
        this.minecraftMeta = minecraftMeta;
        this.eventManager = new EventManager();

        instance = this;
    }

    public void popup(Popup popup){
        eventManager.call(new ClientPopupEvent(popup));
    }

    public MinecraftMeta getMinecraftMeta() {
        return minecraftMeta;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public static OreosClient getInstance() {
        return instance;
    }

}
