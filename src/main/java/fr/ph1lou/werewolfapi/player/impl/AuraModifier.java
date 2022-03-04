package fr.ph1lou.werewolfapi.player.impl;

import fr.ph1lou.werewolfapi.enums.Aura;
import fr.ph1lou.werewolfapi.player.interfaces.IAuraModifier;
import org.jetbrains.annotations.NotNull;

/**
 * Note: this class has a natural ordering that is inconsistent with equals.
 */
public class AuraModifier implements IAuraModifier {

    private final String name;
    private final Aura aura;
    private final int priority;
    private final boolean isTemporary;

    public AuraModifier(String name, Aura aura, int priority, boolean isTemporary) {
        this.name = name;
        this.aura = aura;
        this.priority = priority;
        this.isTemporary = isTemporary;
    }

    @Override
    public Aura getAura() {
        return aura;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isTemporary() {
        return isTemporary;
    }

    @Override
    public boolean equals(@NotNull Object o) {
        if (!(o instanceof IAuraModifier)) {
            return false;
        }

        return (((IAuraModifier) o).getName().equals(this.getName())
                && ((IAuraModifier) o).getAura().equals(this.getAura())
                && ((IAuraModifier) o).getPriority() == this.getPriority());
    }

    @Override
    public int compareTo(@NotNull IAuraModifier o) {
        return this.getPriority() - o.getPriority();
    }
}
