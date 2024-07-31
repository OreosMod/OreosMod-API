package de.oreos.api.event.addon;

import de.oreos.api.meta.AddonMeta;

public final class AddonInitializationEvent implements AddonEvent {

    private final AddonMeta addonMeta;

    public AddonInitializationEvent(AddonMeta addonMeta) {
        this.addonMeta = addonMeta;
    }

    public boolean isCurrent(Object current){
        return isCurrent(current.getClass());
    }

    public boolean isCurrent(Class<?> current){
        return current.getSimpleName().equals(addonMeta.getClassName());
    }

    @Override
    public AddonMeta getAddonMeta() {
        return addonMeta;
    }

}
