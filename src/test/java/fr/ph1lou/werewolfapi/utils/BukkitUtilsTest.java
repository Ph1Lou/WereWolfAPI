package fr.ph1lou.werewolfapi.utils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BukkitUtilsTest {

    private static class ParentListener implements Listener {
        @EventHandler
        private void inheritedPrivateHandler(PlayerJoinEvent event) {
        }
    }

    private static class ChildListener extends ParentListener {
        @EventHandler
        private void privateHandler(PlayerJoinEvent event) {
        }

        @EventHandler
        public void publicHandler(PlayerJoinEvent event) {
        }
    }

    @Test
    public void discoversPublicAndPrivateHandlersIncludingParentClass() {
        assertTrue(containsHandler("privateHandler"));
        assertTrue(containsHandler("inheritedPrivateHandler"));
        assertTrue(containsHandler("publicHandler"));

        long publicMethods = BukkitUtils.getListenerMethods(ChildListener.class).stream()
                .filter(m -> m.getName().equals("publicHandler"))
                .count();
        assertEquals(1, publicMethods);
    }

    private boolean containsHandler(String name) {
        return BukkitUtils.getListenerMethods(ChildListener.class).stream()
                .map(Method::getName)
                .anyMatch(name::equals);
    }
}
