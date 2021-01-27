package io.github.lukeeey.benchkit.nukkit.event;

import cn.nukkit.Player;
import cn.nukkit.entity.data.Skin;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.Event;
import cn.nukkit.event.HandlerList;
import lombok.Data;
import lombok.Getter;

@Data
public class ModelApplyEvent extends Event implements Cancellable {
    @Getter
    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Skin skin;
}