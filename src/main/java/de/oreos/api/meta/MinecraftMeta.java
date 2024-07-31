package de.oreos.api.meta;

import java.io.File;

public record MinecraftMeta(File minecraftFolder, File configFolder) {

    public File getOreosModFolder(){
        return new File(minecraftFolder, "oreosmod");
    }

}
