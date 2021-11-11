package io.github.ph1lou.werewolfapi.versions;


import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class VersionUtils_1_14 extends VersionUtils_1_13 {


    @Override
    public void sendTabTitle(@NotNull Player player, @NotNull String header, @NotNull String footer) {
        if(!footer.contains("Ph1Lou")){
            footer += "\n§7Plugin made by §bPh1Lou";
        }
        player.setPlayerListHeaderFooter(header, footer);
    }
}

