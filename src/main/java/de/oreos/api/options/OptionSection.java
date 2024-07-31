package de.oreos.api.options;

import de.oreos.api.OreosClient;
import de.oreos.api.event.option.OptionSectionRegisterEvent;
import net.kyori.adventure.text.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class OptionSection {

    private final Component name;

    private final List<Option> options = new ArrayList<>();

    private OptionSection(Component name) {
        this.name = name;
    }

    public void registerOption(Option option){
        options.add(option);
    }

    public static OptionSection register(Component name, Option... options){
        var instance = new OptionSection(name);
        Arrays.stream(options).forEach(instance::registerOption);

        OreosClient.getInstance().getEventManager().call(new OptionSectionRegisterEvent(instance));

        return instance;
    }

    public Component getName() {
        return name;
    }

    public List<Option> getOptions() {
        return options;
    }

}
