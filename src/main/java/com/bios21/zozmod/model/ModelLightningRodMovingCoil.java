package com.bios21.zozmod.model;

import com.bios21.zozmod.lib.MCAClientLibrary.MCAModelRenderer;
import com.bios21.zozmod.lib.MCACommonLibray.MCAVersionChecker;
import com.bios21.zozmod.lib.MCACommonLibray.animation.AnimationHandler;
import com.bios21.zozmod.lib.MCACommonLibray.math.Matrix4f;
import com.bios21.zozmod.lib.MCACommonLibray.math.Quaternion;
import com.bios21.zozmod.tileentity.BaseTileEntityZoz;
import com.bios21.zozmod.tileentity.TileLightningRod;
import net.minecraft.entity.Entity;

import java.util.HashMap;

/**
 * Created by Asus on 24/06/2015.
 */
public class ModelLightningRodMovingCoil extends BaseModelZoz implements IModelTileEntity {
    public final int MCA_MIN_REQUESTED_VERSION = 1;
    public HashMap<String, MCAModelRenderer> parts = new HashMap<String, MCAModelRenderer>();
    public BaseTileEntityZoz tileLightningRod;

    MCAModelRenderer movingCoil;

    public ModelLightningRodMovingCoil() {
        MCAVersionChecker.checkForLibraryVersion(getClass(), MCA_MIN_REQUESTED_VERSION);

        textureWidth = 32;
        textureHeight = 32;


        movingCoil = new MCAModelRenderer(this, "MovingCoil", 0, 24);
        movingCoil.mirror = false;
        movingCoil.addBox(-2.0F, -1.0F, -2.0F, 4, 1, 4);
        movingCoil.setInitialRotationPoint(0.0F, -16.0F, 2.0F);
        movingCoil.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
        movingCoil.setTextureSize(32, 32);
        parts.put(movingCoil.boxName, movingCoil);
    }

    @Override
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        //Render every non-child part
        movingCoil.render(par7);

        AnimationHandler.performAnimationInModel(parts, (TileLightningRod)this.tileLightningRod);
    }

    @Override
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
    }

    public MCAModelRenderer getModelRendererFromName(String name) {
        return parts.get(name) != null ? parts.get(name) : null;
    }

    @Override
    public void setRotation(float x, float y, float z) {

    }

    @Override
    public void setTileEntity(final BaseTileEntityZoz tileEntity) {
        this.tileLightningRod = tileEntity;
    }

    @Override
    public BaseTileEntityZoz getTileEntity() {
        return this.tileLightningRod;
    }
}
