package de.oreos.api.options;

import net.kyori.adventure.text.Component;

public final class Option {

    private final Component name;
    private final OptionType type;

    private Object value;

    private Option(Component name, OptionType type) {
        this.name = name;
        this.type = type;
    }

    public static Option of(OptionType type, Component name){
        return new Option(name, type);
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public OptionType getType() {
        return type;
    }

    public Component getName() {
        return name;
    }

}
