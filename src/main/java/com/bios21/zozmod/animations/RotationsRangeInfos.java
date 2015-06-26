package com.bios21.zozmod.animations;

import java.util.Arrays;

/**
 * Created by l.sagetlethias on 25/06/2015.
 */
public class RotationsRangeInfos extends RangeInfos {
    private final static String[] valueNames = {"x", "y", "z", "w"};

    public RotationsRangeInfos() {
        super(valueNames);
    }

    public RotationsRangeInfos(final EnumRangeStep... steps) {
        this();
        final int[] idx = {0};
        Arrays.stream(steps).forEachOrdered(step -> this.firstSteps.put(valueNames[idx[0]++], step));
    }

    public void setThenSteps(final EnumRangeStep... steps) {
        final int[] idx = {0};
        Arrays.stream(steps).forEachOrdered(step -> this.thenSteps.put(valueNames[idx[0]++], step));
    }

    @Override
    public EnumRangeStep[] getFirstStepsAsArray() {
        EnumRangeStep[] ret = {
                this.firstSteps.get("x"),
                this.firstSteps.get("y"),
                this.firstSteps.get("z"),
                this.firstSteps.get("w")
        };

        return ret;
    }

    @Override
    public EnumRangeStep[] getThenStepsAsArray() {
        EnumRangeStep[] ret = {
                this.thenSteps.get("x"),
                this.thenSteps.get("y"),
                this.thenSteps.get("z"),
                this.thenSteps.get("w")
        };

        return ret;
    }
}
