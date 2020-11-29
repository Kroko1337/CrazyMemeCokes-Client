package de.crazymemecoke.features.modules.impl.combat;

import de.crazymemecoke.manager.eventmanager.Event;
import de.crazymemecoke.manager.eventmanager.impl.EventUpdate;
import de.crazymemecoke.features.modules.Category;
import de.crazymemecoke.features.modules.Module;
import de.crazymemecoke.features.modules.ModuleInfo;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

@ModuleInfo(name = "FastBow", category = Category.COMBAT, description = "You shoot your arrows like ratatatatam")
public class FastBow extends Module {

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
        if (event instanceof EventUpdate) {
            if (mc.thePlayer.inventory.getCurrentItem() != null) {
                if (mc.thePlayer.inventory.getCurrentItem().getItem() instanceof ItemBow && mc.gameSettings.keyBindUseItem.pressed) {
                    mc.playerController.sendUseItem(mc.thePlayer, mc.theWorld, mc.thePlayer.inventory.getCurrentItem());
                    Item item = mc.thePlayer.inventory.getCurrentItem().getItem();
                    ItemStack itemStack = mc.thePlayer.inventory.getCurrentItem();
                    item.onItemRightClick(itemStack, mc.theWorld, mc.thePlayer);
                    for (int i = 0; i < 20; ++i) {
                        mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(false));
                    }
                    mc.getNetHandler().addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, new BlockPos(0, 0, 0), EnumFacing.DOWN));
                    item = mc.thePlayer.inventory.getCurrentItem().getItem();
                    itemStack = mc.thePlayer.inventory.getCurrentItem();
                    item.onPlayerStoppedUsing(itemStack, mc.theWorld, mc.thePlayer, 10);
                }
            }
        }
    }
}