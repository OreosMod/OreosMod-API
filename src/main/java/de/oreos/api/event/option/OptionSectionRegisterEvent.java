package de.oreos.api.event.option;

import de.oreos.api.options.OptionSection;

public record OptionSectionRegisterEvent(OptionSection section) implements OptionEvent {
}
