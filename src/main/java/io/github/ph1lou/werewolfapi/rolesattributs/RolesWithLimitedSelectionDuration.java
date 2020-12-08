package io.github.ph1lou.werewolfapi.rolesattributs;

import io.github.ph1lou.werewolfapi.GetWereWolfAPI;
import io.github.ph1lou.werewolfapi.PlayerWW;
import io.github.ph1lou.werewolfapi.enumlg.StatePlayer;
import io.github.ph1lou.werewolfapi.events.SelectionEndEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public abstract class RolesWithLimitedSelectionDuration extends RolesVillage implements Power {

    public RolesWithLimitedSelectionDuration(GetWereWolfAPI main, PlayerWW playerWW, String key) {
        super(main,playerWW,key);
    }
    private boolean power=true;

    @EventHandler
    public void onSelectionEnd(SelectionEndEvent event) {

        if (!hasPower()) return;

        if(!getPlayerWW().isState(StatePlayer.ALIVE)){
            return;
        }

        setPower(false);

        Player player = Bukkit.getPlayer(getPlayerUUID());

        if(player==null) return;

        player.sendMessage(game.translate("werewolf.check.end_selection"));
    }

    @Override
    public final void setPower(boolean power) {
        this.power=power;
    }

    @Override
    public final boolean hasPower() {
        return(this.power);
    }
}
