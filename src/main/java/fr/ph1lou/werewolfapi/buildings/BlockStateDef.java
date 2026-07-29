package fr.ph1lou.werewolfapi.buildings;

import java.util.Collections;
import java.util.Map;

public class BlockStateDef {

    private final String material;
    private final Map<String, String> states;

    public BlockStateDef(String material, Map<String, String> states) {
        this.material = material;
        this.states = states;
    }

    public String getMaterial() {
        return material;
    }

    public Map<String, String> getStates() {
        return states == null ? Collections.emptyMap() : states;
    }

    public boolean hasStates() {
        return states != null && !states.isEmpty();
    }
}
