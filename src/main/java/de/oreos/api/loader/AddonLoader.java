package de.oreos.api.loader;

import de.oreos.api.Addon;
import de.oreos.api.OreosClient;
import de.oreos.api.util.Reflections;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public final class AddonLoader {

    private static final File addonFolder = new File(OreosClient.getInstance().getMinecraftMeta().getOreosModFolder(), "addons");

    public static void loadAddons() {
        var addonFiles = addonFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jar"));

        Arrays.stream(addonFiles).forEach(addon -> {
            try {
                loadAddon(addon);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void loadAddon(File addonFile) throws IOException, ClassNotFoundException {
        var classes = Reflections.getClassesFromJarFile(addonFile);

        classes.forEach(clazz -> {
           if(clazz.isAnnotationPresent(Addon.class)){
               try {
                   OreosClient.getInstance().getEventManager().register(clazz.getConstructor().newInstance());
               }catch (Exception e){
                   e.printStackTrace();
               }
           }
        });
    }

}
