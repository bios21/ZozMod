package com.bios21.zozmod.animations;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by l.sagetlethias on 25/06/2015.
 */
public class RotationsRangeInfos extends RangeInfos {
    private final static String[] valueNames = {"x", "y", "z", "w"};

    public RotationsRangeInfos() {
        super(valueNames);
    }
    public RotationsRangeInfos(EnumRangeStep... steps) {
        this();
//        this.firstSteps.put("x", xStep);
//        this.firstSteps.pu
        int idx = 0;
        Arrays.stream(steps).forEachOrdered(step -> this.firstSteps.put(valueNames[idx++], step));
    }
}
