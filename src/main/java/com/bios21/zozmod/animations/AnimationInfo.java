package com.bios21.zozmod.animations;

import com.bios21.zozmod.lib.MCACommonLibray.animation.KeyFrame;
import com.bios21.zozmod.lib.MCACommonLibray.math.Quaternion;
import com.bios21.zozmod.lib.MCACommonLibray.math.Vector3f;
import com.bios21.zozmod.utils.ZozUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

    /**
     * Animation Name
     */
    private String name = "";
    /**
     * Array or range. In array, all values are used.
     * In range, [n - 2(or 3)] values between the two steps are generated
     */
    private EnumAnimationMode mode = EnumAnimationMode.ARRAY;
    /**
     * When direct and range, only two steps are used (so, one modifier array)
     */
    private boolean direct = false;
    /**
     * Number of frames
     */
    private int size = 0;
    /**
     * Frame per second
     */
    private int fps = 0;
    /**
     * Animation is looping or linear
     */
    private boolean loop = false;
    /**
     * Rotations values [x][y][z][angle]
     * e.g.:
     * [0.0, 0.0, 0.0, 1.0],
     * [0.0, 1.0, 0.0, 0.0],
     * [0.0, 0.0, 0.0, 1.0]
     *
     * One line when no rotation
     * Two lines on range direct
     * Three lines on range with step
     * N lines on array
     */
    private float[][] rotations;
    /**
     * Translations values [x][y][z]
     * e.g.:
     * [0.0, -16.0, 2.0]
     *
     * One line when no translation
     * Two lines on range direct
     * Three lines on range with step
     * N lines on array
     */
    private float [][] translations;
    /**
     * KeyFrames generated from arrays
     */
    private Map<Integer, KeyFrame> keyFrames;

    // when range mode
    private RotationsRangeInfos rotationsRangeInfos;
    private TranslationsRangeInfos translationsRangeInfos;

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
            frame.modelRenderersRotations.put(this.name, new Quaternion(this.rotations[i][0], this.rotations[i][1], this.rotations[i][2], this.rotations[i][3]));
            frame.modelRenderersTranslations.put(this.name, new Vector3f(this.translations[i][0], this.translations[i][1], this.translations[i][2]));
            keyFrames.put(i, frame);
            frame = new KeyFrame();
        }
    }

    private void generateKeyFramesFromRange() {
        int middle = (int) Math.floor(this.size/2);
        int tier = Math.max(this.rotations.length, this.rotations.length);
        if (tier > 3) return;

        Quaternion quaternionRotationUnique = null;
        Vector3f vector3fTranslationUnique = null;
        if (this.rotations.length == 1) {
            quaternionRotationUnique = new Quaternion(this.rotations[0][0], this.rotations[0][1], this.rotations[0][2], this.rotations[0][3]);
        }
        if (this.translations.length == 1) {
            vector3fTranslationUnique = new Vector3f(this.translations[0][0], this.translations[0][1], this.translations[0][2]);
        }

        float[][] newRotations = (tier == 2
                ? handle2TiersRange(this.rotations[0], this.rotations[1], true, true, this.size)
                : handle3TiersRange(this.rotations[0], this.rotations[1], this.rotations[2], true, middle));
        float[][] newTranslations = (tier == 2
                ? handle2TiersRange(this.translations[0], this.translations[1], false, true, this.size)
                : handle3TiersRange(this.translations[0], this.translations[1], this.translations[2], false, middle));
        KeyFrame frame = new KeyFrame();
        for (int i = 0; i < this.size; i++) {
            if (quaternionRotationUnique != null) {
                frame.modelRenderersRotations.put(this.name, quaternionRotationUnique);
            } else {
                frame.modelRenderersRotations.put(this.name, new Quaternion(newRotations[i][0], newRotations[i][1], newRotations[i][2], newRotations[i][3]));
            }

            if (vector3fTranslationUnique != null) {
                frame.modelRenderersTranslations.put(this.name, vector3fTranslationUnique);
            } else {
                frame.modelRenderersTranslations.put(this.name, new Vector3f(newTranslations[i][0], newTranslations[i][1], newTranslations[i][2]));
            }
            keyFrames.put(i, frame);
            frame = new KeyFrame();
        }

    }

    private float[][] handle2TiersRange(float[] tierA, float[] tierB, boolean rotations, boolean first, int tierSize) {
        int iRot = (rotations ? 4 : 3);
        List<Float> dividedSteps = new ArrayList<>(iRot);
        dividedSteps.add(Math.abs(tierB[0] - tierA[0]) / tierSize);
        dividedSteps.add(Math.abs(tierB[1] - tierA[1]) / tierSize);
        dividedSteps.add(Math.abs(tierB[2] - tierA[2]) / tierSize);
        if (rotations) {
            dividedSteps.add(Math.abs(tierB[3] - tierA[3]) / tierSize);
        }
        RangeInfos rangeInfos = (rotations ? this.rotationsRangeInfos : this.translationsRangeInfos);
        RangeInfos.EnumRangeStep[] rangeSteps = (first ? rangeInfos.getFirstStepsAsArray() : rangeInfos.getThenStepsAsArray());

        float[][] temp = new float[tierSize][iRot];
        for(int i = 0; i < iRot; i++) {
            float previous = tierA[i];
            for(int j = 1; j < tierSize; j++) {
                switch (rangeSteps[i]) {
                    case DECREASE:
                        temp[j][i] = previous - dividedSteps.get(i);
                        break;
                    case INCREASE:
                        temp[j][i] = previous + dividedSteps.get(i);
                        break;
                    case STILL:
                    default:
                        temp[j][i] = previous;
                        break;
                }
                previous = temp[j][i];
            }
        }

        return temp;
    }

    private float[][] handle3TiersRange(float[] tierA, float[] tierB, float[] tierC, boolean rotations, int middle) {
        return ArrayUtils.addAll(
                handle2TiersRange(tierA, tierB, rotations, true, middle),
                handle2TiersRange(tierB, tierC, rotations, false, this.size-middle)
        );
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

    public boolean isDirect() {
        return direct;
    }

    public void setDirect(boolean direct) {
        this.direct = direct;
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