package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.WereWolfAPI;
import io.github.ph1lou.werewolfapi.enumlg.StatePlayer;
import io.github.ph1lou.werewolfapi.events.SelectionEndEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import java.util.UUID;

public abstract class RolesWithLimitedSelectionDuration extends RolesVillage implements Power {

    public RolesWithLimitedSelectionDuration(GetWereWolfAPI main, WereWolfAPI game, UUID uuid, String key) {
        super(main,game,uuid,key);
    }
    private boolean power=true;

    @EventHandler
    public void onSelectionEnd(SelectionEndEvent event) {

        if (!hasPower()) return;

        if(!game.getPlayersWW().get(getPlayerUUID()).isState(StatePlayer.ALIVE)){
            return;
        }

        setPower(false);

        Player player = Bukkit.getPlayer(getPlayerUUID());

        if(player==null) return;

        player.sendMessage(game.translate("werewolf.check.end_selection"));
    }

    @Override
    public void setPower(Boolean power) {
        this.power=power;
    }

    @Override
    public Boolean hasPower() {
        return(this.power);
    }
}
