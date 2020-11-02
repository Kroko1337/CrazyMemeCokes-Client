package de.crazymemecoke.features.modules.movement;

import de.crazymemecoke.manager.eventmanager.Event;
import de.crazymemecoke.manager.eventmanager.impl.EventUpdate;
import net.minecraft.client.gui.inventory.GuiEditSign;
import org.lwjgl.input.Keyboard;

import de.crazymemecoke.manager.modulemanager.Category;
import de.crazymemecoke.manager.modulemanager.Module;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;

public class InventoryMove extends Module {

	public InventoryMove() {
		super("InventoryMove", Keyboard.KEY_NONE, Category.MOVEMENT, -1);
	}


	@Override
	public void onEvent(Event event) {
		if(event instanceof EventUpdate) {
			if (mc.currentScreen != null && !(mc.currentScreen instanceof GuiChat) && !(mc.currentScreen instanceof GuiEditSign)) {
				KeyBinding[] moveKeys = { mc.gameSettings.keyBindForward, mc.gameSettings.keyBindSprint,
						mc.gameSettings.keyBindBack, mc.gameSettings.keyBindLeft, mc.gameSettings.keyBindRight,
						mc.gameSettings.keyBindJump };
				KeyBinding[] array;
				int length = (array = moveKeys).length;
				for (int i = 0; i < length; i++) {
					KeyBinding bind = array[i];
					KeyBinding.setKeyBindState(bind.getKeyCode(), Keyboard.isKeyDown(bind.getKeyCode()));
				}
			}
		}
	}
}