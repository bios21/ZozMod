package com.bios21.zozmod.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by Asus on 23/06/2015.
 */
public class ModelLightningRodGlobe extends BaseModelZoz {
    ModelRenderer globe;

    public ModelLightningRodGlobe() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.globe = new ModelRenderer(this, 8, 0);
        this.globe.addBox(0F, 0F, 0F, 4, 4, 4);
        this.globe.setRotationPoint(-2F, 13F, -2F);
        this.globe.setTextureSize(this.textureWidth, this.textureHeight);
        this.globe.mirror = true;
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.globe.render(f5);
    }

    @Override
    public void setRotation(float x, float y, float z) {
        this.setRotation(this.globe, x, y, z);
    }
}