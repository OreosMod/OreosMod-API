package de.oreos.api.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class EventManager {

    private final List<EventIdentifier> listener = new ArrayList<>();

    public void register(Object object){
        var methods = object.getClass().getMethods();

        for (var method : methods) {
            if(method.isAnnotationPresent(Subscribe.class)){
                var event = (Class<? extends Event>) method.getParameters()[0].getType();

                listener.add(new EventIdentifier(event, method, object));
            }
        }
    }

    public void call(Event event){
        listener.forEach(eventIdentifier -> {
            if(eventIdentifier.eventType.equals(event.getClass())){
                try {
                    eventIdentifier.method.invoke(eventIdentifier.instance, event);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    private record EventIdentifier(Class<? extends Event> eventType, Method method, Object instance) {
    }

}
