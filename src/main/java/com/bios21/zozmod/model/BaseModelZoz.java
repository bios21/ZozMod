package com.bios21.zozmod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

/**
 * Created by Asus on 23/06/2015.
 */
public abstract class BaseModelZoz extends ModelBase {
    public void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public abstract void setRotation(final float x, final float y, final float z);
}