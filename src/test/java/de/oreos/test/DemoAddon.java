package de.oreos.test;

import de.oreos.api.Addon;
import de.oreos.api.event.Subscribe;
import de.oreos.api.event.addon.AddonInitializationEvent;
import de.oreos.api.options.Option;
import de.oreos.api.options.OptionSection;
import de.oreos.api.options.OptionType;
import net.kyori.adventure.text.Component;

@Addon
public final class DemoAddon {

    private final OptionSection demoSection = OptionSection.register(
            Component.text("DemoSection"),

            Option.of(OptionType.BOOLEAN, Component.text("DemoToggle")),
            Option.of(OptionType.DOUBLE, Component.text("DemoSlider")),
            Option.of(OptionType.STRING, Component.text("DemoInput"))
    );

    @Subscribe
    public void onAddonInitializationEvent(AddonInitializationEvent event){

    }

}
