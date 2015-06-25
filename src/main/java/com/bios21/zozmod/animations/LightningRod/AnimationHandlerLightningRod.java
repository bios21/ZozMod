package com.bios21.zozmod.animations.LightningRod;

import com.bios21.zozmod.lib.MCACommonLibray.IMCAnimatedEntity;
import com.bios21.zozmod.lib.MCACommonLibray.animation.AnimationHandler;
import com.bios21.zozmod.lib.MCACommonLibray.animation.Channel;
import com.bios21.zozmod.reference.Reference;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;


public class AnimationHandlerLightningRod extends AnimationHandler {
    private static final ResourceLocation lightningRodMovingCoilAnimationJSON = new ResourceLocation("zozmod:animations/"+ Reference.Animations.lightningRodMovingCoil+".json");
    /**
     * Map with all the animations.
     */
    public static HashMap<String, Channel> animChannels = new HashMap<String, Channel>();

    static {
        animChannels.put(Reference.Animations.lightningRodMovingCoil, new ChannelMovingCoilRotation(Reference.Animations.lightningRodMovingCoil, 7.0F, 24, Channel.LOOP));
    }

    public AnimationHandlerLightningRod(IMCAnimatedEntity entity) {
        super(entity);
    }

    @Override
    public void activateAnimation(String name, float startingFrame) {
        super.activateAnimation(animChannels, name, startingFrame);
    }

    @Override
    public void stopAnimation(String name) {
        super.stopAnimation(animChannels, name);
    }

    @Override
    public void fireAnimationEventClientSide(Channel anim, Float frame) {
    }

    @Override
    public void fireAnimationEventServerSide(Channel anim, Float frame) {
    }
}