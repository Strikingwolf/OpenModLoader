package xyz.openmodloader.modloader;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;
import xyz.openmodloader.OpenModLoader;
import xyz.openmodloader.event.strippable.Side;
import xyz.openmodloader.event.strippable.Strippable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class OMLModContainer extends ModContainer {
    @Override
    public Version getVersion() {
        return OpenModLoader.INSTANCE.getVersion();
    }

    @Override
    public String getModID() {
        return "oml";
    }

    @Override
    public String getName() {
        return "OpenModLoader";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getAuthor() {
        return "OML";
    }

    @Override
    @Strippable(side = Side.CLIENT)
    public ResourceLocation getLogo() {
        if (this.logo == null) {
            try {
                InputStream stream = ModContainer.class.getResourceAsStream("/logo.png");
                BufferedImage image = ImageIO.read(stream);
                DynamicTexture texture = new DynamicTexture(image);
                this.logo = Minecraft.getMinecraft().getTextureManager().getDynamicTextureLocation("mods/" + getModID(), texture);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return logo;
    }
}