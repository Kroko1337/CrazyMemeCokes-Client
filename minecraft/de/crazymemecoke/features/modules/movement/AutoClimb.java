package de.crazymemecoke.features.modules.movement;

import de.crazymemecoke.manager.eventmanager.Event;
import de.crazymemecoke.manager.eventmanager.impl.EventUpdate;
import de.crazymemecoke.manager.modulemanager.Category;
import de.crazymemecoke.manager.modulemanager.Module;
import de.crazymemecoke.manager.modulemanager.ModuleInfo;
import org.lwjgl.input.Keyboard;

@ModuleInfo(name = "AutoClimb", category = Category.MOVEMENT, description = "Automatically climbs ladders")
public class AutoClimb extends Module {
    @Override
    public void onToggle() {

    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onEvent(Event event) {
     if(event instanceof EventUpdate) {
         if (mc.thePlayer.isOnLadder()) {
             mc.thePlayer.motionY += 0.1D;
         }
     }
    }
}
