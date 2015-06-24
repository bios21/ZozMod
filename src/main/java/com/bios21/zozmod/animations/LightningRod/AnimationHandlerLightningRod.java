package com.bios21.zozmod.animations.LightningRod;

import com.bios21.zozmod.lib.MCACommonLibray.IMCAnimatedEntity;
import com.bios21.zozmod.lib.MCACommonLibray.animation.AnimationHandler;
import com.bios21.zozmod.lib.MCACommonLibray.animation.Channel;

import java.util.HashMap;


public class AnimationHandlerLightningRod extends AnimationHandler {
    public static final String MOVING_COIL_ROTATION_ANIMATION = "MovingCoilRotation";
    /**
     * Map with all the animations.
     */
    public static HashMap<String, Channel> animChannels = new HashMap<String, Channel>();

    static {
        animChannels.put(MOVING_COIL_ROTATION_ANIMATION, new ChannelMovingCoilRotation(MOVING_COIL_ROTATION_ANIMATION, 7.0F, 24, Channel.LOOP));
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