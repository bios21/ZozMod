package com.bios21.zozmod.animations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by l.sagetlethias on 25/06/2015.
 */
public abstract class RangeInfos {
    public enum EnumRangeStep {
        INCREASE("+"), DECREASE("-"), STILL("=");
        public final String value;
        EnumRangeStep(final String value) {
            this.value = value;
        }
    }

    public Map<String, EnumRangeStep> firstSteps;
    public Map<String, EnumRangeStep> thenSteps;

    protected RangeInfos(final String[] valueNames) {
        this.firstSteps = new HashMap<>(valueNames.length);
        this.thenSteps = new HashMap<>(valueNames.length);
        Arrays.asList(valueNames).parallelStream().forEach(i -> {
            this.firstSteps.put(i, EnumRangeStep.STILL);
            this.thenSteps.put(i, EnumRangeStep.STILL);
        });
    }
}