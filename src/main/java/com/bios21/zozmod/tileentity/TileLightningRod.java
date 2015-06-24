package com.bios21.zozmod.tileentity;

import com.bios21.zozmod.animations.LightningRod.AnimationHandlerLightningRod;
import com.bios21.zozmod.lib.MCACommonLibray.IMCAnimatedEntity;
import com.bios21.zozmod.lib.MCACommonLibray.animation.AnimationHandler;
import com.bios21.zozmod.utils.ZozLog;
import net.minecraft.server.gui.IUpdatePlayerListBox;

/**
 * Created by l.sagetlethias on 22/06/2015.
 */
public class TileLightningRod extends BaseTileEntityZoz implements IMCAnimatedEntity, IUpdatePlayerListBox {
    protected AnimationHandler animHandler = new AnimationHandlerLightningRod(this);

    public TileLightningRod() {
        ZozLog.info("TILE ENTITIES : ");
        ZozLog.info(this);
    }

    @Override
    public AnimationHandler getAnimationHandler() {
        return animHandler;
    }

    @Override
    public void update() {
        if (!this.animHandler.isAnimationActive(AnimationHandlerLightningRod.MOVING_COIL_ROTATION_ANIMATION)) {
            this.animHandler.activateAnimation(AnimationHandlerLightningRod.MOVING_COIL_ROTATION_ANIMATION, 0);
        }
    }
}