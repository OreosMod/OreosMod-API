package de.oreos.api.resource;

import net.kyori.adventure.text.Component;

public record Popup(Component header, Component description, Identifier icon) {
}
