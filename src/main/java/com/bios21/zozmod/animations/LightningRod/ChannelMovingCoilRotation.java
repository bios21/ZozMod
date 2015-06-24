package com.bios21.zozmod.animations.LightningRod;


import com.bios21.zozmod.lib.MCACommonLibray.animation.Channel;
import com.bios21.zozmod.lib.MCACommonLibray.animation.KeyFrame;
import com.bios21.zozmod.lib.MCACommonLibray.math.Quaternion;
import com.bios21.zozmod.lib.MCACommonLibray.math.Vector3f;

public class ChannelMovingCoilRotation extends Channel {
    public ChannelMovingCoilRotation(String _name, float _fps, int _totalFrames, byte _mode) {
        super(_name, _fps, _totalFrames, _mode);
    }

    @Override
    protected void initializeAllFrames() {
        KeyFrame frame0 = new KeyFrame();
        frame0.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, 0.1305262F, 0.0F, 0.9914449F));
        frame0.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(0, frame0);

        KeyFrame frame1 = new KeyFrame();
        frame1.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, 0.25881904F, 0.0F, 0.9659258F));
        frame1.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(1, frame1);

        KeyFrame frame2 = new KeyFrame();
        frame2.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, 0.38268346F, 0.0F, 0.9238795F));
        frame2.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(2, frame2);

        KeyFrame frame3 = new KeyFrame();
        frame3.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, 0.5F, 0.0F, 0.8660254F));
        frame3.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(3, frame3);

        KeyFrame frame4 = new KeyFrame();
        frame4.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, 0.6087614F, 0.0F, 0.7933533F));
        frame4.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(4, frame4);

        KeyFrame frame5 = new KeyFrame();
        frame5.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, 0.70710677F, 0.0F, 0.70710677F));
        frame5.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(5, frame5);

        KeyFrame frame6 = new KeyFrame();
        frame6.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, 0.7933533F, 0.0F, 0.6087614F));
        frame6.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(6, frame6);

        KeyFrame frame7 = new KeyFrame();
        frame7.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, 0.86602545F, 0.0F, 0.49999997F));
        frame7.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(7, frame7);

        KeyFrame frame8 = new KeyFrame();
        frame8.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, 0.9238795F, 0.0F, 0.38268343F));
        frame8.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(8, frame8);

        KeyFrame frame9 = new KeyFrame();
        frame9.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, 0.9659258F, 0.0F, 0.25881907F));
        frame9.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(9, frame9);

        KeyFrame frame10 = new KeyFrame();
        frame10.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, 0.9914448F, 0.0F, 0.13052624F));
        frame10.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(10, frame10);

        KeyFrame frame11 = new KeyFrame();
        frame11.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, 1.0F, 0.0F, -4.371139E-8F));
        frame11.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(11, frame11);

        KeyFrame frame12 = new KeyFrame();
        frame12.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, -0.9914448F, 0.0F, 0.13052624F));
        frame12.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(12, frame12);

        KeyFrame frame13 = new KeyFrame();
        frame13.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, -0.9659258F, 0.0F, 0.25881907F));
        frame13.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(13, frame13);

        KeyFrame frame14 = new KeyFrame();
        frame14.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, -0.9238795F, 0.0F, 0.38268343F));
        frame14.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(14, frame14);

        KeyFrame frame15 = new KeyFrame();
        frame15.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, -0.86602545F, 0.0F, 0.49999997F));
        frame15.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(15, frame15);

        KeyFrame frame16 = new KeyFrame();
        frame16.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, -0.7933533F, 0.0F, 0.6087614F));
        frame16.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(16, frame16);

        KeyFrame frame17 = new KeyFrame();
        frame17.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, -0.70710677F, 0.0F, 0.70710677F));
        frame17.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(17, frame17);

        KeyFrame frame18 = new KeyFrame();
        frame18.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, -0.6087614F, 0.0F, 0.7933533F));
        frame18.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(18, frame18);

        KeyFrame frame19 = new KeyFrame();
        frame19.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, -0.5F, 0.0F, 0.8660254F));
        frame19.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(19, frame19);

        KeyFrame frame20 = new KeyFrame();
        frame20.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, -0.38268346F, 0.0F, 0.9238795F));
        frame20.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(20, frame20);

        KeyFrame frame21 = new KeyFrame();
        frame21.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, -0.25881904F, 0.0F, 0.9659258F));
        frame21.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(21, frame21);

        KeyFrame frame22 = new KeyFrame();
        frame22.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, -0.1305262F, 0.0F, 0.9914449F));
        frame22.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(22, frame22);

        KeyFrame frame23 = new KeyFrame();
        frame23.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
        frame23.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
        keyFrames.put(23, frame23);

//        KeyFrame frame24 = new KeyFrame();
//        frame24.modelRenderersRotations.put("MovingCoil", new Quaternion(0.0F, 0.1305262F, 0.0F, 0.9914449F));
//        frame24.modelRenderersTranslations.put("MovingCoil", new Vector3f(0.0F, -16.0F, 2.0F));
//        keyFrames.put(24, frame24);

    }
}