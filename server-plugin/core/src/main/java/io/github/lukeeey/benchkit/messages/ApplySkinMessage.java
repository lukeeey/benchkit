package io.github.lukeeey.benchkit.messages;

import com.google.gson.JsonObject;
import io.github.lukeeey.benchkit.BenchkitPlugin;
import lombok.RequiredArgsConstructor;
import org.java_websocket.WebSocket;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

@RequiredArgsConstructor
public class ApplySkinMessage implements AbstractMessage {
    private final BenchkitPlugin plugin;

    @Override
    public void parse(WebSocket socket, JsonObject data) {
        UUID entityUuid = UUID.fromString(data.get("entityUuid").getAsString());
        String textureImage = data.get("texture").getAsString().split(",")[1];

        byte[] b64data = Base64.getDecoder().decode(textureImage);

        try {
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(b64data));
            plugin.applySkin(entityUuid, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}