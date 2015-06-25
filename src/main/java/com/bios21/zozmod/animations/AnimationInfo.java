package com.bios21.zozmod.animations;

import com.bios21.zozmod.lib.MCACommonLibray.animation.KeyFrame;
import com.bios21.zozmod.lib.MCACommonLibray.math.Quaternion;
import com.bios21.zozmod.lib.MCACommonLibray.math.Vector3f;
import com.bios21.zozmod.utils.ZozUtils;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Asus on 25/06/2015.
 */
public class AnimationInfo implements Serializable {
    public enum EnumAnimationMode {
        RANGE("range"), ARRAY("array");
        public final String name;

        EnumAnimationMode(final String name) {
            this.name = name;
        }
    }

    private String name = "";
    private EnumAnimationMode mode = EnumAnimationMode.ARRAY;
    private boolean mirror = false;
    private int size = 0;
    private int fps = 0;
    private boolean loop = false;
    private float[][] rotations;
    private float [][] translations;
    private Map<Integer, KeyFrame> keyFrames;

    public AnimationInfo() {
        switch (this.mode) {
            case ARRAY:
                break;
            case RANGE:
                break;
            default: break;
        }
    }

    private void generateKeyFramesFromArray() {
        if (this.rotations.length == 1) { // no rotation
            this.rotations = ZozUtils.getFilledArray(this.size, this.rotations[0]);
        }
        if (this.translations.length == 1) { // no translation
            this.translations = ZozUtils.getFilledArray(this.size, this.translations[0]);
        }

        if (this.rotations.length != this.size || this.translations.length != this.size) return;

        KeyFrame frame = new KeyFrame();
        for (int i = 0; i < this.size; i++) {
            frame.modelRenderersRotations.put(this.name, new Quaternion(this.rotations[i][0], this.rotations[i][1], this.rotations[i][2], this.rotations[i][3])); //15
            frame.modelRenderersTranslations.put(this.name, new Vector3f(this.translations[i][0], this.translations[i][1], this.translations[i][2]));
            keyFrames.put(i, frame);
            frame = new KeyFrame();
        }
    }

    private void generateKeyFramesFromRange() {
        int middle = (int) Math.floor(this.size/2);
        int tier = Math.max(this.rotations.length, this.rotations.length);

        Quaternion quaternionRotationUnique = null;
        Vector3f vector3fTranslationUnique = null;
        if (this.rotations.length == 1) {
            quaternionRotationUnique = new Quaternion(this.rotations[0][0], this.rotations[0][1], this.rotations[0][2], this.rotations[0][3]);
        }
        if (this.translations.length == 1) {
            vector3fTranslationUnique = new Vector3f(this.translations[0][0], this.translations[0][1], this.translations[0][2]);
        }

        KeyFrame frame = new KeyFrame();
        for (int i = 0; i < this.size; i++) {
            if (quaternionRotationUnique != null) {
                frame.modelRenderersRotations.put(this.name, quaternionRotationUnique);
            } else {
                float x = this.rotations[i][0];
                float y = this.rotations[i][1];
                float z = this.rotations[i][2];
                float w = this.rotations[i][3];

            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public boolean isMirror() {
        return mirror;
    }

    public void setMirror(boolean mirror) {
        this.mirror = mirror;
    }

    public EnumAnimationMode getMode() {
        return mode;
    }

    public void setMode(EnumAnimationMode mode) {
        this.mode = mode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}