package de.oreos.api.meta;

import net.kyori.adventure.text.Component;

public record AddonMeta(String name, Component description) {

    public String getClassName() {
        return name;
    }

    @Override
    public String name() {
        return name.replace(".class", "");
    }

}
