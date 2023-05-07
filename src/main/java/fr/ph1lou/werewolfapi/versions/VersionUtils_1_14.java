package fr.ph1lou.werewolfapi.versions;


import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VersionUtils_1_14 extends VersionUtils_1_13 {


    @Override
    public void sendTabTitle(@NotNull Player player, @NotNull String header, @NotNull String footer) {
        if (!footer.contains(VersionUtils.CREATOR) && !header.contains(VersionUtils.CREATOR)) {
            footer += "\n§7Plugin made by §bPh1Lou";
        }
        player.setPlayerListHeaderFooter(header, footer);
    }

    @Override
    public void setChunkForceLoaded(World world, int x, int z, boolean generation) {
        world.setChunkForceLoaded(x, z, generation);
    }
}

