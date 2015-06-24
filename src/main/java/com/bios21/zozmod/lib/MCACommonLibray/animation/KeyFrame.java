package com.bios21.zozmod.lib.MCACommonLibray.animation;


import com.bios21.zozmod.lib.MCACommonLibray.math.Quaternion;
import com.bios21.zozmod.lib.MCACommonLibray.math.Vector3f;

import java.util.HashMap;

public class KeyFrame {
    public HashMap<String, Quaternion> modelRenderersRotations = new HashMap<String, Quaternion>();
    public HashMap<String, Vector3f> modelRenderersTranslations = new HashMap<String, Vector3f>();

    public boolean useBoxInRotations(String boxName) {
        return modelRenderersRotations.get(boxName) != null;
    }

    public boolean useBoxInTranslations(String boxName) {
        return modelRenderersTranslations.get(boxName) != null;
    }
}