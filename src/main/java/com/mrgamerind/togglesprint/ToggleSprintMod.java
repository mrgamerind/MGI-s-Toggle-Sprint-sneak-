package com.mrgamerind.togglesprint;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class ToggleSprintMod implements ClientModInitializer {
    public static KeyBinding toggleSprintKey;
    public static KeyBinding toggleSneakKey;

    public static boolean isSprinting = false;
    public static boolean isSneaking = false;

    @Override
    public void onInitializeClient() {
        toggleSprintKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.togglesprint.toggle_sprint",
            GLFW.GLFW_KEY_R,
            "key.categories.movement"
        ));

        toggleSneakKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.togglesprint.toggle_sneak",
            GLFW.GLFW_KEY_G,
            "key.categories.movement"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleSprintKey.wasPressed()) {
                isSprinting = !isSprinting;
            }

            while (toggleSneakKey.wasPressed()) {
                isSneaking = !isSneaking;
            }

            if (client.player != null) {
                client.player.setSprinting(isSprinting);
                client.player.setSneaking(isSneaking);
            }
        });
    }
}
