package fr.ph1lou.werewolfapi.buildings;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import java.util.HashMap;
import java.util.Map;

public class BuildingDefinition {

    private final BuildingType type;
    private final int width;
    private final int height;
    private final int length;
    private final Map<Character, BlockStateDef> palette;
    private final BlockStateDef[][][] blocks;
    private final Map<String, int[]> functional;

    public BuildingDefinition(BuildingType type, int width, int height, int length,
                              Map<Character, BlockStateDef> palette, BlockStateDef[][][] blocks,
                              Map<String, int[]> functional) {
        this.type = type;
        this.width = width;
        this.height = height;
        this.length = length;
        this.palette = palette;
        this.blocks = blocks;
        this.functional = functional;
    }

    public static BuildingDefinition parse(JsonObject json) {
        BuildingType type = BuildingType.valueOf(json.get("type").asString().toUpperCase());
        int width = json.get("width").asInt();
        int height = json.get("height").asInt();
        int length = json.get("length").asInt();

        Map<Character, BlockStateDef> palette = new HashMap<>();
        JsonObject pal = json.get("palette").asObject();
        for (JsonObject.Member m : pal) {
            JsonValue value = m.getValue();
            if (value.isString()) {
                palette.put(m.getName().charAt(0), new BlockStateDef(value.asString(), null));
            } else if (value.isObject()) {
                JsonObject obj = value.asObject();
                String material = obj.get("material").asString();
                Map<String, String> states = new HashMap<>();
                for (JsonObject.Member s : obj) {
                    if (!"material".equals(s.getName())) {
                        states.put(s.getName(), s.getValue().asString());
                    }
                }
                palette.put(m.getName().charAt(0), new BlockStateDef(material, states));
            }
        }

        BlockStateDef[][][] blocks = new BlockStateDef[height][width][length];
        JsonArray layers = json.get("layers").asArray();
        for (JsonValue layerVal : layers) {
            JsonObject layer = layerVal.asObject();
            int y = layer.get("y").asInt();
            JsonArray rows = layer.get("rows").asArray();
            for (int z = 0; z < rows.size(); z++) {
                String row = rows.get(z).asString();
                for (int x = 0; x < row.length() && x < width; x++) {
                    char c = row.charAt(x);
                    blocks[y][x][z] = palette.get(c);
                }
            }
        }

        Map<String, int[]> functional = new HashMap<>();
        if (json.get("functional") != null) {
            JsonObject func = json.get("functional").asObject();
            for (JsonObject.Member m : func) {
                JsonObject coord = m.getValue().asObject();
                functional.put(m.getName(),
                        new int[]{coord.get("x").asInt(), coord.get("y").asInt(), coord.get("z").asInt()});
            }
        }

        return new BuildingDefinition(type, width, height, length, palette, blocks, functional);
    }

    public BuildingType getType() {
        return type;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public BlockStateDef[][][] getBlocks() {
        return blocks;
    }

    public int[] getFunctional(String name) {
        return functional.get(name);
    }

    public boolean hasFunctional(String name) {
        return functional.containsKey(name);
    }
}
