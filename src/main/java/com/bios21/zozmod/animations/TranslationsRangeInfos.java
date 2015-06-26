package com.bios21.zozmod.animations;

import java.util.Arrays;

/**
 * Created by Asus on 25/06/2015.
 */
public class TranslationsRangeInfos extends RangeInfos {
    private final static String[] valueNames = {"x", "y", "z"};

    public TranslationsRangeInfos() {
        super(valueNames);
    }

    public TranslationsRangeInfos(final EnumRangeStep... steps) {
        this();
        final int[] idx = {0};
        Arrays.stream(steps).forEachOrdered(step -> this.firstSteps.put(valueNames[idx[0]++], step));
    }

    public void setThenSteps(final EnumRangeStep... steps) {
        final int[] idx = {0};
        Arrays.stream(steps).forEachOrdered(step -> this.thenSteps.put(valueNames[idx[0]++], step));
    }
}