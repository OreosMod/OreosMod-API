package de.oreos.api.event.client;

import de.oreos.api.resource.Popup;

public record ClientPopupEvent(Popup popup) implements ClientEvent {
}
